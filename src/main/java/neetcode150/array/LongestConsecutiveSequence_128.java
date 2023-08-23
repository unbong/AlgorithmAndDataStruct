package neetcode150.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSequence_128 {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for(int num: nums)
        {
            set.add(num);
        }

        int maxLen = 0;
        for(int num: nums)
        {
            int len = 1;
            if(!set.contains(num-1))
            {
                while(set.contains(++num))
                {
                    len++;
                }
                if(maxLen < len) maxLen = len;
            }
        }

        return  maxLen;
    }

//    public int longestConsecutive(int[] nums) {
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int num: nums){
//            if(map.containsKey(num))
//            {
//                map.compute(num, (key, oldVal)->oldVal+1);
//            }
//            else{
//                map.put(num, 0);
//            }
//        }
//
//
//        int max_len = 0;
//
//        HashSet<Integer> set = new HashSet<>();
//        for(Map.Entry<Integer, Integer> entry: map.entrySet())
//        {
//
//            int len = 0;
//            int currentItem = entry.getKey();
//            if(set.contains(currentItem)) continue;
//            while(map.containsKey(--currentItem))
//            {
//                len++;
//                set.add(currentItem);
//            }
//            currentItem = entry.getKey();
//            while(map.containsKey(++currentItem))
//            {
//                len++;
//                set.add(currentItem);
//            }
//
//            if(max_len < len) max_len = len;
//        }
//
//        if(max_len != 0|| nums.length > 0) return max_len+1;
//        return max_len;
//    }

}
