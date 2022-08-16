package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

public class Ex15<Key extends Comparable<Key>> {

    private int _size=0;
    private Key a[]=null;
    int _maxSize = 0;
    public Ex15(int maxSize){
        _maxSize = maxSize;
        a = (Key[]) new Comparable[maxSize+1];
    }

    public void insert(Key val)
    {
        if(isFull()) throw new IllegalArgumentException("queue is full");
        a[++_size] = val;
        swim(_size);
        
    }

    private boolean isFull() {
        return _size == _maxSize;
    }

    public Key delMin()
    {
        if(isEmpty()) throw new IllegalStateException("heap is empty");
        Key res = a[1];
        exch(1, _size--);
        sink(1);

        return  res;
    }

    public boolean isEmpty(){return _size == 0;}

    private boolean more(Comparable v, Comparable w){return v.compareTo(w)>0;}

    private void exch(int i , int j){
        Key t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void sink(int i){
        while(2*i <= _size)
        {
            int c = 2*i;
            if(c <_size && more(a[c], a[c+1])){
                c++;
            }

            if(more(a[i], a[c])){ exch(i,c );}
            else break;

            i = 2*i;
        }
    }

    private void swim(int i)
    {
        while(i>1)
        {
            int p = i/2;

            if(more(a[p], a[i])) exch(i, p);
            else break;

            i = i/2;
        }
    }

    private boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }
    public boolean isMinHeap()
    {
        for (int i = 1; i < _size ; i++) {

            int p = 2*i;
            if(p> _size) break;

            if(more(a[i], a[p])) return false;

            if(++p > _size) break;
            if(more(a[i], a[p])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer a[] = IntRandom.getIntRandom(9);
        Ex15<Integer> minPQ = new Ex15<Integer>(9);
        for (int i = 0; i < a.length; i++) {
            minPQ.insert(a[i]);
        }

        while(!minPQ.isEmpty()) {
            StdOut.println(minPQ.delMin());
        }

        boolean res = minPQ.isMinHeap();
        StdOut.println(res);
    }
}
