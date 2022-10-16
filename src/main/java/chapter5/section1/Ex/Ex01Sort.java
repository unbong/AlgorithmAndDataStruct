package chapter5.section1.Ex;


import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

import java.util.Map;
import java.util.TreeMap;

/**
 * 桶排序
 */
public class Ex01Sort {

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
                Integer val = map.get(key);
                map.replace(key, val-firstItemCount+prevVal);

            }else{
                Integer val = map.get(key);
                map.replace(key, val+prevVal);

            }
            prevVal =  map.get(key);;

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
        Ex01Sort ex = new Ex01Sort();
        ex.sort(arr);
        arr[1] =1;
        arr[3]=3;

        for (int i = 0; i < arr.length; i++) {
            StdOut.println(arr[i]);
        }
    }

}
