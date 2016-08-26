package KnowledgeTransfer;
/**
 * 翻转单词顺序列
 * @author HL
 *题目描述
 *牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 *写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 *但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 *正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Solution44 {
    public static String ReverseSentence(String str) {
    	/**
    	 * 31ms 503k
    	 * 这题是把所有的单词反转，当然这里用例中只有一个结尾的点号，且点号挨着最后的单词。
    	 * 
    	 * 当然还有另一种可靠的方法：
    	 *   一个一个字符的翻转，但是这样的话会吧每个单词内的顺序打乱；于是最后再对单个单词进行翻转。
    	 * 
    	 */
        if(str==null||str.trim().length()==0) return str;
        String[]a=str.split(" +");
        int l=a.length-1;
        for(int i=0;i<=l/2;i++){
        	String t=a[i];
        	a[i]=a[l-i];
        	a[l-i]=t;
        }
        String result="";
        for (int i = 0; i <l; i++) {
			result+=a[i]+" ";
		}
        result+=a[l];
    	return  result;
    }
    
  public static void main(String[] args) {
	System.out.println(ReverseSentence(" "));
}
}
