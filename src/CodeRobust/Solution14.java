package CodeRobust;

/**
 * 链表中倒数第k个结点
 * @author HL
 *输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution14 {
	   public ListNode FindKthToTail(ListNode head,int k) {
		   /**
		    * 还是用两个指针夹，当然遍历的时候如果长度没有k的话，则返回空
		    * 
		    * 31ms 629k
		    */
           if(head==null||k<=0)
        	   return null;
           ListNode p=head;
           int count=1;//head算第一个元素
           while(p!=null&&count<=k){
        	   p=p.next;
        	   count++;
           }
           if(count-1<k)//count此时比记录数多1
        	   return null;//没那么长
           while(p!=null){
        	   p=p.next;
        	   head=head.next;
           }
           return head;
           
	    }
}
