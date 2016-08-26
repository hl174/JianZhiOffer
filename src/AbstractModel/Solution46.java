package AbstractModel;
/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 * @author HL
 *题目描述
 *每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 *HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,
 *让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 *每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 *从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 *可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 *请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class Solution46 {
	 public static int LastRemaining_Solution(int n, int m) {
	     /**
	      *这题是有名的约瑟夫环的问题，可以直接用公式来进行计算，但估计大部分人不会推算公式，
	      *这里可以先尝试用数组来代替环，每次访问后就设置为-1，直到最后一个-1    
	      *
	      *115ms 654k
	      */
	/*	 if(n<1||m<1) return -1;
		 int[]a=new int[n];//n个人
		 int count=n;//n个人，n次循环记录
		 int currI=0;//每次循环到的当前位置
		 int step=1;//一次查找中的记录
		 while(count>0){
			
			 if(currI>n-1) currI=0;//到尾巴就从头开始
			 if(a[currI]==-1){
				 currI++;
				 continue;//已经访问过，就跳过
			 }
			 step++;
			 if(step==m){
				 count--;//找到就减一个
				 step=0;
				 a[currI]=-1;
			 }
			 currI++;
		 }
		 
		 //最后一个currI就是结果
		 return currI;*/
		 
		 //法二:用公式来做
		 /**
		  * 定义一个方程f(n,m)表示每次在n个数字0,1...n-1中删除第M个数字后剩余的数
		  * 第一个被删除的数应该是(m-1)%n
		  *         0     ,    n=1
		  * f(n,m)=[f(n-1,m)+m]%n  ,n>1(记住这里的n是表示当前剩余数的个数，是一直在变化的)
		  * 
		  * 31ms 629k
		  */
		 if(n<1||m<1) return -1;
		 int last=0;
		 for(int count=2;count<=n;count++)
			 last=(last+m)%count;
		 return last;
	    }
	 
	 public static void main(String[] args) {
		System.out.println(LastRemaining_Solution(5, 3));
	}
}
