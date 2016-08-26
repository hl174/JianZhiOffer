package StackAndQueue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * @author HL
 *题目描述
   用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Solution5 {
	    Stack<Integer> stack1 = new Stack<Integer>();
	    Stack<Integer> stack2 = new Stack<Integer>();
	    /**
	     * 思路
	     *  考虑用s1压入 1234
	     *  出来的时候，先把s1的4321压倒S2中，然后s2.pop
	     *  
	     *  33ms 503k
	     * @param node
	     */
	    public void push(int node) {
	        //这里假定插入的时候就是一直插入，不会中间pop两个再插入
	    	stack1.push(node);
	    }
	    
	    public int pop() {
	    while(!stack2.isEmpty()){
	    	return stack2.pop();
	    }
	    while(!stack1.isEmpty()){
	    	stack2.push(stack1.pop());
	    }
	    return stack2.pop();
	    }
}
