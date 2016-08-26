package BackTracking;
/**
 * 矩阵中的路径
 * @author HL
 *题目描述
 *请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 *路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，
 *向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Solution65 {
	   public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
	    {
	      /** 
	       * 回溯法
	       * 
	       * 31ms 503k
	       */
		   if(matrix==null||rows<1||cols<1||str==null)
			   return false;
		   boolean[][] flag=new boolean[rows][cols];//标识矩阵，开始默认是false;
		   int visitedLength=0;//统计每次访问过的字符的长度
		   for(int i=0;i<rows;i++){
			   for(int j=0;j<cols;j++){
				   if(huisu(matrix, rows, cols, str, flag, i, j,visitedLength))
					   return true;
			   }
		   }
		   return false;
	    }
	   
	   
	   public boolean huisu(char[]matrix,int rows,int cols,char[] str,boolean[][] flag,int i,int j,int length){
		   /**
		    * 考虑回溯的退出条件和边界条件
		    */
		   if(length==str.length)
			   return true;//访问完毕
		   
		   boolean huisu=false;
		   if(i>=0&&i<rows&&j>=0&&j<cols&&str[length]==matrix[i*cols+j]&&flag[i][j]!=true){
			   length++;
			   flag[i][j]=true;
			   //当前位置成功的话，还有四种选择
			   huisu=huisu(matrix, rows, cols, str, flag, i+1, j, length)||
					  huisu(matrix, rows, cols, str, flag, i-1, j, length)||
					  huisu(matrix, rows, cols, str, flag, i, j+1, length)||
					  huisu(matrix, rows, cols, str, flag, i, j-1, length);
			   //回溯完毕后要设置归位
			   if(huisu==false){//回溯失败
				   length--;
				   flag[i][j]=false;  
			   }
		   }
		   
		   
		   return huisu;
	   }
	   
}
