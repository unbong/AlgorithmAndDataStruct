package chapter2.section4;


import edu.princeton.cs.algs4.StdOut;

public class Ex27_HeapWithLastNode<Key extends Comparable<Key>> {


    private Key a[] = null;
    private int _size= 0;
    private int _maxSize = 0;

    private int _lastIndex = 0;

    public Ex27_HeapWithLastNode(int size)
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
        // 如果加进来的比最小的值还小 更新最小指针
        if(_lastIndex == 0) _lastIndex = 1;
        else if( less(tmp, a[_lastIndex])) {
            _lastIndex = _size;
        }
        while(i/2>0)
        {
            int p = i/2;
            if(less(a[p], tmp)) a[i] = a[p];
            else { break; }
            // 如果被加进来的项目是最小指针的子项目，则必会发生交换，更新指针。
            if( p == _lastIndex)
            {
                _lastIndex = i;
            }
            i = p;

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
        //
        if(_lastIndex == _size+1)
        {
            _lastIndex =i;
        }
    }

    public Key min()
    {
        return a[_lastIndex];
    }

    public static void main(String[] args) {

        Ex27_HeapWithLastNode pq = new Ex27_HeapWithLastNode(19);

        pq.insert(8);
        pq.insert(1);
        pq.insert(3);
        pq.insert(9);
        pq.insert(10);
        pq.insert(19);
        pq.insert(11);
        pq.insert(13);
        pq.insert(19);
        pq.insert(-1);

        while(pq.isEmpty() == false) {
            StdOut.print(pq.top());
            StdOut.println( " min " + pq.min());
        }


        StdOut.print();
    }
}
