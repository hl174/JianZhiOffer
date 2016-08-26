package LinkedList;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * @author HL
 *
 *题目描述

输入一个链表，从尾到头打印链表每个节点的值。 
输入描述:
输入为链表的表头


输出描述:
输出为需要打印的“新链表”的表头
 */

/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
public class Solution3 {
	 public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
       /**
        * 考虑用栈结构或者递归，但是递归的话可能会卡死，还是用栈好
        * 36ms 629k
        */
		 ArrayList<Integer> result=new ArrayList<>();
		 Stack<Integer> stack=new Stack<>();
		 while(listNode!=null){
			 stack.push(listNode.val);
			 listNode=listNode.next;
		 }
		  while(!stack.isEmpty()){
			  result.add(stack.pop());
		  }
		 return result;
    }
}
