package Tree;
/**
 * 
 * @author HL
 *
 */
public class Solution61 {
	//考虑用层序遍历的方式来存储
	   String Serialize(TreeNode root) {
       /**
        * 层序遍历，没有的节点用#表示
        * 
        * 53ms 905k
        */
		  if(root==null) return "#,";
		  String result="";
		  result+=root.val+",";
		  result+=Serialize(root.left);
		  result+=Serialize(root.right);
		  return result.substring(0, result.length()-1);//去掉最后的逗号 
	   }
	 
	   public int index=-1;
	     TreeNode Deserialize(String str) {
		      int len=str.length();
		      if(index++>=len) return null;
		      String[] chs=str.split(",");
		      TreeNode p=null;
		      if(!chs[index].equals("#")){
		    	  p=new TreeNode(Integer.valueOf(chs[index]));
		    	  p.left=Deserialize(str);
		    	  p.right=Deserialize(str);
		      }
		      return p;
	   }
}
