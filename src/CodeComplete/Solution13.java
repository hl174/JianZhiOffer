package CodeComplete;
/**
 * 调整数组顺序使奇数位于偶数前面
 * @author HL
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 */
public class Solution13 {
	  /* public  void reOrderArray(int [] array) {
          *//**
           * 简单的遍历一个就移位就没意思了
           * 
           * 类似快速排序，前后维护指针，若前面指向偶数，后面指向奇数，则交换这两个数
           * 
           *//*
		   int left=0,right=array.length-1;
		   while(left<right){//不能等于，不然循环无法出去
			   while(left<right&&isOdd(array[left])){
				   left++;
			   }
			   while(left<right&&!isOdd(array[right])){
				   right--;
			   }
			   if(left<right){
		       int temp=array[left];
			    array[left]=array[right];
				array[right]=temp;
			   }
		   }
		   
	    }
	   
	   */
	/**
	    * 判断是否是奇数
	    * 
	    * 28ms 688k
	    * @param a
	    * @return
	    */
	   public static boolean isOdd(int a){
		   return (a&1)==1?true:false;
	   }

	
	public static void reOrderArray(int [] array) {
     for(int i=0;i<array.length;i++){
    	 int temp=array[i];
    	 int j;
    	 for(j=i-1;j>=0;j--){
    		 if(!isOdd(array[j])&&isOdd(temp)){
    			 //把奇数前面的偶数后移
    			 array[j+1]=array[j];
    		 }else{
    			 break;//必须跳出循环，不然j的值会继续递减
    		 }
    	 }
    	 array[j+1]=temp;//放置奇数
     }
  }

	public static void main(String[] args) {
		int[]a={1,2,3,4,5,6,7};
		reOrderArray(a);
		for (int i : a) {
			System.out.print(i);
		}
		
	}
}
