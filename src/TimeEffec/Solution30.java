package TimeEffec;

import java.util.*;

/**
 * 连续子数组的最大和
 * @author HL
 *题目描述
 *HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:
 *在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 *但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 *例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 *你会不会被他忽悠住？
 */
public class Solution30 {
	 public static int FindGreatestSumOfSubArray(int[] array) {
		 
		    /**
		     * 用一个当前的tempsum来实时保存最大的值，并与上次的最大值进行比较
		     * 32ms 503k
		     * 
		     * 当然我们还可以求出最大子序列的下标始末位置
		     */
	      if(array==null||array.length==0) return 0;
	        int result=array[0],sum=array[0];
	        for (int i = 1; i < array.length; i++) {
				sum+=array[i];
				if(sum>result)
					result=sum;
				else if(sum<=0){
					sum=0;
				}
			}
	        return result;
		 
		 //尝试用动态规划的方式做
		 /**
		  * dp[i]表示到下标i结尾的位置最大连续子和
		  * 
		  * dp[i] =a[i]                当dp[i-1]<0&&dp[i-1]<a[i]
		  *       =dp[i-1]+a[i]       其他情况
		  *   初始时，dp[0]=a[i]
		  * 
		  * dp[]数组只是到每个下标的数的值
		  * 
		  * 33ms 629k
		  */
	/*	 int[]dp=new int[array.length];
		 dp[0]=array[0];
		 for(int i=1;i<array.length;i++){
			 if(dp[i-1]<0&&dp[i-1]<array[i])
				 dp[i]=array[i];
			 else
				 dp[i]=dp[i-1]+array[i];
		 }
		 Arrays.sort(dp);
		 return dp[array.length-1];*/
	    }
	 
	 public static void main(String[] args) {
	   int[]a={6,-3,-2,7,-15,1,2,2};
	   System.out.println(FindGreatestSumOfSubArray(a));
	   
	   
	}
}
