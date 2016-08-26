package BackTracking;
/**
 * 机器人的运动范围
 * @author HL
 *题目描述
 *地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 *但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
 *因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Solution66 {
    public int movingCount(int threshold, int rows, int cols)
    {
    	/**
    	 * 这题同样也需要回溯法
    	 * 
    	 */
      if(rows<=0||cols<=0||threshold<=0) return 0;
      int result=0;
      boolean[][]flag=new boolean[rows][cols];
    	return huisu(rows,cols,0,0,threshold,flag);
    }
    
    public int huisu(int rows,int cols,int i,int j,int k,boolean[][] flag){
    	if(i>=rows||j>=cols) return 0;
    	int count=0;
    	if(i>=0&&i<rows&&j>=0&&j<cols&&flag[i][j]==false&&checkposition(i, j, k)){
    		count++;
    		flag[i][j]=true;
    		count+=huisu(rows, cols, i+1, j, k,flag)+huisu(rows, cols, i-1, j, k,flag)+huisu(rows, cols, i, j+1, k,flag)+huisu(rows, cols, i, j-1, k,flag);
    	   if(count==1){
    		   flag[i][j]=false;
    	   }
    	    
    	}
    	return count;
    }
    
    /**
     * 检查当前位置是否能够进入
     */
    public boolean checkposition(int i,int j,int k){
    	int result=0;
    	while(i!=0){
    		result+=i%10;
    		i=i/10;
    	}
    	while(j!=0){
    		result+=j%10;
    		j=j/10;
    	}
    	return result<=k?true:false;
    }
}
