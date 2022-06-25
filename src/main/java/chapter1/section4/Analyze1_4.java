package chapter1.section4;

import java.util.*;

public class Analyze1_4 {

    /**
     * 1.4.15
     */

    public void threeSumFaster()
    {
        Map<Integer, List<Integer>> index = new HashMap<>();
    }

    /**
     * 1.4.16 最接近的一对
     * @param list
     */
    public Double[] findClosestPair(List<Double> list)
    {

        //List<Double> list = Arrays.asList(datas);
        list.sort(Comparator.comparingDouble(item->item));

        Double minValue = Double.MAX_VALUE ;
        Double tmpMin =0.0;
        Double[] pair= {0.0, 0.0};
        for(int i=0; i<list.size()-1; i++)
        {
            Double item = list.get(i);
            Double nextItem = list.get(i+1);
            if(  minValue.compareTo( Math.abs(item-nextItem )) > 0){
                minValue = Math.abs(item-nextItem );
                pair[0] = item;
                pair[1] = nextItem;
            }
        }

        return pair;
    }

    /**
     * 1.4.18
     *
     * @return
     */
    public int findLocalMinimum(List<Double> list)
    {
        int start = 0;
        int end = list.size()-1;
        int mid = -1;

        // 只有一个值
        if(end ==0 )
            return end;

        if(end == 1)
        {
            return list.get(start).compareTo(list.get(end)) > 0 ? start: end;
        }
        while(start < end)
        {
            mid = start + (end-start)/2;

            if(list.get(mid-1).compareTo(list.get(mid)) < 0
                    && list.get(mid).compareTo(list.get(mid+1))< 0)
            {
                return mid;
            }
            // todo

            return 0;

        }
        return 0;
    }


    /**
     * 1.4.20
     * @param arrays
     * @param X
     * @return
     */
    public int binaryFind_4_20(List<Integer> arrays, Integer X)
    {
        // 寻找最大值索引
        int maxIndex = -1;
        int start  = 0;
        int end = arrays.size()-1;
        int mid = -1;

        while(start<= end)
        {

            mid = start +(end - start)/2;
            if(mid < 0)
            {
                end = mid -1;
                continue;
            }
            if(mid > arrays.size() -1)
            {
                start = mid + 1;
                continue;
            }
            Integer p_m = Integer.MAX_VALUE;
            Integer n_m = Integer.MAX_VALUE;
            if(mid == 0)
            {
                p_m = arrays.get(mid);
            }
            else {
                p_m = arrays.get(mid-1);
            }
            if(mid ==  arrays.size() -1)
            {
                n_m = arrays.get(mid);
            }
            else {
                n_m = arrays.get(mid+1);
            }

            Integer m = arrays.get(mid);

            if(m.compareTo(p_m) > 0 &&
                m.compareTo(n_m) > 0)
            {
                maxIndex = mid;
                break;
            }
            else if(m.compareTo(p_m) >= 0 &&
                    m.compareTo(n_m) < 0)
            {
                start  = mid+1;
            }
            else if(m.compareTo(p_m) < 0 &&
                    m.compareTo(n_m) >= 0) {
                end = mid -1;
            }
            else {
                start = start +1;
                end = end-1;
            }

        }

        if(maxIndex == -1)
        {
           return -1;
        }

        start = 0;
        end = maxIndex;
        mid = -1;
        int Xindex = -1;

        while(start< end)
        {
            mid = start +(end - start)/2;
            if(mid < 0)
            {
                end = mid -1;
                continue;
            }
            if(mid > maxIndex)
            {
                start = mid + 1;
                continue;
            }

            Integer m = arrays.get(mid);


            if(m.compareTo(X) == 0)
            {
                Xindex =  mid;
                break;
            }
            else if(m.compareTo(X) > 0) {
                end = mid -1;

            }
            else if(m.compareTo(X) < 0)
            {
                start = mid+1;
            }
        }

        if(Xindex != -1)
        {
            return Xindex;
        }

        start = maxIndex;
        end = arrays.size()-1;
        mid = -1;

        while(start< end)
        {
            mid = start +(end - start)/2;
            if(mid < maxIndex)
            {
                end = mid -1;
                continue;
            }
            if(mid > arrays.size()-1)
            {
                start = mid + 1;
                continue;
            }

            Integer m = arrays.get(mid);


            if(m.compareTo(X) == 0)
            {
                Xindex =  mid;
                break;
            }
            else if(m.compareTo(X) > 0) {
                start = mid+1;
            }
            else if(m.compareTo(X) < 0)
            {
                end = mid -1;
            }
        }

        if(Xindex != -1)
        {
            return Xindex;
        }

        return -1;
    }

    /**
     * 1.4.22
     * @param arrays
     * @param X
     * @return
     */
    public int fibonacciBinarySearch(List<Integer> arrays, Integer X)
    {
        int size = arrays.size();
        Map<Integer, List<Integer>> fibos = new HashMap<>();
        int start = 0;
        int nextStart  = 1;
        int fibo = start + nextStart;
        fibos.put(fibo, new ArrayList<>());
        fibos.get(fibo).add(start);
        fibos.get(fibo).add(nextStart);

        while( fibo < size )
        {
           start = nextStart;
           nextStart = fibo;
           fibo = start + nextStart;
           fibos.put(fibo, new ArrayList<>());
           fibos.get(fibo).add(start);
           fibos.get(fibo).add(nextStart);
        }

        for (int i = 0; i < fibo-size; i++) {
            arrays.add(Integer.MAX_VALUE);
        }

        start = fibos.get(fibo).get(0);
        nextStart = fibos.get(fibo).get(1);
        int mid = start;
        // 斐波那契分割
        while(start >=0)
        {
            Integer midData = arrays.get(mid);
            if(midData.compareTo(X) > 0)
            {
                fibo = start;
                start = fibos.get(fibo).get(0);
                nextStart = fibos.get(fibo).get(1);
                mid = start;
            }
            else if(midData.compareTo(X)< 0)
            {
                fibo = nextStart;
                mid = start + fibos.get(fibo).get(0);
                start = fibos.get(fibo).get(0);
                nextStart = fibos.get(fibo).get(1);

            }
            else {
                return midData.intValue();
            }
        }

        return -1;

    }



//    public double FractionBinarySearch(List<Double>arrays, )
}
