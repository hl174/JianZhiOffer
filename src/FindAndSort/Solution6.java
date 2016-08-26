package FindAndSort;
/**
 * 旋转数组的最小数字
 * @author HL
 *
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Solution6 {
	 public int minNumberInRotateArray(int [] array) {
		 /**
		  * 非递减数组，若从头到尾比较大小，虽然是o(n)，但是无法满足旋转数组的条件
		  * 可以考虑用二分法查找
		  * 
		  * 188ms 4053k
		  * 
		  */
		   if(array==null||array.length==0)
			   return 0;
		   int left=0,right=array.length-1;
		   while(left<=right){
			   if(left==right){
				   return array[left];
			   }
			   /**
			    * 考虑 10111
			    *     11101
			    * 这样的情况,不是简单的二分
			    */
			   int mid=(left+right)/2;
			   if(array[mid]>array[right]){//在右边
				   left=mid+1;
			   }else if(array[mid]<array[right]){//最小值在前面，包括Mid
				   right=mid;
			   }else{//中间和右边相等的时候，只有递减的找
				   right-=1;
			   }
			   
		   }
		   return 0;
	    }
}
