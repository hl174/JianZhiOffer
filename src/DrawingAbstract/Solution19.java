package DrawingAbstract;

import java.util.ArrayList;

/**
 * 顺时针打印矩阵
 * @author HL
 *输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 *则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution19 {
	   public  static ArrayList<Integer> printMatrix(int [][] array) {
		   /**
		    * 36ms 692k
		    */
		   ArrayList<Integer> result=new ArrayList<>();
		   int n = array.length,m = array[0].length;
		   int layer = (Math.min(n,m)-1)/2+1;//这个是层数
		  for(int count=1;count<=layer;count++){
			  int start=count-1;//起始的坐标
			  //上
			  for(int i=start;i<=m-count;i++)
				  result.add(array[start][i]);
			  
			  //右
			  for(int j=start+1;j<=n-count;j++)
				  result.add(array[j][m-count]);
			  
			  //下
			  /**
			   * n-count!=count-1 是为了保证下面行的首位不同
			   */
			  for(int k=m-count-1;k>=count-1&&(n-count!=count-1);k--){
				  result.add(array[n-count][k]);
			  }
			  
			  //左
			  /**
			   * 
			   * m-count!=count-1 是为了保证左边列的首位不同
			   */
              for(int w=n-count-1;w>=count&&(m-count!=count-1);w--){
            	  result.add(array[w][count-1]);
              }
			  
		  }
		  
		   return result;
		}  
	   public static void main(String[] args) {
		int[][]a={{1},{2},{3},{4},{5}};
		System.out.println(printMatrix(a));
	}
}
