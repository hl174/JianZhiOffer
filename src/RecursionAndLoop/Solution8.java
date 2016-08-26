package RecursionAndLoop;
/**
 * 跳台阶
 * @author HL
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution8 {
	public int JumpFloor(int target) {
     /**
      * 和上题类似，还是不用递归做
      * n级台阶，考虑n是正整数
      * 
      * 32ms 629k
      */
		if(target==1) return 1;
		if(target==2) return 2;
		int a=1,b=2,result=0;
		for(int i=3;i<=target;i++){
			result=a+b;
			a=b;
			b=result;
		}
		return result;
    }
}
