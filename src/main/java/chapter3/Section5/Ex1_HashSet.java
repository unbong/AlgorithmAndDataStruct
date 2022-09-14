package chapter3.Section5;

import chapter3.LinearProbingHashTable;

public class Ex1_HashSet<Key> {

    private LinearProbingHashTable<Key, Integer> st ;
    private static final Integer ZERO = 0;

    public Ex1_HashSet(){
        st = new LinearProbingHashTable<>();
    }


    public int size(){return st.size();}

    public boolean isEmpty(){
        return st.isEmpty();
    }

    public void add(Key key){
        st.put(key, ZERO);
    }


    public boolean contains(Key key){
        return st.contains(key);
    }

    public void delete(Key key){
        st.delete(key);
    }


}
