package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;

public class Ex13<Key extends Comparable<Key>> {


    private Key a[] = null;
    private int _size = 0;
    private int _maxSize=0;

    public Ex13(int maxSize)
    {
        a =(Key[]) new Comparable[maxSize+1];
        _maxSize = maxSize;
    }

    public void insert(Key val)
    {
        if (_size > _maxSize) throw new IllegalStateException("pq is full");

        a[++_size] = val;
        swim(_size);
    }

    public Key deleteMax()
    {
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

            if( a[c].compareTo(a[_size]) != 0 && less(a[c], a[c+1] )) c++;

            if(less(k,c)) exch(k,c);
            else break;
            k = c;
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
        Key t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {

        Ex13<Character> ex6 = new Ex13<>(20);
        ex6.insert('P');
        ex6.insert('R');
        ex6.insert('I');
        ex6.insert('O');
        ex6.insert('R');
        ex6.insert('A');
        ex6.insert('Z');
        ex6.insert('H');
        Character i =ex6.deleteMax();
        StdOut.println(i);
        StdOut.println(ex6.deleteMax());
        StdOut.println(ex6.deleteMax());
        StdOut.println(ex6.deleteMax());
    }
}
