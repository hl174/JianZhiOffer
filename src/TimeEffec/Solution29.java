package TimeEffec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 最小的K个数
 * @author HL
 *题目描述
 *输入n个整数，找出其中最小的K个数。
 *例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	
      /*
       * 这种做法就没意思了  40ms 654k
       *   ArrayList<Integer> result=new ArrayList<>();
    	if(k<=0||k>input.length) return result;
    	Arrays.sort(input);
    	for(int i=0;i<k;i++)
    		result.add(input[i]);
    	return result;*/
    	//考虑快排数组  43ms 528k
    	 ArrayList<Integer> result=new ArrayList<>();
     	if(k<=0||k>input.length) return result;
     	noREQuickSort(input);
     	for(int i=0;i<k;i++)
    		result.add(input[i]);
    	return result;
    }
    
    /**
     * 非递归实现快速排序
     * 因为需要保存每次开始遍历的首尾index，用栈来存放每次的左边，先放大区间的，再放小区间的的，处理的时候就先处理小区间的
     * @param a
     */
    public static void noREQuickSort(int [] a){
    	if(a==null||a.length==0) return;
    	Stack<Integer> stack=new Stack<>();
    	stack.push(0);  //左
    	stack.push(a.length-1);//右
    	while(!stack.isEmpty()){
    		int right=stack.pop();
    	    int left=stack.pop();
    	    int temp=a[right];
    	    int L=left,R=right;
    	    while(left<right){
    	    	 while(left<right&&a[left]<=temp)
    	    		 left++;
    	    	 a[right]=a[left];
    	    	 while(left<right&&a[right]>=temp)
    	    		 right--;
    	    	 a[left]=a[right];
    	    }
    	    //left==right
    	    a[left]=temp;
    	    
    	    //判断最后的分界点
    	    //左边有
    	    if(left-1>L){
    	    	stack.push(L);  //左
    	    	stack.push(left-1); //右
    	    }
    	    
    	    //右边
    	    if(right+1<R){
    	    	stack.push(right+1);
    	    	stack.push(R);
    	    }
    	}
    }
}
