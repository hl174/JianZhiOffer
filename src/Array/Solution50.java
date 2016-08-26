package Array;
/**
 * 数组中重复的数字
 * @author HL
 *题目描述
 *在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 *但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 */
public class Solution50 {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {
         /**
          * 我自想到的做法是先用长度为N的数组，统计数
          * 38ms 503k
          * 书上的解法麻烦:
          *   判断当前位置的值是否和下标一致，不然就和下标为值的数进交换，直到index和值相等 ,然后对下一个index进行判断,如何index和值不等，但是以值为index上的值和index相等（a[2]=2），则找到了
          *   
          */
    	
    	 int result[]=new int[length];
		    for (int i = 0; i < result.length; i++) {
				result[numbers[i]]++;
		       if(result[numbers[i]]>1){
		    	   duplication[0]=numbers[i];
		    	   return true;
		       }
		    	   
			}
		    return false;
    }
}
