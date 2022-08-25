package chapter2.section5;

/**
 *
 * 解 使用自增索引，为每一个项目设置索引值，索引值也参与比较。
 * @param <key>
 */
public class Ex24_StablePriorityQueue <key extends Comparable<key>>{


    private key[] a = null;
    private int size = 1;
    private long[] time ;
    private long timeStamp = 1;
    private int N =0;

    public Ex24_StablePriorityQueue(int maxSize)
    {
        a = (key[]) new Comparable[maxSize+1];
        time = new long[maxSize+1];
        N = maxSize;
    }

    private void resize(){

    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public boolean isFull(){
        return N == size;
    }

    public int size(){return size;}

    public void insert(key item)
    {
        if(isFull()) throw new RuntimeException("pq is full");

        a[size] = item;
        time[size] = ++timeStamp;
        swim(size);
        size++;
    }

    public key delMin()
    {
        if(isEmpty()) throw new RuntimeException("PQ is empty");
        exch(1, size);
        key res = a[size];
        a[size] = null;
        time[size--] =0;
        sink(1);
        return res;
    }

    private void sink(int i){
        while(2*i<=size)
        {
            int c = 2*i;
            if(c< size){
                if(greater(c,c+1)) c++;
            }

            if(greater(i,c))
            {
                exch(i, c);
            }
            else break;
            i = c;
        }
    }

    private void swim(int i){

        while(i/2>1){
            int p = i/2;
            if(greater(p, i))
            {
                exch(p,i);
            }
            else break;
            i = p;
        }
    }

    private boolean greater(int v, int w)
    {
        int cmp = a[v].compareTo(a[w]);
        if(cmp>0) return true;
        else if(cmp<0) return false;

        return time[v]> time[w];
    }

    private void exch(int i, int j){
        key tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
        long timeTmp = time[i];
        time[i] = time[j];
        time[j] = timeTmp;
    }

}
