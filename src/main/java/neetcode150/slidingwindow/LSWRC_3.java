package neetcode150.slidingwindow;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LSWRC_3 {


    /**
     * 使用左右两个指针指向从左至右的遍历
     *  遍历过程中如果有指针在散列表中存在，说明有重复
     *      左指针开始删除散列表中的数据，删除到重复字符的位置，此时左指针指向重复字符，然后左指针向右移动，有指针也向右移动
     *
     *  如果有指针不在散列表中，说明没有重复
     *      有指针继续向右移动
     *  计算散列表中字符的个数，且更新返回的变量
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if(s.length()==0) return 0;
        if(s.length()==1) return 1;
        int length = 0;
        int left = 0;
        int right = left+1;
        Map<Character, Integer> set = new HashMap<>();
        set.put(s.charAt(left), left);
        while (left < s.length()-1 && right < s.length()){

            if(set.containsKey(s.charAt(right)))
            {
                int delTo = set.get(s.charAt(right));
                for(int i = left; i <=delTo;i++)
                {
                    set.remove(s.charAt(i));
                    left++;
                }

                set.put(s.charAt(right), right);
                right++;

            }
            else{

                set.put(s.charAt(right),right);

                right++;
            }
            if(length <set.size() ) length = set.size();
        }

        return length;
    }
}
