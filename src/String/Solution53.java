package String;
/**
 * 表示数值的字符串
 * @author HL
 *题目描述
 *请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution53 {
    public static boolean isNumeric(char[] str) {
        /**
         * 字母只能出现E/e,且e前有数字，e后为整数
         *注意小数点和正负号
         *
         *29ms 688k
         */
    	if(str==null||str.length==0) return false;
    	if((str[0]>'9'||str[0]<'0')&&str.length==1) return false;
    	for(int i=1;i<str.length;i++){
    		if(str[i]=='e'||str[i]=='E'){
    			if(i==1&&(str[0]=='+'||str[0]=='-'))
    				return false;
    			//检查e后是否为整数
    			return checkEx(str,i+1);
    		}
    		if(str[i]=='.')
    			//检查后面是否合法
    			return checkPoint(str,i+1);
    		if(str[i]<'0'||str[i]>'9')
    			return false;
    	}
    	return true;
    }
    
    /**
     * 检查e后面是否有数字，且是否是整数
     * @param str
     * @param index
     * @return
     */
    public static boolean checkEx(char[] str,int index){
    	if(index>=str.length) return false;
    	if(str[index]=='+'||str[index]=='-')
    		index++;
    	for(int i=index;i<str.length;i++){
    		if(str[i]<'0'||str[i]>'9')
    			return false;
    	}
    	return true;
    }
    
    /**
     * 检查小数点后面的数
     * @param str
     * @param index
     * @return
     */
    public static boolean checkPoint(char[] str,int index){
    	if(index>=str.length) return false;
    	for(int i=index;i<str.length;i++){
    		if(str[i]=='e'||str[i]=='E')
    			return checkEx(str, i+1);
    		
    		if(str[i]<'0'||str[i]>'9')
    			return false;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
		System.out.println(isNumeric("5e2".toCharArray()));
	}
}
