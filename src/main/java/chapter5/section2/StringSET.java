package chapter5.section2;

import chapter1.section3.Queue;

/**
 * 字符串集合
 */
public class StringSET {

    private Node root;
    private int size;
    private class Node{
        private char c;
        private boolean isKey;
        private Node left, mid, right;
    }

    public void add(String key){
        if(key == null) throw new IllegalArgumentException("argument add is null");
        
        if(!contains(key)) size++;

        root = add (root, key, 0);
    }

    private Node add(Node node, String key, int d) {

        if(node == null) node = new Node();

        if( d == key.length()-1 )
        {
            node.isKey = true;
            return node;
        }

        char c = key.charAt(d);
        if( c < node.c ) node.left = add(node.left, key, d);
        else if(c > node.c) node.right =  add(node.right, key, d);
        else node.mid = add(node.mid, key, d+1);

        return node;

    }


    public boolean contains(String key) {
        if(key == null) throw new IllegalArgumentException("argument contains is null");
        if(key.length() == 0) throw new IllegalArgumentException("key length have to >= 0");

        return get(root, key, 0) != null;
    }

    private Node get(Node node, String key, int d){

        if(node == null) return null;

        if(d == key.length()-1 && node.isKey){
            return node;
        }

        if(d == key.length() -1 ){
            return null;
        }

        char c = key.charAt(d);
        if(c < node.c) return get(node.left, key, d);
        else if(c > node.c) return get(node.right, key, d);
        else return get(node.mid, key, d);
    }

    /**
     * todo
     * @param key
     */
    public void delete(String key){

    }

    public int sise(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        Queue<String> queue = new Queue<>();
        collect(root, new StringBuilder(), queue);
        StringBuilder sb = new StringBuilder();
        for(String item:queue){
            sb.append(item);
            sb.append(", ");
        }

        return sb.toString();

    }

    private void collect(Node node, StringBuilder key, Queue<String> queue){
        if(node == null) return ;

        if(node.isKey  ) queue.enqueue(key.toString()+node.c);

        collect(node.left, key, queue);
        collect(node.right,key, queue);
        collect(node.mid, key.append(node.c), queue);
        key.deleteCharAt(key.length()-1);

    }
}
