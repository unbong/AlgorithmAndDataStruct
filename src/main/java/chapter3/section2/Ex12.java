package chapter3.section2;

public class Ex12 <Key extends Comparable<Key>, Value>{


    private Node root;
    private class Node{
        public Key key;
        public Value value;
        public Node left, right;

        public Node(Key key , Value value){
            this.key = key;
            this.value = value;
        }
    }

    public void put(Key key , Value value){

        if(key == null) throw new IllegalArgumentException("key is null.");
        if(value == null) throw new IllegalArgumentException("value is null");

        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value){
        if(node == null) new Node(key, value);

        int cmp = key.compareTo(node.key);
        if(cmp > 0) node.right = put(node.right, key, value);
        else if(cmp < 0) node.left = put(node.left, key, value);
        else node.value = value;
        return node;
    }

    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");

        return get(root, key);
    }

    private Value get(Node node, Key key){
        if(node == null) return null;

        int cmp = key.compareTo(node.key);

        if(cmp > 0){
            return get(node.right, key);
        }
        else if(cmp < 0){
            return get(node.left, key);
        }
        else{
            return node.value;
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if( node== null ) return 0;
        return size(node.left)+ size(node.right)+1;
    }

    public Key min(){
        if(root== null) throw new RuntimeException("root is null.");
        return min(root).key;
    }

    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);
    }

    public Key max(){
        if (root == null) throw new RuntimeException("root is null.");
        return max(root).key;
    }

    private Node max(Node node){
        if(node.right == null) return node;
        return max(node.right);
    }

    public Key floor(Key key)
    {
        if(key == null) throw new IllegalArgumentException("key  argument of floor() is null.");

        return floor(root, key).key;
    }

    private Node floor(Node node, Key key){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        if(cmp <  0) return floor(node.left, key);
        Node t = floor(node.right, key);
        if(t != null)  return t;
        else return node;
    }


    public Key ceiling(Key key )
    {
        if (key == null) throw new IllegalArgumentException("key argument of ceiling is null.");
        return ceiling(root, key).key;
    }

    private Node ceiling(Node node, Key key){
        if(node == null ) return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        if(cmp > 0) return ceiling(node.right, key);
        Node t = ceiling(node.left, key);
        if (t != null) return t;
        else return node;
    }

    public void deleteMax(){
        if(root == null) throw new RuntimeException("root is null.");

        root = deleteMax(root);
    }

    private Node deleteMax(Node node){
        if(node.right== null) return node.left;
        node.right = deleteMax(node.right);
        return node;
    }

    public void deleteMin(){
        if(root == null) throw new RuntimeException("root is null.");

        root = deleteMin(root);
    }

    private Node deleteMin(Node node)
    {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    public void delete(Key key){
        if(key == null) throw new IllegalArgumentException("key argument of delete is null.");

        root = delete(root, key);
    }

    private Node delete(Node node, Key key){
        if (node == null ) return null;

        int cmp = key.compareTo(node.key);
        if(cmp > 0) node.right= delete(node.right , key);
        else if( cmp < 0) node.left = delete(node.left, key);
        else{
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;

            Node t = node;
            node = min(t.right);
            node.right = deleteMin(node.right);
            node.left = t.left;
        }
        return node;
    }

}
