package RecursionAndLoop;
/**
 * 变态跳台阶
 * @author HL
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution9 {
public int JumpFloorII(int target) {
      /**
       *数学归纳法  2的n-1次  
       *27ms 503k
       */
	return (int) Math.pow(2, target-1);
    }
}
