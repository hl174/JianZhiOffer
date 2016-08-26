package KnowledgeTransfer;
/**
 * 平衡二叉树
 * @author HL
 *题目描述
 *输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution39 {
	  public boolean IsBalanced_Solution(TreeNode root) {
		   /**
		    * 考虑和上题一样，用递归来解决
		    * 平衡树：任何节点的左右子树的高度差不超过1
		    * 38ms 654k
		    */
		    	if(root==null) return true;
		    	if(Math.abs(deep(root.left)-deep(root.right))>1)
		    	return false;
		        else
		            return true;
		    	
		    }
		    
		    public int deep(TreeNode p){
		    	if(p==null) return 0;
		    	return Math.max(deep(p.left)+1, deep(p.right)+1);
		    }
}
