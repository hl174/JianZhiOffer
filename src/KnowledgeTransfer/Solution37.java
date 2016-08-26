package KnowledgeTransfer;
/**
 * 数字在排序数组中出现的次数
 * @author HL
 *题目描述
 *统计一个数字在排序数组中出现的次数。
 */
public class Solution37 {
    public static int GetNumberOfK(int [] array , int k) {
        /**
         * 这题初的感觉全部用字符串表示，然后遍历，o(n)复杂度可以求出
         * 但是因为是排序数组，因此还是想试试二分，但是二分查找的时间复杂度是o(logn)
         * (补充下：这题说是数在数组中出现的次数，容易误理解例如为1在1,12中出现的次数2次；)
         * 既然是待排序数组，就可以用二分法找到第一个k,和最后一个k，尽管实质可能就是一个k
         * 
         * 
         * 34ms 654k
         */
    	int indexF=getFirstK(array,k,0,array.length-1);
    	int indexL=getLastK(array,k,0,array.length-1);
    	if(indexF==-1||indexL==-1)
    		return 0;
    	return indexL-indexF+1;
    }
    
    public static int getFirstK(int[]a,int k,int left,int right){
    	
    	while(left<=right){
    		int mid=(left+right)/2;
    		if(a[mid]==k){
    			if((mid>0&&a[mid-1]!=k)||mid==0)
    				return mid;
    			else
    			  right=mid-1;//说明不是开始的k，且有好多个k
    		}else if(a[mid]>k){
    			right=mid-1;
    		}else{
    			left=mid+1;
    		}
    	}
    	return -1;
    }
    
    public static int getLastK(int []a,int k,int left,int right){
       	while(left<=right){
    		int mid=(left+right)/2;
    		if(a[mid]==k){
    			if((mid<right&&a[mid+1]!=k)||mid==right)
    				return mid;
    			else
    			  left=mid+1;//说明不是开始的k，且有好多个k
    		}else if(a[mid]>k){
    			right=mid-1;
    		}else{
    			left=mid+1;
    		}
    	}
    	return -1;
    }
    
    public static void main(String[] args) {
		int a[]={1,2,3,3,3,3,4,5};
	   System.out.println(GetNumberOfK(a, 3));
    
    }
}
