package Tree;

import LinkedList.ListNode;
import sun.net.www.content.image.png;

/**
 * 二叉树的下一个结点
 * @author HL
 *题目描述
 *给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution57 {
	  public TreeLinkNode GetNext(TreeLinkNode pNode)
	    {
	        /**
	         * 如果节点有右子树，则下一个节点就是右子树的最左边的节点
	         * 如果节点没有右子树，是父节点的左孩子，父节点就是
	         *                 是父节点的右孩子，则往上找到一个是父节点的左孩子节点的节点，其父节点就是
	         *              没有父节点，null
	         *              
	         *              
	         *              35ms 731k
	         */
		  if(pNode==null)  return pNode;
		   if(pNode.right!=null){//有右孩纸
			   TreeLinkNode p=pNode.right;
			   while(p.left!=null){
				   p=p.left;
			   }
			   return p;//最左边的孩纸
		   }
		   if(pNode.next!=null){
			   TreeLinkNode next=pNode.next;//父节点
			   if(next.left==pNode)
				   return next;//父节点的左孩子
			   while(next.next!=null){
				   if(next.next.left==next)
					   return next.next;
				   next=next.next;
			   }
		   }
		  return null;
	    }
}
