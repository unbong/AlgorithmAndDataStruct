package chapter3;

import edu.princeton.cs.algs4.Queue;

public class SequentialSearchSt <Key, Value>{

    int N = 0 ;
    private Node root;
    private class Node
    {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    };

    public void put(Key key, Value value){
        if(key == null) throw new IllegalArgumentException("key argument of put is null.");
        if(value == null) delete(key);

        if(root == null) {
            root = new Node(key, value);
            N++;
            return;
        }

        Node node = root;

        while(node != null && node.next != null){
            if(node.key.equals(key)) {node.value = value; return;}

            node = node.next;
        }
        node.next = new Node(key, value);
        N++;
    }

    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException("key argument of get is null.");
        Node node = root;
        while(node != null){
            if(node.key.equals(key)){ return node.value;}
            node = node.next;
        }
        return null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public int size(){return N;}
    public void delete(Key key){
        if(key == null) throw new IllegalArgumentException("key argument of delete is null.");
        if(root == null) return;
        Node node = root;

        if(node != null && node.key.equals(key)){
            root = node.next;
            N--;
            return;
        }
        while(node != null && node.next != null){
            if(node.next.key.equals(key)){
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        N--;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<>();
        Node node = root;
        while(node != null){
            queue.enqueue(node.key);
            node = node.next;
        }
        return queue;
    }

}
