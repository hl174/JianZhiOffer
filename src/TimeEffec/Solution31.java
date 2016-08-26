package TimeEffec;
/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * @author HL
 *题目描述

求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class Solution31 {
	   public static int NumberOf1Between1AndN_Solution(int n) {
		    /**
		     * 这样的题目有个类似的公式，但是不能死记
		     * 
		     *   //计算k的个数，需要逐个位的查找比较
		     * 逐个位数进行循环
		     *  当前数>k (高位数+1)*当前位权值
		     *  当前数=k  高位数*当前位权值+低位数+1
		     *  当前数<k 高位数*当前位权值
		     *  
		     *  27ms 528k
		     */
		   int weight=1;
		   int result=0;
		   while(n/weight!=0){
			   int curr=(n/weight)%10;//当前位上的数字
			   int higtValue=n/(weight*10);
			   int lowValue=n-n/weight*weight;
			   if(curr>1)
				   result+=(higtValue+1)*weight;
			   else if(curr==1)
				   result+=higtValue*weight+lowValue+1;
			   else
				   result+=higtValue*weight;
			   weight*=10;
		   }
		   return result;
	    }

	  public static void main(String[] args) {
		System.out.println(NumberOf1Between1AndN_Solution(13));
	}
}
