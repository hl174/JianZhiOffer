package ByteCalculate;

/**
 * 二进制中1的个数
 * @author HL
 *题目描述
  输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution11 {
	public int  NumberOf1(int n) {
		/**
		 * 27ms 629k
		 */
        int count=0;
   /*     while(n!=0){
        	if((n&1)==1){
        		count++;
        	}
        	n=n>>>1;//负数的时候直接右移高位会补1，这样就是死循环了
        }*/
        while(n!=0){
        	++count;
        	n=(n-1)&n;//将最右边的1变为0，有多少1就可以进行多少次
        }
        return count;
    }
}
