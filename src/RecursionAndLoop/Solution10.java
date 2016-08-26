package RecursionAndLoop;
/**
 * 矩形覆盖
 * @author HL
 *我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Solution10 {
	public int RectCover(int target) {
      /**
       * n=1 1
       * n=2 2
       * n=3时，f(3)=f(3-1)+f(3-2)
       * 
       * 34ms  654k
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
