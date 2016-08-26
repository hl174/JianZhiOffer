package Tree;

import java.util.*;

/**
 * 按之字形顺序打印二叉树
 * @author HL
 *题目描述
 *请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 *第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution59 {
	   public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
           /**
            * 这里保存的规律是（根节点层次是0）
            *   当前层是奇数层，先打印左边子节点，再右边子节点
            *   当前是偶数层，先打印右边子节点，再保存左边子节点
            *   所以栈的话就要反过来
            * 数据结构想到还是用栈来实现
            * 
            * 
            * 法二：这题还可以考虑全局用队列，每层用栈来做，队列的size可以用来标记是否一层结束
            * 31ms 566k
            */
		   ArrayList<ArrayList<Integer> > result=new ArrayList<>();
		   if(pRoot==null) return result;
		   Stack<TreeNode> stack=new Stack<>();
		   int count=0;//开始是0
		   stack.push(pRoot);
		   while(!stack.isEmpty()){
			   ArrayList<Integer> temp=new ArrayList<>();//存放结果
			   ArrayList<TreeNode> list=new ArrayList<>();//暂存放当前层次的所有节点
			   while(!stack.isEmpty()){
				  
				   TreeNode te= stack.pop();
				   list.add(te);
				   temp.add(te.val);
			   }
			   result.add(temp);
			   //处理子节点
			   if(count%2==0){//当前是偶数层，先打印右子节点
				   for(int i=0;i<list.size();i++){
					   if(list.get(i).left!=null)
					   stack.push(list.get(i).left);
					   if(list.get(i).right!=null)
						   stack.push(list.get(i).right);
				   }
				  
			   }else{
				   for(int i=0;i<list.size();i++){//注意这里不要用成队列的减法了，因为队列的序列和上次的输出是一致的
					   if(list.get(i).right!=null)
						   stack.push(list.get(i).right);
					   if(list.get(i).left!=null)
						   stack.push(list.get(i).left);
						   
				   }
					 
			   }   
			   count++;
		   }
		   
		   return result;
		   
		   
		   //法二：
		 /*	  ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
	          if(pRoot==null) return result;
	          Deque<TreeNode> queue=new LinkedList<TreeNode>();
	          queue.add(pRoot);
	          int count=1;
	          while(!queue.isEmpty()){
	        	  ArrayList<Integer> tem=new ArrayList<Integer>();
	        	  Stack<TreeNode> stack=new Stack<TreeNode>();
	        	  int size=queue.size();
	        	  while(size>0){
	        		  TreeNode temp=queue.poll(); 
	        		  if(count%2==1){//正序
	        		  tem.add(temp.val);
	        		  
	        		  }else{
	        			  stack.add(temp);
	        		  }
	        		  if(temp.left!=null)
	 		    		 queue.add(temp.left);
	 		    	 
	 		    	 if(temp.right!=null)
	 		    		queue.add(temp.right);

	 		    	 
	        		  size--;
	        	  }//一行打印完毕
	        	  if(count%2==0){
	        		  while(!stack.isEmpty()){
	        			  tem.add(stack.pop().val);
	        		  }
	        	  }
	        	  count++;
	        
	        	  result.add(tem);  
	          }
	          
	          
	          return result;*/
	    }
}
