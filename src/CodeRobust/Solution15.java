package CodeRobust;
/**
 * 反转链表
 * @author HL
 *输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Solution15 {
	   public ListNode ReverseList(ListNode head) {
          /**
           *头插法
           * 
           * 37ms 654k
           */
		   if(head==null) return null;
		   ListNode p=head;  //循环的指针
		   ListNode result=null; //始终指向头指针的位置
		    while(p!=null){
		    	ListNode pNext=p.next;//当前点的下一个点
		    	p.next=result;
		    	result=p;
		    	p=pNext;
		    }
		   
		   return result;
	    }
}
