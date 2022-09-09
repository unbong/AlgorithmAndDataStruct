package chapter3.section4;

import edu.princeton.cs.algs4.Queue;

public class Ex26_LinearProbingHashSTDelayDelete <Key, Value>{
    private Key keys[];
    private Value values[];
    private int M; // array size
    private int N; // key size
    private int lgM;

    private static final int PRIMES[] ={
            1, 1, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
            32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
            8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
            536870909, 1073741789, 2147483647};

    public Ex26_LinearProbingHashSTDelayDelete(int m ){

        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];

        this.M = m;
        lgM = (int)(Math.log(M) / Math.log(2));
    }

    public int size() {return N;}

    public void put(Key key, Value value)
    {
        if(key == null) throw new IllegalArgumentException("key is null.");
        if(value == null) delete(key);

        int i = hash(key);
        Key k = keys[i];
        Value v = values[i];
        while(k != null && v!= null){
            if(key.equals(k) ) {
                values[i] = value;
                return;
            }
            i = (i+1)%M;
            k = keys[i];
            v = values[i];
        }

        keys[i] = key;
        values[i] = value;
        N++;

        if(2*N>=M) {
            resize(2 * M);
            lgM++;
        }
    }

    private void resize(int i) {

        Ex26_LinearProbingHashSTDelayDelete st = new Ex26_LinearProbingHashSTDelayDelete(i);

        for(Key k :keys())
        {
            st.put(k, get(k));
        }
        M = st.M;
        N = st.N;
        values = (Value[]) st.values;
        keys = (Key[]) st.keys;
        //lgM = (int)(Math.log(M)/Math.log(2));

    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<>();
        for (int i = 0; i < M; i++) {
            if(values[i]!= null) queue.enqueue(keys[i]);
        }
        return queue;
    }

    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");

        int i = hash(key);
        Key k = keys[i];

        while(k != null )
        {
            if(key.equals(k)) return values[i];
            i = (i+1)%M;
            k = keys[i];
        }

        return null;
    }

    private int hash(Key key){
        int hash = key.hashCode() & 0x7FFFFFFF;

        if(lgM < 26)
            hash =  hash % PRIMES[lgM+5];

        return hash % M;
    }

    public void delete(Key key) {
        if(key == null) throw new IllegalArgumentException("key is null.");

        if(get(key) == null) return;

        int i = hash(key);

        Key k = keys[i];
        Value v = values[i];

        while(k!= null ){
            if(key.equals(k) && v == null ) return;
            else if(key.equals(k) && v != null) break;
            i = (i+1)%M;
            k=keys[i];
            v=values[i];
        }

        values[i] = null;
        N--;

        if( N>1 && 8*N<=M){
            resize(M/2);
            lgM--;
        }

    }


}
