package String;
/**
 * 正则表达式匹配
 * @author HL
 *题目描述
 *请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 *而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例
 *如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution52 {
    public static boolean match(char[] str, char[] pattern)
    {
     /**
      * 这题因为情况多，且有循环的意图，因此肯定是要用递归要完成的   
      * 29ms 503k
      */
    	return diguimatch(str,0,pattern,0);
    }
    
    public static boolean diguimatch(char []str,int strIndex,char[] pattern,int patternIndex){
    	if(strIndex>=str.length&&patternIndex>=pattern.length)
    		return true;//都匹配完毕
    	if(strIndex<str.length&&patternIndex>=pattern.length)
    		return false;//模式没了，字符串还有
    	//字符串没了，模式还有
		if(strIndex>=str.length){
			if(patternIndex+1<pattern.length&&pattern[patternIndex+1]=='*')
			return diguimatch(str, strIndex, pattern, patternIndex+2); 
			else 
			return false;
		}
	

		/**
		 * 当模式串中后有*号时，
		 *    1，模式串直接后移两位（*表示0到多个）
		 *    2，若模式串字符和字符串字符相等，字符串则后移一个，则模式串有2种情况
		 *     2.1 模式串后移一个
		 *     2.2模式串不变
		 * 
		 */
    	if(patternIndex+1<pattern.length&&pattern[patternIndex+1]=='*'){
    		
    		if(str[strIndex]==pattern[patternIndex]||pattern[patternIndex]=='.'){
    			return diguimatch(str, strIndex+1, pattern, patternIndex+2)||
    					diguimatch(str, strIndex+1, pattern, patternIndex)||
    					diguimatch(str, strIndex, pattern, patternIndex+2);
    					
    		}else
    			return diguimatch(str, strIndex, pattern, patternIndex+2); //不匹配，模式串后移2位
		}
		

    	//第二个不是*的时候就一个个的比较
    	if(str[strIndex]==pattern[patternIndex]||pattern[patternIndex]=='.')
    		return diguimatch(str, strIndex+1, pattern, patternIndex+1);
    	return false;
    }
    public static void main(String[] args) {
    	char[] s1="".toCharArray();
    	char[] s2=".*".toCharArray();
		System.out.println(match(s1,s2));
	}
}
