package AbstractModel;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 扑克牌顺子
 * @author HL
 *题目描述
 *LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 *他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 *“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 *LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 *上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 *LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。
 *为了方便起见,你可以认为大小王是0。
 */
public class Solution45 {
    public static boolean isContinuous(int [] numbers) {
        /**
         * 0到13这14个数，判断数字是不是连续，对其进行排序，然后用0来填补空缺位，看能否填完
         * 如果这5个数中有相等的非0两个数，则不是顺子
         * 
         * 35ms 625k
         */
    /*	if(numbers==null||numbers.length==0)  return false;
    	Arrays.sort(numbers);
    	//首先检查是否有重复元素(非0)
    	if(checkCF(numbers))
    		  return false;//有重复的元素
    	*//**
    	 * 统计0 的个数，是否大于空缺的数的个数
    	 * 
    	 *//*
    	int count=0,gap=0;//count表示0的个数，gap表示顺子中的差距
    	int last=-1;//上次访问的非0数
    	for(int i=0;i<numbers.length;i++){
    		if(numbers[i]==0){
    			count++;
    		}else{
    			if(last==-1){
    				last=numbers[i];
    			}else{
    				gap+=numbers[i]-last-1;
    				last=numbers[i];
    			}
    			
    		}
    	}
    	
    	return count>=gap?true:false;*/
    	
    	/**
    	 * 法二：除了计算gap数目是否小于0的数之外，还可以算非0的两个数的最大差不会超过4，或者4个0的话肯定是顺子
    	 */
    	if(numbers==null||numbers.length==0)  return false;
    	Arrays.sort(numbers);
    	//首先检查是否有重复元素(非0)
    	if(!checkCF(numbers))
    		  return false;//有重复的元素
    	int max=Integer.MIN_VALUE;
    	int min=Integer.MAX_VALUE;
    	int i=0;
    	while(i<numbers.length){
    		if(numbers[i]!=0){
    			if(numbers[i]>max) max=numbers[i];
    			if(numbers[i]<min) min=numbers[i];
    		}
    		i++;
    	}
    	
    	return max-min>=5?false:true;
/*        if(numbers==null||numbers.length==0) return false;
	//除0外无重复，且除0外最大最小值的gap不能超过4
    	int max=Integer.MIN_VALUE;
    	int min=Integer.MAX_VALUE;
    	if(!checkCF(numbers)){
    		return false;
    	}
    	for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]>max&&numbers[i]!=0) max=numbers[i];
			if(numbers[i]<min&&numbers[i]!=0) min=numbers[i];
		}
      return (Math.abs((max-min))<=4);*/
    }
    
    /**
     * 检查排序后的数组是否有非0的重复元素
     * @param a
     * @return
     */
    public static boolean checkCF(int []a){
    	int last=a[0];
    	boolean flag=true;
    	for(int i=1;i<a.length;i++){
            if(a[i]!=0&&a[i]==last){
    			return false;//重复了
    		}else{
    			last=a[i];
    		}
    	}
    	return true;
    }
/*	public static boolean checkCF(int[] numbers) {
		HashSet<Integer> set=new HashSet<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]!=0){
				if(!set.add(numbers[i])){
					return false;
				}
			}
		}
		return true;
    }*/
    
    public static void main(String[] args) {
		int a[]={1,2,3,4,5};
		System.out.println(isContinuous(a));
	}
}
