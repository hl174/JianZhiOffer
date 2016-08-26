package Tree;

import java.util.*;
/**
 * 数据流中的中位数
 * @author HL
 *题目描述
 *如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 *如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Solution63 {
/**
 * 考虑用啥存放数据，list，collection可以对list进行排序
 * 
 * 37ms 688k
 * 
 */
    ArrayList<Integer> data=new ArrayList<>();
    public void Insert(Integer num) {
      data.add(num);
      Collections.sort(data);    
    }

    public Double GetMedian() {
     Double result=0.0;
     if(data.size()%2==0){//偶数
    	 int l=(data.size()-1)/2;
    	 int r=data.size()/2;
    	 result=1.0*(data.get(l)+data.get(r))/2; 
     }else{
         int mid=data.size()/2;
    	 result=1.0*data.get(mid);
     }
     return result;
    }

    public static void main(String[] args) {
		System.out.println(((double)(2+5)/2));
	}
}
