package TimeEffec;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 * @author HL
 *题目描述
 *输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution32 {
    public static String PrintMinNumber(int [] numbers) {
        /**
         * 还是暂时考虑用一种类似冒泡排序的方法来进行，自己构造一种比较字符串的方法
         * 
         * 39ms 654k
         */
    	String result="";
    	if(numbers==null||numbers.length==0) return result;
    	String[] s=new String[numbers.length];
    	for (int i = 0; i < s.length; i++) {
			s[i]=numbers[i]+"";
		}
    	for(int i=0;i<s.length-1;i++){//比较的次数  		
    		for(int j=0;j<s.length-1-i;j++){
    			if(compare(s[j], s[j+1])>0){
    				String t=s[j];
    				s[j]=s[j+1];
    				s[j+1]=t;
    			}
    		}
    		
    	}
    	
    	for( String ss:s){
    		result+=ss;
    	}
    	return result;
    	
    }
    
    /**
     * 自定义一种字符串比较方式
     * @param s1
     * @param s2
     * @return
     */
    public static int compare(String s1,String s2){
    	return (s1+s2).compareTo(s2+s1);
    }
    
    public static void main(String[] args) {
		int[]a={3,5,1,4,2};
		System.out.println(PrintMinNumber(a));
		System.out.println("51".compareTo("15"));
	}
}
