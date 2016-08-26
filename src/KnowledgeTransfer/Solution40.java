package KnowledgeTransfer;
/**
 * 数组中只出现一次的数字
 * @author HL
 *题目描述
 *一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Solution40 {
	//num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果
	   public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	        /**
	         * 所有的数亦或一次，得到x=a^b,a和b不一样则不为0，则以最后一个1为标识，将上面多少的数分为两组
	         * 
	         * 30ms 503k
	         */
		   int t=0;
		  for(int i=0;i<array.length;i++){
			 t=t^array[i];
		  }
		  int label=1;
		  while((t&label)==0){
			  label=label<<1;
		  }
		  for(int i=0;i<array.length;i++){
			  if((label&array[i])==0)
				  num1[0]^=array[i];
			  else
				  num2[0]^=array[i];
		  }
		   
	    }
}
