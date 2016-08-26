package Comprehensive;
/**
 * 把字符串转换成整数
 * @author HL
 *题目描述
 *将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 */
public class Solution49 {
    public static int StrToInt(String str) {
       	/**
    	 * 字符串万一超过了整数的最大范围呢？（这里没说整数是啥，long还是int,就按int算吧）
    	 * 
    	 * 这里自己定义下规则吧：
    	 *   正负数的话就原样输出，非数就输出0，大于整数的部分就输出0
    	 *   
    	 *   37ms 654k
    	 */
        if(str==null||str.trim().length()==0) return 0;
		long result=0;
    	int flag=1;
    	if(str.charAt(0)=='-'){
    		str=str.substring(1);
    		flag=-1;
    	}else if(str.charAt(0)=='+'){
    		str=str.substring(1);
    	}else if(str.charAt(0)>'9'||str.charAt(0)<'0'){
    		return 0;//不是整数
    	}
     		
    		for(int i=0;i<str.length();i++){
    			if(str.charAt(i)<='9'&&str.charAt(i)>='0')
    			result+=(str.charAt(i)-'0')*Math.pow(10,str.length()-1-i);    
        		else
        			return 0;	
    		}
    	
    	
    	if(flag*result>Integer.MAX_VALUE||flag*result<Integer.MIN_VALUE)
          return 0;
    	return (int)(flag*result);   
    }
    
    public static void main(String[] args) {
		System.out.println(StrToInt("+123"));
	}

}
