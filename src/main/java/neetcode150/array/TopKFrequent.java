package neetcode150.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
    /**
     * 第一步统计每一个数字的频率，将数字作为键，频率为值保存在散列表中
     * 使用频率降序的有限队列，保存键值对，自动根据频率降序排列
     * 冲有限队列中取出前K个
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {


        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]))
            {
                map.compute(nums[i], (key, oldValue)->{return oldValue.intValue()+1;});
            }
            else
            {
                map.put(nums[i], 1);
            }

        }

        PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>(k,
                (first, second)->{return second.getValue()-first.getValue();});

        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {

            que.add(entry);
        }

        int [] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = que.poll().getKey();
        }

        return res;
    }
}
