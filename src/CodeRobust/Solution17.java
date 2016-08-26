package CodeRobust;
/**
 * 树的子结构
 * @author HL
 *输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        /**
         * 先考虑根节点的值是否一样，再考虑其左右子树，判断的过程中可以考虑用递归
         * 
         * 39ms 528k
         * 
         */
    	if(root2==null||root1==null) return false;
    	boolean result=false;
    	if(root1.val==root2.val){
    	result=checkPart(root1, root2);
    	}
    	if(!result){
    		result=checkPart(root1.left, root2);
    	}
    	if(!result)
    		result=checkPart(root1.right, root2);
    	return result;
    }

	public boolean checkPart(TreeNode root1, TreeNode root2) {
		if(root2==null)//核对完毕
			return true;
		if(root1==null)
			return false;

		  if(root1.val==root2.val)
				return checkPart(root1.left, root2.left)&&checkPart(root1.right, root2.right);
		  else
			  return false;
		}
    
    
}
