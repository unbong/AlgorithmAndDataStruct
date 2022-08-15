package chapter2;

public class IndexPQ<Key extends Comparable<Key>> {

    enum Orientation{
        MIN, MAX
    }
    int pq[];
    int qp[];
    Key[] a;
    Orientation _orientaition;
    int _size =0;
    public IndexPQ(int maxSize, Orientation orientaition)
    {
        a = (Key[]) new Comparable[maxSize+1];
        pq = new int[maxSize+1];
        qp = new int[maxSize+1];
        _orientaition = orientaition;
    }

    public void insert(int k , Key item)
    {
        if (contains(k)) throw new IllegalArgumentException("index is already exist.");
        _size++;
        pq[_size] = k;
        qp[k] = _size;
        a[k] = item;

        
    }

    public void change(int k , Key item){

    }

    public boolean contains(int k ){
        return false;
    }

    public void delete(int k ){

    }

    public Key top(){
        return null;
    }

    public int topIndex()
    {
        return -1;
    }


    public int  deleteTop()
    {
        return -1;
    }

    public boolean isEmpty(){
        return _size == 0;
    }

    public int size(){return _size;}

    private void swim(int k){
        while(k>1)
        {
            int p = k/2;
            if((_orientaition == Orientation.MAX && less(a[p], a[k]))
            || (_orientaition == Orientation.MIN && more(a[p], a[k])) ){
                exch(p, k);
            }
            else break;
            k = k/2;
        }
    }

    private  void sink(int k){
        while(2*k <=_size)
        {
            int c = 2*k;
            if(c+1<=_size)
            {
                if((_orientaition == Orientation.MAX && less(a[c], a[c+1]))
                    || (_orientaition == Orientation.MIN && more(a[c], a[c+1]))){
                    c++;
                }
            }

            if((_orientaition == Orientation.MAX && less(a[k], a[c]))
                    || (_orientaition == Orientation.MIN && more(a[k], a[c]))){
                exch(c,k);
            }
            k = 2*k;
        }
    }

    private boolean less(Key v, Key w){return v.compareTo(w) <0;}

    private boolean more(Key v, Key w) { return v.compareTo(w)>0;}

    private void exch(int i, int j)
    {
        int tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

}
