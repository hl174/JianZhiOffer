package ExampleAbstract;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 * @author HL
 *题目描述

从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Solution22 {
	 public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		 /**
		  * 考虑用队列保存
		  * 41ms 528k
		  */
	       ArrayList<Integer> result=new ArrayList();
	       if(root==null) return result;
	       Queue<TreeNode> queue=new LinkedList<>();
	       queue.add(root);       
	       while(!queue.isEmpty()){
	    	   TreeNode temp=queue.poll();
	    	   result.add(temp.val);
	    	   if(temp.left!=null){
	    		   queue.add(temp.left);
	    	   }
	    	   if(temp.right!=null){
	    		   queue.add(temp.right);
	    	   }
	       }
	       return result;
	    }
}
