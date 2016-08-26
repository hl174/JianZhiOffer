package CodeRobust;
/**
 * 合并两个排序的链表
 * @author HL
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 */
public class Solution16 {
	   public ListNode Merge(ListNode list1,ListNode list2) {
	        /**
	         *思路：
	         *法一：这题可以考虑用递归，比较两个链表的大小节点后，最终的表的结果可以由递归实现   41ms 503k
	         *法二：当然也可以用非递归的方法进行，维护两个指针  30ms 503k
	         */
		  /* 
		   ListNode result=new ListNode(-1);
		   if(list1==null) return list2;
		   if(list2==null) return list1;
		   if(list1.val<list2.val){
			   result.next=list1;
			   result=result.next;
			   result.next=Merge(list1.next, list2);
		   }else{
			   result.next=list2;
			   result=result.next;
			   result.next=Merge(list1, list2.next);   
		   }
		   return result;*/
		   
		   ListNode result=new ListNode(-1);
		   ListNode result1=result;
		   if(list1==null) return list2;
		   if(list2==null) return list1;
		   while(list1!=null&&list2!=null){
			   if(list1.val<list2.val){
				   result.next=list1;
				   result=result.next;
				   list1=list1.next;
			   }else{
				   result.next=list2;
				   result=result.next;
				   list2=list2.next;
			   }
		   }
		 //有一个为null了
		 if(list1!=null){
			 result.next=list1;
		 }
		 if(list2!=null){
			 result.next=list2;
		 }
		   return result1.next;
	    }
}
