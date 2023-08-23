package neetcode150.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum_1 {

    /**
     * 将每一个nums的项目作为键，对应的索引的集合作为值生成一个散列map。
     * 将和的问题转化为搜索问题
     * 在散列表中查找target-nums[i]的值是否存在
     *  如果存在
     *      则继续判断是否与nums[i]是否为同一个索引值
     *          如果是，则下一个
     *          如果不是，则说明找到了对应的值
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0; i<nums.length; i++)
        {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if(map.containsKey(key) && i != map.get(key))
            {
                return new int[]{i, map.get(key)};
            }
        }
        return new int[] {};

//        int[] res = {0,0} ;
//        boolean containFlg = false;
//        HashMap<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int key = nums[i];
//            if(map.containsKey(key))
//            {
//                List<Integer> indices = map.get(key);
//                indices.add(i);
//                map.put(key, indices);
//            }
//            else {
//                List<Integer> indices = new ArrayList<>();
//                indices.add(i);
//                map.put(nums[i], indices);
//            }
//
//        }
//
//        for(int i=0; i < nums.length; i++){
//            int searchKey = target - nums[i];
//            if(map.containsKey(searchKey)  )
//            {
//                boolean isSameIndex = false;
//                List<Integer> indices = map.get(searchKey);
//                int val = -1;
//                for(Integer index: indices)
//                {
//                    if(i == index && indices.size()==1) {
//                        isSameIndex = true;
//                        break;
//                    }else if (i != index){
//                        val = index;
//                        break;
//                    }
//                }
//                if(isSameIndex) continue;
//                res[0] = i;
//                res[1] =val;
//                containFlg = true;
//                break;
//            }
//        }
//
//        if(!containFlg)  return null;
//        return  res;



    }
}
