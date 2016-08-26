package LinkedList;
/**
 * 删除链表中重复的结点
 * @author HL
 *题目描述
 *在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留
返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution56 {
    public ListNode deleteDuplication(ListNode p)
    {  
    	/**
    	 * 
    	 * 考虑的是用last保存上次遍历过的节点
    	 * 
    	 * 37ms 654k
    	 */
    	if(p==null||p.next==null)  return p;
        ListNode result=new ListNode(-1);
        result.next=p;
        ListNode last=result;//上次访问过的,实际的循环中就是Last串联了最终的结果
        while(p!=null&&p.next!=null){
        	if(p.val==p.next.val){
        		int temp=p.val;
        		while(p!=null&&p.val==temp){
        			p=p.next;
        		}//p的值不和一个相等
        		last.next=p;
        	}else{
        		last=p;
        		p=p.next;
        	} 	
        }
        
        return result.next;
    }
    

}
