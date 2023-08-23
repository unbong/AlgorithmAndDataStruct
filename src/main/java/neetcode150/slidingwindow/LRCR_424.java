package neetcode150.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LRCR_424 {
    /**
     * 通过从左至右记录每一个窗口上的字符统计数据
     * 利用统计数据，求得该窗口内可以写入几个字符
     *      窗口长度-最多字符个数 <=k
     *  如果上述等式成立则继续扩大窗口大小，
     *  否则 左侧的窗口大小减小一个
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {


        if(s.length()==0)return 0;
        if(s.length()==1) return 1;
        int left = 0;
        int right = 0;
        int length = 0;
        Map<Character, Integer> counter = new HashMap<>();
        counter.put(s.charAt(right), 1);
        while(left<s.length())
        {

            int maxFrequent = 0;
            for(Map.Entry<Character, Integer> entry: counter.entrySet())
            {
                maxFrequent = Math.max(maxFrequent, entry.getValue());
            }

            int remain = (right-left+1) -maxFrequent;
            if(remain > k )
            {
                if(counter.containsKey(s.charAt(left))){
                    counter.compute(s.charAt(left), (key,oldVal)->{return oldVal-1;});
                }
                left++;
            }
            else if(remain<=k ){
                length = Math.max(length, (right-left+1));

                if(right<s.length()-1)
                {
                    right++;
                    if( counter.containsKey(s.charAt(right)))
                    {
                        counter.compute(s.charAt(right), (key,oldVal)->{return oldVal+1;});
                    }
                    else if ( !counter.containsKey(s.charAt(right))){
                        counter.put(s.charAt(right),1);
                    }
                }else
                {
                    if(counter.containsKey(s.charAt(left))){
                        counter.compute(s.charAt(left), (key,oldVal)->{return oldVal-1;});
                    }
                    left++;
                }
            }

        }

        return length;
    }

}
