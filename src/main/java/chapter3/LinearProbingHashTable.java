package chapter3;

import edu.princeton.cs.algs4.Queue;

public class LinearProbingHashTable <Key, Value>{

    protected Key keys[];
    protected Value values[];
    protected int N ;
    protected int M;
    private static final int INIT_CAPACITY =16;
    // 各种数的*2 后小于该数的最大素数集合
    private static final int[] PRIMES = {
            1, 1, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
            32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
            8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
            536870909, 1073741789, 2147483647
    };

    protected int lgM;

    public LinearProbingHashTable(){
        this(INIT_CAPACITY);
    }

    public LinearProbingHashTable(int m){
        keys = (Key[]) new Object[m];
        values =(Value[]) new Object[m];
        this.M = m;
        lgM = (int) (Math.log(m)/Math.log(2));
    }

    public int size(){return N;}

    public boolean isEmpty(){return N==0;}

    public boolean contains(Key key) {return get(key) != null;}


    public Value get(Key key){

        int i = hash(key);

        Key k = keys[i];

        while(k != null){
            if(k.equals(key) ) return values[i];

            i = (i + 1)%M;
            k = keys[i];
        }


        return null;
    }

    public void put (Key key , Value value){
        if(key == null) throw new IllegalArgumentException("key is null.");
        if(value == null) delete(key);


        int i = hash(key);

        Key k = keys[i];

        while(k != null){
            if(k.equals(key)) {
                values[i] = value;
                return;
            }
            i = (i+1) % M;
            k = keys[i];
        }

        keys[i] = key;
        values[i] = value;
        N++;

        if(M <= 2*N)
            resize(2*M);

    }

    public void delete(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");
        if(!contains(key)) return;


        int i = hash(key);

        Key k = keys[i];
        while(true)
        {
            if(key.equals(k))
            {
                values[i] = null;
                keys[i] = null;
                N--;
                break;
            }
            i = (i+1) %M;
            k = keys[i];
        }

        i = (i+1) %M;
        k = keys[i];
        while(k != null)
        {
            Key keyToMove = keys[i];
            Value valueToMove = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToMove, valueToMove);

            i = (i+1) %M;
            k = keys[i];
        }

        if(M>0 && M > 8 * N)
            resize(M/2);
    }

    public void resize(int M){

        LinearProbingHashTable<Key,Value> newTable = new LinearProbingHashTable<>(M);
        int m = this.M;
        this.M =  newTable.M;

        for (int i = 0; i < m ; i++) {
            if(keys[i] != null)
                newTable.put(keys[i], values[i]);
        }

        this.lgM = newTable.lgM;
        this.keys = newTable.keys;
        this.values = newTable.values;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<>();
        for (Key key:keys) {
            if(key != null)
                queue.enqueue(key);
        }
        return queue;
    }

    protected int hash(Key key){
        int hash = key.hashCode() & 0x7fffffff;

        if(lgM < 26)
            hash =  hash % PRIMES[lgM+5];

        return hash % M;
    }

}
