package Tree;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * 二叉搜索树的第k个结点
 * @author HL
 *题目描述
 *给定一颗二叉搜索树，请找出其中的第k小的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class Solution62 {
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        /**
         * 中序遍历的顺序就是大小的排序顺序
         * 
         * 还是用栈来实现
         * 
         * 42ms 654k
         */
    	if(pRoot==null||k<=0) return null;
      
    	k1=k;
      return midsort(pRoot);
    }
    public int k1;//如果写在里面就在牛客上无法通过
    public TreeNode midsort(TreeNode p){
    	 TreeNode temp=null;
          if(p.left!=null)
        	  temp=midsort(p.left);
          if(temp==null){//不在其左子树上，则在右子树或者就是本节点上
        	  if(k1--==1)
        		  temp= p;//就是当前节点
    
          }   	  
        	  if(temp==null&&p.right!=null)
        		  temp=midsort(p.right);
        	  
          return temp;        	  
    }
      
}
