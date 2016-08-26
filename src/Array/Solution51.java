package Array;
/**
 * 构建乘积数组
 * @author HL
 *题目描述
 *给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Solution51 {
    public int[] multiply(int[] A) {
         /**
          * 这题没办法，分成两部分连乘好了
          * 36ms 528k
          */
    	  if(A==null||A.length<=1) return new int[]{};
          int[] B=new int[A.length];
          B[0]=diedai(A, 1, A.length-1);
          B[A.length-1]=diedai(A, 0, A.length-2);
          for (int i = 1; i < B.length-1; i++) {
 			B[i]=diedai(A, 0, i-1)*diedai(A, i+1,A.length-1);
 		}
          return B;
 	    }

 	  int diedai(int a[],int start,int end){
 		  int result=1;
 		  for (int i = start; i <=end; i++) {
 			result*=a[i];
 		}
 		  return result;
     }

}
