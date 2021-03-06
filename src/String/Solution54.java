package String;

import java.util.ArrayList;
import java.util.*;

/**
 * 字符流中第一个不重复的字符
 * @author HL
 *题目描述
 *请实现一个函数用来找出字符流中第一个只出现一次的字符。
 *例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。 
 *输出描述:
 *如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Solution54 {
	/**
	 * 个人想法是用hashmap来计算是否是重复的
	 * 插入值的部分可以用list
	 * 
	 * 
	 * 46ms 528k
	 */
  HashMap<Character, Integer> map=new HashMap<>();
	ArrayList<Character> list=new ArrayList();
    //Insert one char from stringstream
    public  void Insert(char ch)
    {
         if(map.containsKey(ch)){
            map.put(ch, map.get(ch)+1);
         }else{
        	 map.put(ch, 1);
        	 list.add(ch);
         }
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    for (int i = 0; i < list.size(); i++) {
		if(map.get(list.get(i))==1)
			return list.get(i);
	}
    return '#';
    }
    

}
