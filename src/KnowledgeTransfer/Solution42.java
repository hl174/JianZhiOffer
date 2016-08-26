package KnowledgeTransfer;

import java.util.ArrayList;

/**
 * 和为S的两个数字
 * @author HL
 *题目描述
 *输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 *如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 *输出描述:
 *对应每个测试案例，输出两个数，小的先输出。
 */
public class Solution42 {
	public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		/**
		 * 和上一题求连续数的和为某一直不同，上一题的遍历是左右指针都从左边开始
		 * 这题求给定数的和为某一个值且乘积最小的话，是左右指针是分别从两边进行夹的
		 * 35ms 654k
		 */
        ArrayList<Integer> result=new ArrayList<>();
        int li=0,ri=array.length-1;
        int temp=Integer.MAX_VALUE,tl=1,rl=1;
        while(li<ri){
        	if(array[li]+array[ri]==sum){
        		if(array[li]*array[ri]<temp){
        		tl=array[li];
        		rl=array[ri];
        		temp=tl*rl;
        		}
        		li++;
        		ri--;
        	}else if(array[li]+array[ri]>sum){
        		ri--;
        	}else if(array[li]+array[ri]<sum){
        		li++;
        	}
        }
        if(tl==rl&&tl==1)
        	return result;
        result.add(tl);
        result.add(rl);
		return result;
    }
	
	public static void main(String[] args) {
		int[]a={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		System.out.println(FindNumbersWithSum(a, 21).toString());
	}
}
