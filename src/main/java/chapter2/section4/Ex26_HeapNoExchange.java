package chapter2.section4;


import edu.princeton.cs.algs4.StdOut;

public class Ex26_HeapNoExchange<Key extends Comparable<Key>> {


    private Key a[] = null;
    private int _size= 0;
    private int _maxSize = 0;

    public Ex26_HeapNoExchange(int size)
    {
        _maxSize = size;
        a = (Key[]) new Comparable[_maxSize+1];
    }


    public void insert (Key val)
    {
        if(isFull())
        {
            throw new IllegalStateException("queue is full.");
        }

        a[++_size] = val;
        swim(_size);
    }

    public Key top()
    {
        Key res = a[1];
        a[1] = a[_size--];
        sink(1);
        return res;
    }

    public int size(){return _size;}
    public boolean isEmpty(){return _size ==0;}
    public boolean isFull() {return _maxSize == _size;}
    private boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    private void exch(int i, int j)
    {
        Key t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void swim(int i){

        Key tmp = a[_size];
        while(i/2>0)
        {
            int p = i/2;
            if(less(a[p], tmp)) a[i] = a[p];
            else { break; }
            i = i/2;
        }
        a[i] = tmp;

    }

    private void sink(int i)
    {
        Key tmp = a[1];
        int c = 0;
        while(2*i<=_size)
        {
            c = 2*i;
            if(c<_size && less(a[c], a[c+1])) c++;

            if(less(tmp, a[c])) a[i] = a[c];
            else break;

            i = c;
        }
        a[i] = tmp;

    }

    public static void main(String[] args) {

        Ex26_HeapNoExchange pq = new Ex26_HeapNoExchange(9);

        pq.insert(8);
        pq.insert(1);
        pq.insert(3);
        pq.insert(9);
        pq.insert(10);

        while(pq.isEmpty() == false)
            StdOut.println(pq.top());

        StdOut.print();
    }
}
