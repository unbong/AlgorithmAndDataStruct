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
        swim(_size);
    }

    public void change(int k , Key item){

        if(contains(k) == false)  throw new IllegalArgumentException("k is not eixst.");
        a[k] = item;

        swim(qp[k]);
        sink(qp[k]);
    }

    public boolean contains(int k ){
        return qp[k] > 0;
    }

    public void delete(int k ){
        int tmp = qp[k];
        a[k] = null;

        exch(tmp, _size);
        _size--;
        swim(tmp);
        sink(tmp);
        a[k] = null;
        qp[k] = -1;
    }

    public Key top(){

        Key res = a[pq[1]];
        deleteTop();
        return res;
    }

    public int topIndex()
    {
        return pq[1];
    }


    public int  deleteTop()
    {
        delete(pq[1]);
        return 1;
    }

    public boolean isEmpty(){
        return _size == 0;
    }

    public int size(){return _size;}

    private void swim(int k){
        while(k>1)
        {
            int p = k/2;
            if((_orientaition == Orientation.MAX && less(a[pq[p]], a[pq[k]]))
            || (_orientaition == Orientation.MIN && more(a[pq[p]], a[pq[k]])) ){
                exch(p, k);
            }
            else break;
            k = k/2;
        }
    }

    private  void sink(int k){
        while(k > 0 && 2*k <=_size)
        {
            int c = 2*k;
            if(c+1<=_size)
            {
                if((_orientaition == Orientation.MAX && less(a[pq[c]], a[pq[c+1]]))
                    || (_orientaition == Orientation.MIN && more(a[pq[c]], a[pq[c+1]]))){
                    c++;
                }
            }

            if((_orientaition == Orientation.MAX && less(a[pq[k]], a[pq[c]]))
                    || (_orientaition == Orientation.MIN && more(a[pq[k]], a[pq[c]]))){
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

    public static void main(String[] args) {
        IndexPQ<Integer> ipq = new IndexPQ<>(10,IndexPQ.Orientation.MAX );

        ipq.insert(1, 4);
        ipq.insert(2, 5);
        ipq.insert(3, 6);

        Integer i = ipq.top();
        i = ipq.top();
        i = ipq.top();
    }

}
