package chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import utils.ArrayUtils;
import utils.IntRandom;

/**
 * 2.4 优先队列
 */
public class PriorityQueue<key extends Comparable<key>> {
    private  key[] a = null;
    private int _size = 0;
    private Orientation _orientation;

    public enum Orientation{
        MAX,MIN;
    }
    public PriorityQueue(int size , Orientation orientation){
        a =(key[]) new Comparable[size+1];
        _orientation = orientation;

    }

    public PriorityQueue(key[] a,  Orientation orientation)
    {

    }

    private  boolean isFull()
    {
        return a.length == _size;
    }

    public boolean isEmpty()
    {
        return _size == 0;
    }

    public void insert(key  v)
    {
        if(isFull())
        {
            // todo 扩容
            throw new IllegalStateException("queue is full");
        }

        a[++_size] = v;

        swim(_size);
    }

    public key max()
    {
        if(isEmpty())
        {
            throw new IllegalMonitorStateException("queue is empty");
        }

        key res = a[1];

        exch(1, _size--);
        sink(1);

        return res;
    }

    private void sink(int index) {

        int child = 2* index;
        while(child<=_size)
        {

            if(child< _size)
                if((_orientation == Orientation.MAX && less(a[child], a[child+1]))
                        || (_orientation == Orientation.MIN && more(a[child], a[child+1])) ) child++;

            if((_orientation == Orientation.MAX &&less(a[index], a[child]))
                || _orientation == Orientation.MIN && more(a[index], a[child]))  exch(index,child);
            else break;
            index = child;
            child = child*2;

        }
    }


    private void swim(int index) {


        while(index>1 )
        {
            if( (_orientation == Orientation.MAX && less(a[index/2], a[index]))
                    || (_orientation == Orientation.MIN && more(a[index/2], a[index]))  )
            {
                exch(index/2, index);
            }
            else break;

            index = index/2;
        }
    }

    private boolean more(key v, key w)
    {
        return v.compareTo(w)>0;
    }

    private boolean less(key v, key w)
    {
        return v.compareTo(w)<0;
    }

    private void exch(int i, int j)
    {
        key tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }


    public static void main(String[] args) {

        Integer a[] = IntRandom.getIntRandom(9);
        PriorityQueue<Integer> q = new PriorityQueue<>(9, Orientation.MIN);

        ArrayUtils.show(a);

        for (int i = 0; i < a.length; i++) {
            q.insert(a[i]);
        }

        while (!q.isEmpty())
        {
            StdOut.print(q.max().intValue()+", ");
        }

    }


}
