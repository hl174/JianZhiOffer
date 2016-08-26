package DissipateThinking;
/**
 * 不用加减乘除做加法
 * @author HL
 *题目描述
 *写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Solution48 {
    public int Add(int num1,int num2) {
        /**
         * 这题首先考虑的是用位运算，先算出没进位的，然后算出有进位的，然后重复上述步骤知道没进位
         * 
         * 35ms 654k
         */
    	
    	int nobit,wei;
    	do{
        	 nobit=num1^num2;
        	 wei=(num1&num2)<<1;
        	 num1=nobit;
        	 num2=wei;
    	}while(num2!=0);
    	return num1;
    }

}
