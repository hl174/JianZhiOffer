package String;

import java.util.Arrays;

/**
 * 替换空格
 * @author HL
 * 
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 */
public class Solution2 {
	/**
	 * 暴力法的话就没意思 35ms 518k
	 * 
	 * 31ms 503k
	 */
	 public static String replaceSpace(StringBuffer str) {
	    /**建立两个指针，从后往前复制，首先计算好复制后的总长度
	     * 
	     */
		 int count=0;
		 for(int i=0;i<str.length();i++){
			 if(str.charAt(i)==' ')
				 count++;
		 }
		 
		 int p1=str.length()-1,p2=str.length()+count*2-1;
		 char[]s1=new char[p2+1]; 
		 System.arraycopy(str.toString().toCharArray(), 0, s1, 0, str.length());
		 while(p1>=0&&p2>p1){
			 if(s1[p1]==' '){//遇到空格
				 s1[p2--]='0';
				 s1[p2--]='2';
				 s1[p2--]='%';
			 }
			 else{//遇到单词，则复制
				 s1[p2--]=s1[p1];
			 }
			 p1--;
			 //遇到空格了		 
		 }
		 return new String(s1);
	    }
	 public static void main(String[] args) {
		System.out.println(replaceSpace(new StringBuffer("h d")));
	}
}
