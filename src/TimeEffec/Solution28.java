package TimeEffec;

/**
 * 数组中出现次数超过一半的数字
 * @author HL
 *题目描述
 *数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *如果不存在则输出0。
 */
public class Solution28 {
    public static int MoreThanHalfNum_Solution(int [] array) {
        /**
         * 分析:超过一半的话，则排序后二分中间值肯定就是的，不然就没有
         * 
         * 当然还可以用数值标记法，遇到与上一个相同的数+1，否则-1，最后的情况肯定是正数，对次数是正数的值进行统计，不然就没有该值
         * 
         */
      //法二：利用计数原理  33ms 528k
     if(array==null||array.length==0) return 0;
       int count=0,last=0;
       for (int i = 0; i < array.length; i++) {
	          if(count==0){
	        	  last=array[i];
	        	  count=1;
	          }else if(array[i]==last){
	        	  count++;
	          }else{
	        	  count--;
	          }
	       }
    	if(count>=1&&checkHalf(array, last)) return last;  	
    	return 0;
    	
    }
    
    public static boolean checkHalf(int []a,int last){
    	int count=0;
    	for(int i=0;i<a.length;i++){
    		if(a[i]==last)
    			count++;
    	}
    	
    	return count>(a.length/2)?true:false;
    }

}
