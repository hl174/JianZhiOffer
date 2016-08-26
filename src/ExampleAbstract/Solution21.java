package ExampleAbstract;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * @author HL
 *题目描述

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）
 */
public class Solution21 {
	 public static boolean IsPopOrder(int [] pushA,int [] popA) {
            /**
             * 用一个辅助栈来进行检验，依次检查要出去的序列，然后在进栈队列中去查找，当然这题目中说道的数字均不相等很重要，不然下面的都是白费
             * 
             * 37ms 654k
             */
		 if(pushA==null||pushA.length==0||popA==null||popA.length==0) return false;
		 int pushindex=0,popindex=0;
		 Stack<Integer> stack=new Stack<>();
		 while(popindex<popA.length){//遍历出栈队列			 
			
			
			if(stack.isEmpty()||stack.peek()!=popA[popindex]){
				while(pushindex<pushA.length){//不一定能找到
					if(pushA[pushindex]!=popA[popindex]){
						  stack.push(pushA[pushindex++]);//依次进栈
					 }else{
						 pushindex+=1;//+1是跳过当前到下一个，但是+2牛客上怎么也通过了,说明的牛客的测试用例有漏洞
						 break;
					 }
				}  
			 }else if(stack.peek()==popA[popindex]){//出栈
				stack.pop();
				
			 }	
		   popindex++;
		 }
		 //最后看栈为不为空
		 return stack.isEmpty();
	    }
	public static void main(String[] args) {
		int []a={1,2,3,4,5};
		int []b={2,3,4,1,5};
		System.out.println(IsPopOrder(a, b));
	}
}
