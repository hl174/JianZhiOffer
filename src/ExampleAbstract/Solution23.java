package ExampleAbstract;
/**
 * 二叉搜索树的后序遍历序列
 * @author HL
 *题目描述
     输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution23 {
	 public static boolean VerifySquenceOfBST(int [] sequence) {
	      /**
	       * 感觉需要递归，从最后开始分，前面部分的比比较数小，后面部分比比较数大；然后递归比较前后两部分
	       * 注意循环的入口和出口
	       * 33ms 528k
	       */
		 if(sequence==null||sequence.length==0) return false;
		 return check(sequence, 0, sequence.length-1);
	    }
	 
	public static boolean check(int[] a,int begin,int end){
		  //这里先不判断a是否 为null，默认是不为的
		if(begin>=end) return true;
		int i;
		for(i=begin;i<end;i++){
			if(a[i]>a[end])
				break;
		}
		
		if(i==begin){//后面大的不一定是全部大
			for(int k=i+1;k<end;k++){
				if(a[k]<a[end])
					return false;
			}
			return check(a, begin, end-1);
		}else if(i==end){
			return check(a, begin, end-1);
		}else{//后面大的不一定是全部大
			for(int w=i;w<end;w++){
				if(a[w]<a[end])
					return false;
			}
			return check(a, begin, i-1)&&check(a, i, end-1);
		}
	 }
	
	public static void main(String[] args) {
		int[]a={4,6,12,8,16,14,10};
		System.out.println(VerifySquenceOfBST(a));
	}
	 
}
