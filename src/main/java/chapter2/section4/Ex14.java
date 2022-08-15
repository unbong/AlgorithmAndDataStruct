package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

public class Ex14<Key extends Comparable<Key>> {


    public int count = 0;

    private Key a[] = null;
    private int _size = 0;
    private int _maxSize=0;

    public Ex14(int maxSize)
    {
        a =(Key[]) new Comparable[maxSize+1];
        _maxSize = maxSize;
    }

    public void insert(Key val)
    {
        count = 0;
        if (_size > _maxSize) throw new IllegalStateException("pq is full");

        a[++_size] = val;
        swim(_size);
    }

    public Key deleteMax()
    {
        count = 0;
        Key res = a[1];

        exch(1, _size--);
        sink(1);
        return res;
    }
    public void sink(int k)
    {
        while(2*k <= _size)
        {
            int c = 2*k;
            if(c < _size)
            {
                if(less(a[c], a[c+1] )) c++;
            }
            if(less(a[k],a[c])) exch(k,c);
            else break;
            k = 2*k;
        }
    }

    public void swim(int k)
    {

        while(k>1){
            int p = k/2;
            if(less(a[p], a[k]))
                exch(p,k);
            else break;
            k = k/2;
        }
    }

    private boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }

    private void exch(int i, int j)
    {
        count++;
        Key t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int N = 1024;
        Ex14<Integer> pq = new Ex14<>(N);

        Integer a[]=IntRandom.getIntRandom(N);

        for (int i = 0; i < a.length; i++) {
            pq.insert(a[i]);
        }

        int i = 1;

        StdOut.println(pq.deleteMax());
        StdOut.println(String.format("No%d coutn: %d ", i++, pq.count) );

        pq.insert(N);

        i++;
        StdOut.println(pq.deleteMax());
        StdOut.println(String.format("No%d coutn: %d ", i++, pq.count) );

        i++;
        StdOut.println(pq.deleteMax());
        StdOut.println(String.format("No%d coutn: %d ", i++, pq.count) );


        pq.insert(N);
        pq.insert(N-1);

        i++;
        StdOut.println(pq.deleteMax());
        StdOut.println(String.format("No%d coutn: %d ", i++, pq.count) );

        i++;
        StdOut.println(pq.deleteMax());
        StdOut.println(String.format("No%d coutn: %d ", i++, pq.count) );

        i++;
        StdOut.println(pq.deleteMax());
        StdOut.println(String.format("No%d coutn: %d ", i++, pq.count) );


    }

    private boolean isEmpty() {
        return _size == 0;
    }
}
