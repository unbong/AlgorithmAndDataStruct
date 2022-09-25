package chapter2.section4;

import chapter2.PriorityQueue;
import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

public class Ex30_DynamicMedian<Key extends Comparable<Key>>{

    private PriorityQueue<Key> maxPQ;
    private PriorityQueue<Key> minPQ;

    public Ex30_DynamicMedian(int size)
    {
        // 最大值为视为中位值
        maxPQ = new PriorityQueue<>(size, PriorityQueue.Orientation.MAX);
        // 最小值为中位值大的一个值
        minPQ = new PriorityQueue<>(size, PriorityQueue.Orientation.MIN);
    }

    public void insert(Key val)
    {
        if (minPQ.size() == 0) minPQ.insert(val);
        else{
            Key median = minPQ.peek();
            // 如果大与中位值，则插入到maxPQ中
            if(median.compareTo(val)>0)
            {
                maxPQ.insert(val);
            }
            else
            {
                minPQ.insert(val);
            }

            if(maxPQ.size() - minPQ.size() > 1)
            {
                minPQ.insert(maxPQ.pop());
            }else if(minPQ.size() - maxPQ.size() > 0)
            {
                maxPQ.insert(minPQ.pop());
                //maxPQ.insert(minPQ.max());
            }
        }

    }

    public Key median()
    {
        return maxPQ.peek();
    }

    public Key top()
    {
        return null;
    }

    public static void main(String[] args) {
        Ex30_DynamicMedian<Integer> pq = new Ex30_DynamicMedian<>(30);

        Integer a[] = IntRandom.getIntRandom(19);
        for (int i = 0; i <19 ; i++) {
            pq.insert(a[i]);

        }
        StdOut.println(pq.median());
    }

}
