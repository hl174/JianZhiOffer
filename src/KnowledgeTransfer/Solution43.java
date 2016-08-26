package KnowledgeTransfer;
/**
 * 左旋转字符串
 * @author HL
 *题目描述
 *汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 *对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 *例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Solution43 {
    public String LeftRotateString(String str,int n) {
    	/**
    	 * 37ms 654k 
    	 * 直接用一个char数组来存放变位后的东西
    	 * 
    	 * 当然还有一种做法是用拼接，找到拼接点，前后翻转拼接
    	 * 
    	 */
        if(str==null||str.trim().length()==0||n==0)  return str;
        int len=str.length();
        char[] c=str.toCharArray();
        for(int i=0;i<str.length();i++){
        	if(i-n%len<0){
        		c[i-n%len+len]=str.charAt(i);
        	}else
        	  c[i-n%len]=str.charAt(i);
        }
    	return new String(c);
    }
}
