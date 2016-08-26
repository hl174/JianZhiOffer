package Tree;

import java.util.*;

import sun.reflect.generics.tree.Tree;

/**
 * 对称的二叉树
 * @author HL
 *题目描述
 *请实现一个函数，用来判断一颗二叉树是不是对称的。
 *注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution58 {
	   boolean isSymmetrical(TreeNode pRoot)
	    {
	        /**
	         * 第一感觉是要用递归判断的方式来判断
	         * 
	         * 33ms 629k
	         */
		   
		   if(pRoot==null) return true;
		return  diguicheck(pRoot.left,pRoot.right);
		
	    }
	   
	   boolean diguicheck(TreeNode left,TreeNode right){
		   if(left==null&&right==null)
			   return true;
		   if(left==null||right==null)
			   return false;
		   if(left.val!=right.val)
			   return false;
		   return diguicheck(left.left, right.right)&&diguicheck(left.right, right.left);
	   }
}
