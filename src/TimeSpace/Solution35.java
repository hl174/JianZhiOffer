package TimeSpace;
/**
 * 数组中的逆序对
 * @author HL
 *题目描述

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007 
输入描述:
题目保证输入的数组中没有的相同的数字
数据范围：
	对于%50的数据,size<=10^4
	对于%75的数据,size<=10^5
	对于%100的数据,size<=2*10^5


输入例子:
1,2,3,4,5,6,7,0

输出例子:
7
 */
public class Solution35 {
	  public static int InversePairs(int [] array) {
	        /**
	         * 从头往后一个个的比较，其复杂度貌似是o(n2)
	         * 归并排序的时间复杂度可以达到o(nlogn)
	         * 
	         * 285ms 31107k 
	         * 
	         */
		  
		  
		  return mergesortfind(array,0,array.length-1);
	    }
	  
	  public static int mergesortfind(int a[],int begin,int end){
		  if(begin<end){//这个限制范围不能掉，不然的话递归会无法退出
		 int l= mergesortfind(a, begin, (begin+end)/2)%1000000007 ;//左边递归
		 int r=mergesortfind(a, (begin+end)/2+1, end)%1000000007 ;//右边递归
          int t=mergefind(a,begin,(begin+end)/2,end)%1000000007 ;//合并	
		  return (l+r+t)%1000000007;
		  }
		  return 0;
	  }
	  
	  public static int mergefind(int[]a,int begin,int mid,int end){
		  int temp[]=new int[end-begin+1];//辅助数组
		  int i=begin,j=mid+1;//左右两个指针
		  int k=0;
		  int count=0;
		  while(i<=mid&&j<=end){
			  if(a[i]<a[j]){
				  temp[k++]=a[i++];
			  }else{
				  //这里是从最小的开始，i比j大的话,i后面的都比j大
				  temp[k++]=a[j++];
				  count+=mid-i+1;//
                   if(count>=1000000007)//数值过大求余
                {
                    count%=1000000007;
                }
			  }	  
		  }
		  
		  //先放左边或者先放右边的代码是没有影响的
		  while(i<=mid){//左边的放入
			  temp[k++]=a[i++];
		  }
		  
		  while(j<=end){//右边的放入
			  temp[k++]=a[j++];
		  }
		  
		  //最后将temp的数复制到原数组中
		  for(int w=0;w<temp.length;w++){
			  a[begin+w]=temp[w];
		  }
		  return count;
	  }

}
