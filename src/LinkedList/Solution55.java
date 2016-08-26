package LinkedList;
/**
 * 链表中环的入口结点
 * @author HL
 *题目描述
 *一个链表中包含环，请找出该链表的环的入口结点。
 */
public class Solution55 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
      /**
       *  首选要找到环 
       *   
       *   网上有一种解方法是p1速度为1 p2速度2 先让p1p2第一次相遇，然后p1从头开始，p2从当前位置开始，再第二次相遇的时候就是环的入口点，相应的可以用数学公式来计算
       *   
       * 这里还是用一种比较通俗的做法，求出环的长度，然后两个指针同时走，相遇点即为入口点
       * 
       * 42ms 528k
       */
    	if(pHead==null||pHead.next==null) return null;
    	
    	/**
    	 *1,求环的长度，怎么求，快慢指针第一次相遇的点，然后再到这个点经过的路 
    	 *
    	 */
    	ListNode quick=pHead.next;
    	ListNode slow=pHead;
    	while(quick!=null&&slow!=null){
    		if(quick==slow){
    			break;
    		}
    		slow=slow.next;
    		quick=quick.next.next;//不去判断了，题目都说了有环
/*    		if(quick!=null)
    			quick=quick.next;
    		else
    			return null;//没有环
*/    	}
    	ListNode temp=slow;
    	int count=0;
    	while(slow.next!=null){
    		slow=slow.next;
    		count++;
    		if(slow==temp)
    			break;
    	}
    	
    	//第二次相遇
    	slow=pHead;
    	quick=pHead;
         while(count>0){
        	 quick=quick.next;
        	 count--;
         }
         while(slow!=quick){
        	 slow=slow.next;
        	 quick=quick.next;
         }
    	return slow;
    }
}
