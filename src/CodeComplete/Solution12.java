package CodeComplete;
/**
 * 数值的整数次方
 * @author HL
 *给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution12 {
	  public double Power(double base, int exponent) {
	     /**
	      * 用Java自带的公式的话就没意思了  
	      *  
	      */
		 if(equal(base, 0.0))
			 return 0;
		 if(exponent>=0){
			 return poewrWithEx(base, exponent);
		 }else{
			 return 1.0/poewrWithEx(base, -exponent);
		 }
	  }
	  
	  /**
	   *自定义的正数的幂
	   *这里exponent永远是正数
	   */
	  public double poewrWithEx(double base,int exponent){
		  /**
		   * 考虑改进
		   */
		  if(exponent==0)
			  return 1;
		  if(exponent==1)
			  return base;
		  double result=poewrWithEx(base, exponent>>1);
		  result*=result;
		  if((exponent&1)==1){//奇数
			  result*=base;
		  }
		  return result;
		 /* double result=1.0;
		  for(int i=1;i<=exponent;i++){
			  result*=base;
		  }
		  return result;*/
	  }
	  
	  /**
	   *自定义比较两个double数的方法 
	   */
	  public boolean equal(double a,double b){
		  if(Math.abs(a-b)<=0.000001)
			  return true;
		  return false;
	  }
}
