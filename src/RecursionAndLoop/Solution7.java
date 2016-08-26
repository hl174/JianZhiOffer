package RecursionAndLoop;
/**
 * 斐波那契数列
 * @author HL
 *大家都知道斐波那契数列，现在要求输入一个整数n，
 *请你输出斐波那契数列的第n项。n<=39
 */
public class Solution7 {
	 public int Fibonacci(int n) {
          /**
           * 递归的时候当数很大的时候可能会出现内存卡死的情况
           * 
           * 36ms 645k
           */
		 if(n==0) return 0;
		 if(n==1) return 1;
		 int a=0,b=1,result=-1;
		 for(int i=2;i<=n;i++){
			 result=a+b;
			 a=b;
			 b=result;
		 }
		 return result;
	    }
}
