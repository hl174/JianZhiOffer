package DecomposedProblem;

/**
 * 二叉搜索树与双向链表
 * @author HL
 *输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution26 {
	
	 TreeNode last=null;//公用
	 public TreeNode Convert(TreeNode pRootOfTree) {
	     /**
	      * 中序遍历的节点顺序是一个有序的序列,运用中序遍历的结果构造顺序
	      * 用一个引用指向上一个访问节点的信息
	      *    
	      *    43ms 528k
	      */
		
			TreeNode p=pRootOfTree;
			 midTraverse(p);//排序
			 while(last!=null&&last.left!=null){
				 last=last.left;
			 }
			 return last;
	    }
	 
	 public void midTraverse(TreeNode p){
	   	 if(p==null)
	   		 return;//遍历完毕
	   	 midTraverse(p.left);//中序遍历的顺序
	   	 p.left=last;//叶子节点
	   	 if(last!=null)
	 		 last.right=p;//原来的右孩子节点的话，这里其实是重复构建
	   	 last=p;
	   	 midTraverse(p.right);//中序遍历的顺序
	 }
}
