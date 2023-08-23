package neetcode150.slidingwindow;

import java.util.HashMap;
import java.util.Map;


public class MinimumWindowSubString {

    /**
     *  使用左右指针的移动，并比较t的字符是否在窗口中存在，并且检查字符的个数是否相同
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
            if(s.length() ==0) return  "";
            if(t.length()>s.length()) return "";
            if(s.equals(t)) return s;
            int left = 0;
            int right = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            HashMap<Character, Integer> counter = new HashMap<>();
            for(char c: t.toCharArray()){
                if(counter.containsKey(c))
                {
                    counter.compute(c, (key, oldVal)->oldVal+1);
                }
                else{
                    counter.put(c, 1);
                }
            }
            map.put(s.charAt(right), 1);
            String res="";
            int len = Integer.MAX_VALUE;
            while(left<s.length())
            {
                boolean isInMap = true;
                for(Map.Entry<Character, Integer> entry: counter.entrySet())
                {
                    if(!map.containsKey(entry.getKey()) )
                    {
                        isInMap = false;
                        break;
                    }
                    else if( map.get(entry.getKey()) < entry.getValue())
                    {
                        isInMap = false;
                        break;
                    }
                }


                // if not in map then move to right
                if(!isInMap){
                    if(right < s.length()-1)
                    {
                        right++;
                        Character key = s.charAt(right);
                        if(map.containsKey(key)){
                            map.compute(key, (k, oldValue)->oldValue+1);
                        }
                        else {
                            map.put(key, 1);
                        }
                    }
                    else if(right == s.length()-1){
                        Character key = s.charAt(left);
                        if(map.get(key).intValue() >1){
                            map.compute(key,(k, oldVal)->oldVal-1);
                        }
                        else if (map.get(key).intValue() == 1){
                            map.remove(key);
                        }
                        left++;
                    }
                }
                else{
                    if((right-left+1) < len && (right-left+1) >= t.length()){
                        res = s.substring(left, right+1);
                        len = right-left+1;
                    }
                    Character key = s.charAt(left);
                    if(map.get(key).intValue() >1){
                        map.compute(key,(k, oldVal)->oldVal-1);
                    }
                    else if (map.get(key).intValue() == 1){
                        map.remove(key);
                    }
                    left++;

                }
            }
            return res;
        }
}
