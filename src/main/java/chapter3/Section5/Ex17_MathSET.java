package chapter3.Section5;

import edu.princeton.cs.algs4.SET;

import java.util.TreeSet;

public class Ex17_MathSET<Key>{

    private TreeSet<Key> set;



    public Ex17_MathSET(Key[] universe){
        set = new TreeSet<>();
    }

    public void add(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");

        set.add(key);
    }

    public Ex17_MathSET<Key> complement(){
        return null;
    }

    public void union(Ex17_MathSET<Key> a){
        if(a == null) throw new IllegalArgumentException("a is null.");
        for (Key k: a.set ) {
            add(k);
        }
    }

    public void intersection (Ex17_MathSET<Key> a){
        if(a == null) throw new IllegalArgumentException("a is null.");

        for(Key k: a.set)
        {
            if ( contains(k) ) continue;
            delete(k);
        }
    }

    public void delete(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");
        if(contains(key))
            set.remove(key);
    }

    public boolean contains(Key key){
        return set.contains(key);
    }

    public boolean isEmpty(){
        return set.isEmpty();
    }

    public int size(){
        return set.size();
    }

}
