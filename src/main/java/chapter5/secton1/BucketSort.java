package chapter5.secton1;


import utils.IntRandom;

import java.util.*;

/**
 * 桶排序
 */
public class BucketSort {

    public void sort(Comparable[] array){

        Comparable[] aux = new Comparable[array.length];
        // 统计频率
        Map<Comparable,Integer> map = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            if(map.containsKey(array[i]))
            {
                Integer c = map.get(array[i]);
                c++;
                map.replace(array[i], c);
            }
            else{
                map.put(array[i], 1);
            }
        }

        Integer firstItemCount = 0;
        Integer prevVal = 0;
        // 将其转换为索引
        for(Comparable key: map.keySet())
        {
            if(firstItemCount ==0){
                firstItemCount = map.get(key);
            }

            Integer val = map.get(key);
            map.replace(key, val-firstItemCount+prevVal);
            prevVal = val;
        }

        // 将数据分类
        for (int i = 0; i < array.length; i++) {
            aux[map.get(array[i]).intValue()] = array[i];
            Integer val = map.get(array[i]);
            val++;
            map.replace(array[i], val);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        Integer[] arr = IntRandom.getIntRandom(20);

    }

}
