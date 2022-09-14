package chapter3.Section5;

public class Ex8_LPHashST_DuplicateValue <Key , Value>{

    private Key keys[];
    private Value values[];
    private int M;
    private int N;
    private int lgM;
    private final static int INIT_CAPACITY = 16;

    // 各种数的*2 后小于该数的最大素数集合
    private final static int PRIMES[] ={1, 1, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
            32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
            8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
            536870909, 1073741789, 2147483647};

    public Ex8_LPHashST_DuplicateValue(){
        this(INIT_CAPACITY);
    }

    public Ex8_LPHashST_DuplicateValue(int capacity){
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        M = capacity;
        lgM = (int)(Math.log(capacity) / Math.log(2));

    }

    public int hash(Key key){
        int hash = key.hashCode() & 0x7fffffff;

        if(lgM < 26)
            hash =  hash % PRIMES[lgM+5];

        return hash % M;
    }

    public int size(){return N;}
    public boolean isEmpty(){return N==0;}

    public void put(Key key, Value value){
        if(key == null) throw new IllegalArgumentException("key is null.");
        if(value == null) delete(key);

        int i = hash(key);
        Key k = keys[i];
        while(k != null){
            i = (i+1) %M;
            k = keys[i];
        }

        keys[i] = key;
        values[i] = value;
        N++;
        if(M<= 2*N) {
            resize(2*M);
            lgM++;
        }

    }

    public void delete(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");

        if( !contains(key)) return ;

        int i = hash(key);
        int fp = -1;
        Key k = keys[i];
        while(k != null)
        {
            if(key.equals(k) ) {
                values[i] = null;
                keys[i] = null;
                if(fp<0) fp = i;
                N--;
            }
            i = (i+1) % M;
            k = keys[i];
        }

        for (int j = fp+1; j <i ; j++) {

            Key t = keys[j];
            if(t == null ) continue;
            Value v = values[j];

            keys[j] = null;
            values[j] = null;
            N--;
            put(t,v);
        }

        if( N >1 && 8* N <= M) {
            resize(M/2);
            lgM--;
        }
    }

    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");

        int i = hash(key);

        Key k = keys[i];
        while(k != null)
        {
            if(key.equals(k) ) { return values[i];}
            i = (i+1) % M;
            k = keys[i];
        }

        return null;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    private void resize(int m){
        Ex8_LPHashST_DuplicateValue<Key, Value> st = new Ex8_LPHashST_DuplicateValue<>(m);

        for (int i = 0; i < M; i++) {
            if(keys[i] != null)
            {
                st.put(keys[i], values[i]);
            }
        }
        values = st.values;
        keys = st.keys;
        M = m;
    }


}
