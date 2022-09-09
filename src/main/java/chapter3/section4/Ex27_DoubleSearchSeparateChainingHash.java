package chapter3.section4;

import chapter3.SequentialSearchSt;
import edu.princeton.cs.algs4.StdOut;


public class Ex27_DoubleSearchSeparateChainingHash <Key, Value>{

    private int M;
    private int N;
    private int avgSearchLimit;


    private SequentialSearchSt<Key, Value> st[];

    public Ex27_DoubleSearchSeparateChainingHash(int m, int avgSearchLimit)
    {
        M = m;
        this.avgSearchLimit = avgSearchLimit;
        st = (SequentialSearchSt<Key, Value>[]) new SequentialSearchSt[m];
    }


    private int hash(Key key){
        int hash = (11 * key.hashCode())%M;
        return hash;
    }

    private int hash2(Key key){
        int hash = (17 * key.hashCode())%M;
        return hash;
    }

    public void put(Key key, Value value){

        if(key == null) throw new IllegalArgumentException("key is null.");
        if(value == null) delete(key);

        int i = hash(key);
        int i2 = hash2(key);
        SequentialSearchSt<Key,Value > chain;
        if(st[i].size() > st[i2].size()){
            chain= st[i2];
        }
        else{
            chain = st[i];
        }

        int chainSize = chain.size();

        chain.put(key,value);

        if(chainSize < chain.size() )
            N++;

        if(avgSearchLimit * M < N)
            resize(2*M);

    }

    public void delete(Key key)
    {
        if(key == null) throw new IllegalArgumentException("key is null.");

        int i = hash(key);
        SequentialSearchSt<Key, Value> chain = st[i];
        int chainSize = chain.size();
        chain.delete(key);
        if(chainSize > chain.size())
        {
            N--;
            if(N>1 &&  N *8 < avgSearchLimit * M)
                resize( M /2);
            return;
        }


        i = hash2(key);

        chain = st[i];
        chainSize = chain.size();
        chain.delete(key);
        if(chainSize > chain.size())
        {
            N--;
            if(N>1 &&  N *8 < avgSearchLimit * M)
                resize( M /2);
        }

    }

    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");

        int i = hash(key);



        return null;
    }

    private void resize(int m)
    {

    }

    public static void main(String[] args) {
        Character a = 'a';
        StdOut.print(a.hashCode());
    }
}
