package DecomposedProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 复杂链表的复制
 * @author HL
 *题目描述
 *输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 *另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution25 {
    public static RandomListNode Clone(RandomListNode pHead){
    	/**
    	 * 第一种方法：先复制结点，然后再复制random关系，时间复杂度会o(n2)
    	 * 第2种方法：将结点n和复制后的结点n1的对应关系用map存储起来
    	 * 第三种方法：把n1放在N的后面，设置相同的random关系，最后删除原来的链表
    	 */
    	//法二：map存储对应关系  38ms 692k
    /*	if(pHead==null) return pHead;
       RandomListNode p=pHead;
       HashMap<RandomListNode, RandomListNode> map=new HashMap();
       RandomListNode result=new RandomListNode(-1);
       while(p!=null){
    	   RandomListNode temp=new RandomListNode(p.label);
    	   map.put(p, temp);
    	   result.next=temp;
    	   result=result.next;
           p=p.next;
       }//放完了(节点的值和next关系有了，但是random关系还没有)
       Set<Map.Entry<RandomListNode, RandomListNode>> set =map.entrySet();
       for (Map.Entry<RandomListNode, RandomListNode> entry : set) {
		     entry.getValue().random=entry.getKey().random;
	   }
          
        return map.get(pHead);*/
    	
    	
    	//法三：未通过
   	if(pHead==null) return pHead;
    	RandomListNode p=pHead;
    	while(p!=null){
    		RandomListNode temp=new RandomListNode(p.label);
    		temp.next=p.next;
    		p.next=temp;
    		p=p.next.next;
    	}//复制完毕
    	
    	//设置random的链接指针
    	RandomListNode p1=pHead;
    	while(p1!=null){
    		p1.next.random=p1.random.next;
    		p1=p1.next.next;
    	}
    	
    	//拆分这个两个链表
    	//偶数位上的就是复制后的链表，奇数位是原来的链表
    	RandomListNode result=pHead.next;
    	RandomListNode p2=pHead;
    	RandomListNode p3=result;
    	while(p2!=null){//p2.next肯定是不为空的
    		p3=p2.next;//n节点对应的n1节点
    		p2.next=p2.next.next;//解决了奇数位的问题
    		if(p2.next!=null){
    			p3.next=p2.next.next;
    		}
    		p2=p2.next;
    		p3=p3.next;		
    	}
    return result;
    
    }
}
