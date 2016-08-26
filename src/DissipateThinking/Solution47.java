package DissipateThinking;
/**
 * 求1+2+3+...+n
 * @author HL
 *题目描述
 *求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Solution47 {
    public static int Sum_Solution(int n) {
        /**
         * 这题不能用乘除法，就只有用递归构造函数了
         * n为0的时候可以作为递归终止的条件
         * 
         * 35ms 654k
         */
    	int temp=n;
    	boolean flag=temp>0&&(((temp+=Sum_Solution(n-1))==0));
    	return temp;
    }

    public static void main(String[] args) {
		System.out.println(Sum_Solution(100));
	}
}

