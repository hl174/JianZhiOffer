package TimeSpace;

import java.util.Scanner;

/**
 * 找出字符串中第一个只出现一次的字符
 * @author HL
 *题目描述

找出字符串中第一个只出现一次的字符
详细描述：
接口说明
原型：
bool FindChar(char* pInputString, char* pChar);
输入参数：
char* pInputString：字符串
输出参数（指针指向的内存区域保证有效）：
char* pChar：第一个只出现一次的字符
如果无此字符 请输出'.'
 
 
 

输入描述:
输入一串字符,由小写字母组成


输出描述:
输出一个字符

输入例子:
asdfasdfo

输出例子:
o
 */
public class Solution34 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			String str=sc.nextLine().trim();
			System.out.println(FirstNotRepeatingChar(str));
		}
	}
	 public static char FirstNotRepeatingChar(String str) {
	      /**
	       * 还是用256个字符数组来表示
	       * 25ms 402k
	       */
	       int []c=new int[256];
	       for(int i=0;i<str.length();i++){
	    	   c[str.charAt(i)-'0']++;
	       }
	       for(int i=0;i<str.length();i++){
	    	   if(c[str.charAt(i)-'0']==1)
	    		   return str.charAt(i);
	       }
		 
		 return '.';
	    }

}
