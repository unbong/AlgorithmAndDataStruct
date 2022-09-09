package chapter3;

import edu.princeton.cs.algs4.Queue;

public class SeparateChainingHashST<Key, Value>{

    int M ;
    int N;

    int avgSearchLimit;

    SequentialSearchSt<Key, Value> st [];

    private static final int[] primes={1, 1, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
            32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
            8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
            536870909, 1073741789, 2147483647};

    private static final int INIT_CAPACITY = 997;
    protected int lgM;

    public SeparateChainingHashST(){
        this(INIT_CAPACITY, 10);
    }

    public SeparateChainingHashST(int m, int avgSearch){
        this.M = m;
        this.avgSearchLimit = avgSearch;
        st = (SequentialSearchSt[]) new SequentialSearchSt[m];
        for (int i = 0; i < m ; i++) {
            st[i] = new SequentialSearchSt<>();
        }
        this.lgM = (int)(Math.log(M) / Math.log(2));
    }

//    public SeparateChainingHashST(int m){
//        this.M = m;
//        this.avgSearchLimit =10;
//        st = (SequentialSearchSt<Key, Value>[]) new SequentialSearchSt[m];
//        for (int i = 0; i < m; i++) {
//            st[i] = new SequentialSearchSt<>();
//        }
//        this.lgM = (int)(Math.log(m) / Math.log(2));
//
//    }

    public int size(){return N;}

    public boolean isEmpty(){return N == 0;}


    public void resize(int  n){
        SeparateChainingHashST<Key, Value> tmp = new SeparateChainingHashST<>(n, avgSearchLimit);

        for(Key key:keys())
        {
            tmp.put(key, get(key));
        }

        st = tmp.st;
        M = tmp.M;
    }

    public boolean contains(Key key){
        return get(key)!= null;
    }
    public void put(Key key, Value value){

        if(key == null) throw new IllegalArgumentException("key is null.");
        if(value == null) delete(key);

        int i = hash(key);


        SequentialSearchSt<Key, Value> chain = st[i];
        int chainSize = chain.size();
        chain.put(key, value);
        if(chainSize < chain.size())
            N++;

        if(N >= avgSearchLimit * M){
            resize(2*M);
        }
    }

    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");
        int i = hash(key);
        SequentialSearchSt<Key, Value> chain = st[i];
        return chain.get(key);
    }

    public void delete(Key key){
        int i = hash(key);

        SequentialSearchSt<Key, Value> chain = st[i];
        int chainSize = chain.size();
        chain.delete(key);
        if(chainSize > chain.size())
            N--;

        if(N>1 && N<M/4 ){
            resize(M/2);
        }

    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<>();
        for (SequentialSearchSt<Key, Value> item: st) {
            for(Key key: item.keys() )
            {
                queue.enqueue(key);
            }
        }

        return queue;
    }


    private int hash(Key key){
        int hash = key.hashCode() & 0x7fffffff;
        if(lgM<26){
            hash = hash % primes[lgM+5];
        }
        return hash % M;
    }
}
