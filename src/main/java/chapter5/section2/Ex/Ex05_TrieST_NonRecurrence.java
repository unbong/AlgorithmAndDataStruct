package chapter5.section2.Ex;

import chapter1.section3.Stack;


/**
 * todo 没做完
 * @param <Value>
 */
public class Ex05_TrieST_NonRecurrence<Value> {

    private int size;
    private Node root;
    private final static int R = 256;

    private static class Node{
        private Object value;
        private Node[] next = new Node[R];
        private int childSize;

    }


    public void put(String key, Value value){

        if(key == null ) throw new IllegalArgumentException("key argument of put is null.");
        if(value == null) delete(key);

        int deep = 0;
        if(root == null){
            root = new Node();
        }
        Node node = root;
        Node parent = node;

        while(deep < key.length()){
            char c = key.charAt(deep);
            parent = node;
            node = node.next[c];

            if(node == null){
                node = new Node();
            }

            parent.next[c] = node;
            node.childSize ++;

            if(deep == key.length()-1){
                if(node.value == null) size ++;
                node.value = value;
            }

            deep++;
        }

    }

    public Value get(String key){

        int deep = 0;
        Node node = root;


        while(deep <= key.length()){

            if(node == null) break;
            if( deep == key.length() && node.value != null) {
                return (Value) node.value;
            }

            if(deep == key.length()){
                break;
            }

            char c = key.charAt(deep);
            node = node.next[c];
            deep++;
        }
        return null;
    }

    public void delete(String key){

        int deep = 0;
        Node node = root;
        Node parent = node;
        Stack<Node> path = new Stack<>();
        while(deep <= key.length())
        {
            if(node == null) break;

            /**
             *   s
             *   h
             *   e
             */
            if(deep == key.length() && node.value != null){
                node.value = null;
                size--;
            }

            char c = key.charAt(deep);
            if(parent.next[c].childSize ==1)
            {
                parent.next[c] = null;
            }

            parent = node;
            node = node.next[c];

            deep++;
        }



        return ;
    }

}
