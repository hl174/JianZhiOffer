package KnowledgeTransfer;
/**
 * 二叉树的深度
 * @author HL
 *题目描述
 *输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 *最长路径的长度为树的深度。
 */
public class Solution38 {
    public int TreeDepth(TreeNode root) {
       /**
        * 只有用递归的方式来计算
        * 34ms 503k
        */
    	if(root==null) return 0;
      
    	return Math.max(TreeDepth(root.left)+1,TreeDepth(root.right)+1);
    }
}
