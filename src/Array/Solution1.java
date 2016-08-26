package Array;

/**
 * 二维数组中的查找
 * 
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author HL
 *
 */
public class Solution1 {
	
	  public boolean Find(int [][] array,int target) {
          /**
           * 149ms 5147k
           * 
           * 从右上角开始查找
           *   找到 true
           *   > 行-1
           *   < 列-1
           */
		  int row=array.length;//行
		  int col=array[0].length;//列
		  int i=0,j=col-1;
		  while(i<row&&j>=0){
			  if(array[i][j]==target)
				  return true;
			  else if(array[i][j]>target){
				  j--;
			  }else{
				  i++;
			  }
		  }
		  return false;
	    }
}
