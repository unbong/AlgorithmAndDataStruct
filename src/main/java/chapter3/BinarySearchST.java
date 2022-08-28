package chapter3;


import edu.princeton.cs.algs4.Queue;

import java.util.NoSuchElementException;

public class BinarySearchST<Key extends Comparable<Key>, Value>  {

    private Key keys[];
    private Value values[];
    private int size;

    private int INIT_SIZE=8;

    public BinarySearchST()
    {
        new BinarySearchST(INIT_SIZE);
    }

    public BinarySearchST(int maxSize)
    {
        keys = (Key[]) new Comparable[maxSize];
        values = (Value[]) new Object[maxSize];
    }

    public void put(Key key, Value value)
    {
        if(key == null) throw new IllegalArgumentException("key is null.");
        if(value == null) {
            delete(key);
            return;
        }

        int i = rank(key);
        if(i < size && key.compareTo(select(i)) == 0) values[i] = value;

        if(i == keys.length) resize( 2* keys.length);

        int j = size;
        for (; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[j] = key;
        values[j] = value;
        size++;
    }

    /**
     *
     * @param key
     * @return
     */
    public Value get(Key key)
    {
        if(key == null) throw new IllegalArgumentException("key is null.");

        int i = rank(key);
        if(i<size && key.compareTo(select(i)) == 0) return values[i];
        return null;
    }

    public void delete(Key key)
    {
        if(key == null) throw new IllegalArgumentException("key is null.");

        int i = rank(key);
        if(i<size && key.compareTo(select(i)) == 0)
        {
            for (int j = i; j < size; j++) {
                keys[j] = keys[j+1];
                values[j] = values[j+1];
            }
            keys[size-1] = null;
            values[size-1] = null;
        }
        size--;

        if(keys.length > 0 && size <= keys.length/4) resize(keys.length/2);
    }

    public boolean contain(Key key)
    {
        if(key == null) throw new IllegalArgumentException("key is null.");

        int i = rank(key);
        return get(key) != null;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size(){return size;}


    public Key min(){
        if(isEmpty()) throw new RuntimeException("ST is empty;");
        return keys[0];
    }

    public Key max()
    {
        if(isEmpty()) throw new RuntimeException("ST is empty");
        return keys[size-1];
    }

    /**
     * 小于等于key的最大值
     * @param key
     * @return
     */
    public Key floor(Key key)
    {
        if(key == null) throw new IllegalArgumentException("key is null.");
        int i = rank(key);
        if(i<size && key.compareTo(keys[i]) ==0) return keys[i];
        else if(i == 0) {throw new NoSuchElementException("");}
        else { return keys[i-1]; }

    }


    /**
     * 大于等于key的最小值
     * @param key
     * @return
     */
    public Key ceiling(Key key)
    {
        if(key == null) throw new IllegalArgumentException("key is null.");

        int i = rank(key);
        if(i == size ) throw new NoSuchElementException("");
        return keys[i];
    }

    public int rank(Key key)
    {
        int lo = 0;
        int hi = size-1;

        while(lo<=hi)
        {
            int mid = lo + (hi-lo)/2;
            if(keys[mid].compareTo(key) == 0) return mid;
            else if(keys[mid].compareTo(key) > 0) hi = mid -1;
            else if(keys[mid].compareTo(key) < 0) lo = mid+1;
        }
        return lo;
    }

    public Key select(int i)
    {
        if(i>=size ) throw new IllegalArgumentException("i greater than maxSize.");
        if(i<0) throw new IllegalArgumentException("i must greater then 0.");
        return keys[i];
    }

    public void delMin(){
        delete(min());
    }

    public void delMax(){
        delete(max());
    }

    /**
     *
     *
     * @param lo
     * @param hi
     * @return
     */
    public int size(Key lo, Key hi)
    {
        if(lo == null) throw new IllegalArgumentException("first of keys is null.");
        if(hi == null) throw new IllegalArgumentException("second of keys is null.");

        if(lo.compareTo(hi) > 0) return 0;
        if(contain(hi)) return rank(hi) - rank(lo) +1;
        else return rank(hi)-rank(lo);

    }


    public Iterable<Key> keys(Key lo, Key hi)
    {
        if(lo == null) throw new IllegalArgumentException("first of keys is null.");
        if(hi == null) throw new IllegalArgumentException("second of keys is null.");

        Queue<Key> queue = new Queue<>();
        if(lo.compareTo(hi)>0) return queue;
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if(contain(hi)) queue.enqueue(keys[rank(hi)]);
        return queue;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    private void resize(int newSize)
    {
        Key nK[] = (Key[]) new Comparable[newSize];
        Value nV[] = (Value[]) new Object[newSize];

        for (int i = 0; i < this.size; i++) {
            nK[i] = keys[i];
            nV[i] = values[i];
        }
        keys = nK;
        values = nV;
    }
}
