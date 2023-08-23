package neetcode150.twopoint;


import java.util.*;

public class ContainerWithMostWater_11 {

    /**
     * 使用左右两个指针的例子
     *   该题的目的是求面积的最大值
     *   面积可表示为底*高
     *   首先指针在最左边且另一个指针在最右边时计算一次面积
     *   假设计算一次如果左边的较小时，就移动左边的指针，这样才会有可能使面积变大，如果左边不动，动了右边的话，高因为不变或变小，面积可能更小
     *   同理右边较小时移动左边
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {


        int left = 0;
        int right = height.length-1;

        int maxAre = 0;

        while(left < right)
        {
            int h = Integer.min(height[left], height[right]);
            maxAre = Integer.max(maxAre, (right-left)*h);
            if(height[left] < height[right])
            {
                left++;
            }
            else{
                right--;
            }
        }
        return maxAre;

//
//        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
//        int maxVal = 0;
//        // 将高度为键，索引为值 构建一个平衡树的map，用于查找
//        for (int i = 0; i < height.length ; i++) {
//            int key = height[i];
//            if(map.containsKey(key))
//            {
//                List<Integer> l = map.get(key);
//                l.add(i);
//                map.put(key,l);
//
//            }else{
//                List<Integer> l = new ArrayList<>();
//                l.add(i);
//                map.put(key,l );
//            }
//        }
//
//        //
//
//        int pinHeight= height[0];
//
//        for (int indexBegin = 0; indexBegin < height.length-1; indexBegin++) {
//            int heightBegin = height[indexBegin];
//            if(pinHeight > heightBegin) {
//                //pinHeight = heightBegin;
//                continue;
//            }
//            pinHeight = heightBegin;
//            // 去找比当前高度高，且其中最小的项目
////            Map.Entry<Integer, List<Integer>> entry= map.higherEntry(heightBegin);
//            SortedMap<Integer, List<Integer>> sm = map.headMap(heightBegin);
//            for(Map.Entry<Integer, List<Integer>> entry:sm.entrySet())
//            {
//                // 去查找当前索引右边的项目，如果找到则计算面积
//                for(int index: entry.getValue()){
//                    if(indexBegin < index){
//                        int val = (index-indexBegin) * entry.getKey();
//                        if(maxVal < val) maxVal = val;
//                    }
//                }
//            }
//
//
//            // 去查找比自己的高度高或等于自己（但是索引不同）
//            NavigableMap<Integer, List<Integer>> nm = map.tailMap(heightBegin,true);
//            for(Map.Entry<Integer, List<Integer>> entry: nm.entrySet())
//            {
//                for(int index: entry.getValue()){
//                    if(indexBegin < index){
//                        int val = (index-indexBegin) * heightBegin;
//                        if(maxVal < val) maxVal = val;
//                    }
//                }
//            }
//
//        }
//
//        return maxVal;
    }

}

