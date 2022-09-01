package chapter3.section2;

public class Ex34_LinearST <Key extends Comparable<Key> , Value>{
    private Node root;
    private class Node{
        Key key;
        Value value;
        Node left, right;
        Node pred, succ;
        int size;
        public Node(Key k, Value v, int s){
            key = k;
            value = v;
            size = s;
        }
    }

    public void put(Key key , Value value){
        if(key == null) throw new IllegalArgumentException("key argument of put is null.");
        if(value == null) throw new IllegalArgumentException("value argument of put is null.");

        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value){
        if(node == null) new Node(key, value, 1);

        int cmp = key.compareTo(node.key);

        if(cmp > 0){
            node.right = put(node.right, key,value);

        }
        else if(cmp <0){
            node.left = put(node.left, key, value);
        }
        else{
            node.value = value;
        }
        return node;
    }
}
