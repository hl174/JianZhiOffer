package InterviewIdeas;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的镜像
 * @author HL
 *题目描述

操作给定的二叉树，将其变换为源二叉树的镜像。 
输入描述:
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 */
public class Solution18 {
	  public static void Mirror(TreeNode root) {
        /**
         * 左右交换，首先考虑递归
         * 38ms 692k
         * 考虑用非递归的方式做一次，用队列吧
         * 
         */
		/*  if(root==null) return;
		  if(root!=null){
			  TreeNode temp=root.left;
			  root.left=root.right;
			  root.right=temp;  
		  }
	      Mirror(root.left);
		  Mirror(root.right);*/
		  //32ms 699k
		  Queue<TreeNode> queue=new LinkedList<>();
		  queue.add(null);
		  queue.add(null);
		  if(root==null) return;
		  queue.add(root);
		  while(!queue.isEmpty()){
			  TreeNode temp=queue.poll();
			  TreeNode tem=temp.left;
			  temp.left=temp.right;
			  temp.right=tem;
			 if(temp.left!=null) queue.add(temp.left);
			 if(temp.right!=null) queue.add(temp.right);	  
		  }

	    }
}
