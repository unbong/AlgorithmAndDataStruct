package chapter3.Section5;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Ex3_BinarySearchSET <Key extends Comparable<Key>>{

    private Node root;

    private class Node{
        Key key;
        Node left, right;
        int size ;
        public Node(Key k, int size){
            key = k;
            this.size = size;
        }
    }

    public boolean isEmpty(){
        return root ==null;
    }

    public int size(){
        return size(root);
    }

    private int size(Node node)
    {
        if(node == null) return 0;
        return node.size;
    }

    public void add(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");

        root = add(root, key);
    }

    private Node add(Node node, Key key){
        if(node == null) return new Node(key,1);

        int cmp = key.compareTo(node.key);
        if(cmp > 0) node.right = add(node.right,key);
        else if(cmp < 0) node.left = add(node.left, key);

        node.size = size(node.left) + size(node.right) +1;
        return node;
    }

    public boolean contains(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");

        return contains(root, key) != null;

    }

    private Node contains(Node node, Key key)
    {
        if(node == null) return null;
        int cmp = key.compareTo(node.key);

        if(cmp > 0) return contains(node.right,key);
        else if(cmp <0) return contains(node.left, key);

        return node;

    }

    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("key is null.");

        root = delete(root, key);

    }

    private Node delete(Node node, Key key)
    {
        if(node == null) return null;

        int cmp = key.compareTo(node.key);
        if(cmp > 0) node.right = delete(node.right, key);
        else if(cmp < 0) node.left = delete(node.left, key);
        else{
            if(node.left == null) return node.right;
            if(node.right == null) return node.left;

            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;

        }
        node.size = size(node.left) + size(node.right) +1;
        return node;
    }

    public void deleteMin(){
        if(isEmpty())  throw new NoSuchElementException("Symbol table underflow.");
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if(node.left== null) return node.right;

        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right)+1;
        return node;
    }

    public void deleteMax(){
        if(isEmpty())  throw new NoSuchElementException("Symbol table underflow.");
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if(node.right== null) return node.left;

        node.right = deleteMin(node.right);
        node.size = size(node.left) + size(node.right)+1;
        return node;
    }

    public Key min(){
        if(isEmpty())  throw new NoSuchElementException("Symbol table underflow.");
        return min(root).key;
    }

    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);
    }

    public Key max(){
        if(isEmpty())  throw new NoSuchElementException("Symbol table underflow.");
        return max(root).key;
    }

    private Node max(Node node){
        if (node.right == null) return node;
        return max(node.right);
    }

    public Key ceiling(Key key ){
        if(key == null) throw new IllegalArgumentException("key is null.");

        return ceiling(root, key).key;
    }

    private Node ceiling(Node node, Key key){
        if(node == null) return null;

        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        else if(cmp > 0 ) return ceiling(node.right, key);
        else{
            Node t = ceiling(node.left,key);
            if(t== null) return node;
            else return t;
        }

    }
    public Key floor(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");
        return floor(root, key).key;
    }

    private Node floor(Node node, Key key) {
        if(node == null) return null;

        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        else if(cmp< 0) return ceiling(node.left, key);
        else{
            Node t = floor(node.right,key);
            if(t == null) return node;
            else return t;
        }
    }

    public int rank(Key key){
        if (key == null) throw new IllegalArgumentException("key is null.");
        return rank(root, key);
    }

    private int rank(Node node, Key key){
        if(node == null) return 0;
        int cmp = key.compareTo(node.key);

        if(cmp > 0){
            return size(node.left)+ 1 + rank(node.right,key);
        }
        else if(cmp <0)
            return rank(node.left, key);
        else
            return size(node.left) +1;
    }

    public Key select(int i){
        if (i<0 || i>size()-1)  throw new IllegalArgumentException("i is not in range.");

        return select(root, i).key;
    }

    private Node select(Node node, int i){
        if(node == null) return null;

        // i < 根结点数
        if(i < size(node.left) ){
            return select(node.left, i);
        }
        else if(i>size(node.left))
        {
            return select(node.right, i-size(node.left) -1);
        }
        else return node;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<>();
        keys(root, min(), max(), queue);
        return queue;
    }

    public Iterable<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new Queue<>();
        keys(root, lo, hi, queue);
        return queue;
    }

    private void keys(Node node, Key l, Key r, Queue<Key> queue)
    {

        if(node == null) return ;

        if(l.compareTo(node.key)< 0){
            keys(node.left,l, r, queue);
        }
        if(r.compareTo(node.key) > 0){
            keys(node.right, l, r, queue);

        }
        if(l.compareTo(node.key) <= 0 && r.compareTo(node.key) >=0){
            queue.enqueue(node.key);
        }

    }



    public static void main(String[] args) {

    }



}
