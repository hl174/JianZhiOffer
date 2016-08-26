package StackAndQueue;

import java.util.*;

/**
 * 滑动窗口的最大值
 * @author HL
 *题目描述
 *给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 *例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 *他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， 
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Solution64 {
	  public static ArrayList<Integer> maxInWindows(int [] num, int size)
	    {
	        /**
	         * 如果用传统的两个for,时间复杂度就是o(n2)
	         * 
	         * 
	         * 42ms  654k
	         */
            Deque<Integer> deque=new LinkedList<>();//放可能最大值的index
            ArrayList<Integer> result=new ArrayList<>();
            //这里假定的是窗口大于数组的长度，就返回空
            if(size<=0||num==null||num.length==0||size>num.length) 
            	return result;
            for(int i=0;i<size;i++){
            	while(!deque.isEmpty()&&num[i]>=num[deque.peekLast()])
            		deque.pollLast();//从后面退出比当前值小的值
            	deque.addLast(i);//把最大的值的坐标再放入双端队列中	
            }
            
            for(int i=size;i<num.length;i++){
            	//上一次窗口中的最大值
            	result.add(num[deque.peekFirst()]);//每次队头的最大元素装入结果，但是不一定弹出
            	while(!deque.isEmpty()&&num[i]>=num[deque.peekLast()])
            		deque.pollLast();//将队尾小的数弹出来
            	
            	if(!deque.isEmpty()&&deque.peekFirst()<=(i-size))//最大元素不在窗口范围了
            		 deque.pollFirst();//弹出
            	
            	//num[i]<num[deque.peekLast()]
            	deque.addLast(i);//位置i上的数比队尾数小，则继续加在队尾
            }
            
            //不要忘记最后的一个
            result.add(num[deque.peekFirst()]);//每次队头的最大元素装入结果，但是不一定弹出
            
		  return result;
	    }
	  
	  public static void main(String[] args) {
		int[]a={2,3,4,2,6,5,1,4,2,8,4,2,1,9,5};
		System.out.println(maxInWindows(a, 5));
	}
}
