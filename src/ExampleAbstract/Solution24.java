package ExampleAbstract;

import java.util.ArrayList;
import java.util.Stack;
/**
 * 二叉树中和为某一值的路径
 * @author HL
 *题目描述
 *输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class Solution24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    	/**
    	 * 
    	 *   需要一个栈来保存访问过的，方便回退；同时判断的过程显然是一个递归的过程
    	 *   
    	 *   44ms 528k
    	 */
    	ArrayList<ArrayList<Integer>>  result=new ArrayList<>();
    	  Stack<TreeNode> stack=new Stack<>();//存放父节点的栈
    	  deepfind(root, result, target, stack);
    	  return result;
   }  
    
    public void deepfind(TreeNode root,ArrayList<ArrayList<Integer>> result,int leftTarget,Stack<TreeNode> stack){
    	if(root==null) return;//null值
    	if(root.left==null&&root.right==null){//叶子节点
    		if(root.val==leftTarget){//保存这条路径
    			ArrayList<Integer> list=new ArrayList<>();
    			for(TreeNode t:stack){//这种增强for循环对stack是正序的遍历，与pop相反
    			  list.add(t.val);	
    			}
    			list.add(root.val);
    			result.add(list);	
    		}
    		
    	}else{//非叶子节点
    	     stack.push(root);
    	     deepfind(root.left, result, leftTarget-root.val, stack);
    	     deepfind(root.right, result, leftTarget-root.val, stack);
    	     //父节点回退查找
    	     stack.pop();//栈回退
    	}
    }
    
}
