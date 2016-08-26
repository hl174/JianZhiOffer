package TimeSpace;
/**
 * 丑数
 * @author HL
 *题目描述
 *把只包含因子2、3和5的数称作丑数（Ugly Number）。
 *例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution33 {
    public static int GetUglyNumber_Solution(int index) {
        /**
         * 从头到尾判断的话就得意思，考虑用一种新的方法
         *  2 3 5 ，则后面的数都是前面的数乘以 2 3 5得到的，相比而言是用空间来换取时间的
         * 
         * 32ms 503k
         */
    	if(index<=0) return 0;
    	int[]result=new int[index+1];
    	result[1]=1;
    	//m2 m3 m5代表每次大于当前最大丑数的最小index
    	int m2=1,m3=1,m5=1;
    	int begin=2;
    	while(begin<=index){
    		result[begin]=min(result[m2]*2,result[m3]*3,result[m5]*5);
    		while(result[m2]*2<=result[begin])
    			m2++;
    		while(result[m3]*3<=result[begin])
    			m3++;
    		while(result[m5]*5<=result[begin])
    			m5++;
    		
    		begin++;
    	}
    	return result[index];
    	
    }
    
    public static int min(int m2,int m3,int m5){
    	int t=Math.min(m2, m3);
    	return Math.min(t, m5);
    }
    
    public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(4));
	}
}
