package Tree;

import java.util.*;

/**
 * 把二叉树打印成多行
 * @author HL
 *题目描述
 *从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution60 {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	/**
    	 *和上一题类似，不过这题貌似梗简单，用队列就可以搞定 
    	 *
    	 *34ms 699k
    	 */
    	ArrayList<ArrayList<Integer> > result=new ArrayList<>();
    	  if(pRoot==null) return result;
    	  Queue<TreeNode> queue=new LinkedList<>(); 
    	  queue.add(pRoot);
    	  while(!queue.isEmpty()){
    		  ArrayList<Integer> temp=new ArrayList<>();
    		  int size=queue.size();
    		  while(size>0){
    			  TreeNode t=queue.poll();
    			  size--;
    			  temp.add(t.val);
    			  if(t.left!=null)
    				  queue.add(t.left);
    			  if(t.right!=null)
    				  queue.add(t.right);
    		  }
    		  result.add(temp);
    	  }			
    	
    	return result;
    }
    
}
