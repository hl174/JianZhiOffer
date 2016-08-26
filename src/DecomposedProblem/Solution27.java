package DecomposedProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 字符串的排列
 * @author HL
 *题目描述
     输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 结果请按字母顺序输出。 
     输入描述:
     输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
  */
public class Solution27 {
	  public static ArrayList<String> Permutation(String str) {
		  /**
		   * 字符串的排列可以用循环递归的方式来解决
		   * 
		   * 想象成字符交换的过程，第一个字符与后面的字符交换，完了之后再后面的字符的第一个字符与其后面的字符交换
		   */
	       ArrayList<String> result=new ArrayList<>();
	       if(str==null||str.length()==0) return result;
	       HashSet<String> set=new HashSet<>();
	       char[] c=str.toCharArray();
	       pailie(c,0,c.length-1,set);
	       for(String s:set){
	    	   result.add(s);
	       }
	       Collections.sort(result);
	       return result;
	    }
	  
	   public static void pailie(char[] c,int start,int end,HashSet<String> set){
		   
		 if(start==end){
			 //类似对单个进行排列
			 String temp="";
			for(int i=0;i<=end;i++){
				temp+=c[i];
			}
			 set.add(temp);//加入最终结果
			 
		 }else{
			 for(int i=start;i<=end;i++){
				 char t=c[start];  
				 c[start]=c[i];
				 c[i]=t;//交换			
				 
				   pailie(c, start+1, end, set);//在前一步基础上进行迭代
				   
				 //迭代完毕后，数组的还原
				     t=c[start];
					 c[start]=c[i];
					 c[i]=t;//交换回来
			 }
			 
		 }
		 
	 }
}
