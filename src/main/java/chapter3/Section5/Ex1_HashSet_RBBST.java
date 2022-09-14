package chapter3.Section5;

import chapter3.RedBlackTree;

public class Ex1_HashSet_RBBST<Key extends Comparable<Key>> {

    private RedBlackTree<Key, Integer> st;
    private static final Integer ZERO = 0;

    public Ex1_HashSet_RBBST()
    {
        st = new RedBlackTree<>();
    }

    public void put(Key key){
        st.put(key ,ZERO);
    }

    public void delete(Key key){
        st.delete(key);
    }

    public boolean contains(Key key){
        return st.contains(key);
    }

    public boolean isEmpty(){
        return st.isEmpty();
    }

    public int size()
    {
        return st.size();
    }


}
