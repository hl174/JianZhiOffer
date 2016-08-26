package TimeSpace;
/**
 * 两个链表的第一个公共结点
 * @author HL
 *题目描述
 *输入两个链表，找出它们的第一个公共结点。
 */
public class Solution36 {
	   public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		  /**
		   *两个链表没有说到底有木有环的问题，这里的链表题目告诉的 是单链表，如果有环的话只能是有一个环 
		   * 
		   * 这题从用例来看是没有环的(想复杂了，貌似做过一道有环的题目)
		   * 
		   * 那就计算每个的长度，让长的先走几步，最后走到一个公共的就可了
		   * 
		   * 37ms 503k
		   */
		   if(pHead1==null||pHead2==null) return null;
		   
		   ListNode p1=pHead1,p2=pHead2;
		   int l1=0,l2=0;
		   while(p1!=null){
			   l1++;
			   p1=p1.next;
		   }
		   while(p2!=null){
			   l2++;
			   p2=p2.next;
		   }
		   //始终让p1指向长的
		   if(l2>l1){
			   p1=pHead2;
			   p2=pHead1;
		   }else{
			   p1=pHead1;
			   p2=pHead2; 
		   }
		   l1=Math.abs(l1-l2);
		   while(l1>0){
			  p1=p1.next;
			  l1--;
		   }
		   //一起遍历
		   while(p1!=null){
			   if(p1==p2)
				   return p1;
			   p1=p1.next;
			   p2=p2.next;
		   }
		   
		   return null;
	    }
}
