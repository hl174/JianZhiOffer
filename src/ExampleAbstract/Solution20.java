package ExampleAbstract;

import java.util.Stack;

public class Solution20 {
	/**
	 * 考虑用一个辅助栈来存放当前数据栈的当前最小值
	 * 
	 * 33ms 629k
	 * 
	 */
	Stack<Integer> dataStack=new Stack<>();
	Stack<Integer> minStack=new Stack<>();
    public void push(int node) {
        //push数据的时候要记得同时push辅助栈
    	dataStack.push(node);
    	if(minStack.isEmpty()){
    		minStack.push(node);
    	}else{
    		if(minStack.peek()<node){
    			minStack.push(minStack.peek());
    		}else{
    			minStack.push(node);
    		}
    	}
    }
    
    public void pop() {
    	dataStack.pop();
    	 minStack.pop();
        
    }
    
    public int top() {
       return dataStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
