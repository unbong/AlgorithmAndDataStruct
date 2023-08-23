package chapter3;

import chapter3.Section5.Ex3_BinarySearchSET;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree <Key extends Comparable<Key>, Value>{

    private class Node{
       public Key key;
       public Value value;
       public Node left;
       public Node right;
       public int size;

       public Node(Key key, Value value, int size)
       {
           this.key = key;
           this.value = value;
           this.size = size;
       }
    }

    private Node root;

    public BinarySearchTree(){

    }

    public int size(){
        return size(root);
    }

    /**
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value){

        if(key == null) throw new IllegalArgumentException("key is null");
        if(value == null) delete(key);
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value)
    {
        if(node == null) return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if(cmp > 0){
           node.right = put(node.right, key, value);
        }
        else if(cmp < 0)
        {
            node.left = put(node.left, key, value);
        }
        else{
            node.value = value;
        }

        node.size = size(node.left)+ size(node.right)+1;
        return node;
    }


    public int size(Node node)
    {
        if(node == null ) return 0;
        return node.size;
    }


    public Value get(Key key)
    {
        if(key == null) throw new IllegalArgumentException("key is null.");
        return get(root, key);
    }

    private Value get(Node node, Key key)
    {
        if(node == null) return null;

        int cmp = key.compareTo(node.key) ;
        if(cmp > 0)
        {
            return get(node.right, key);
        }
        else if(cmp < 0)
        {
            return get(node.left, key);
        }
        else{
            return node.value;
        }
    }

    public Key max(){
        if(root == null) throw new RuntimeException("root is null.");
        return max(root).key;
    }

    private Node max(Node node)
    {
        if(node.right == null) return node;
        return max(node.right);
    }

    public Key min(){
        if(root == null) throw new RuntimeException("root is null.");
        return min(root).key;
    }

    private Node min(Node node){

        if(node.left == null ) return node;
        return min(node.left);
    }


    public Key floor(Key key)
    {
        if(key == null) throw new IllegalArgumentException("key is null");
        if(root == null) throw new RuntimeException("root is null.");
        Node t = floor(root, key);
        if(t == null) throw new NoSuchElementException("argument floor is too small.");
        return t.key;
    }

    private  Node floor(Node node, Key key){

        if(node == null) return null;

        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        if(cmp < 0) return floor(node.left, key);
        Node t = floor(node.right, key);
        if(t != null) return t;
        else return node;

    }

    public Key ceiling(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");
        if(root == null) throw new RuntimeException("root is null");
        Node t = ceiling(root, key);
        if(t == null) throw new NoSuchElementException("argument ceiling is too large.");
        return t.key;
    }

    private Node ceiling(Node node, Key key){

        if(node == null) return null;

        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        if(cmp> 0) return ceiling(node.right, key);
        Node t = ceiling(node.left, key);
        if(t != null) return t;
        else return node;
    }

    public Key select(int i){
        if(root == null) throw new RuntimeException("root is null.");

        if(i < 0 || i >= size(root)) throw new IllegalArgumentException("i is not in range");
        Node t = select(root, i);

        return t.key;

    }

    private Node select(Node node, int i)
    {
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

    public void deleteMin(){
        if(root == null) throw  new RuntimeException("root is null.");
        root = deleteMin(root);

    }

    private Node deleteMin(Node node){
        if(node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) +1;
        return node;

    }

    public void deleteMax(){
        if(root == null) throw new RuntimeException("root is null.");
        root = deleteMax(root);
    }

    private Node deleteMax(Node node){
        if(node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.size = size(node.left)+ size(node.right)+1;
        return node;
    }

    public void delete(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");
        if(root == null) throw new RuntimeException("root is null.");

        root = delete(root, key);
    }

    private Node delete(Node node, Key key){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp > 0)
        {
            node.right = delete(node.right, key);
        }
        else if(cmp < 0){
            node.left = delete(node.left, key);
        }
        else{
            if(node.right == null) return node.left;
            if(node.left == null) return node.right;

            Node t = node;
            node = min(t.right);
            node.right= deleteMin(t.right);
            node.left= t.left;
        }
        node.size = size(node.right)+size(node.left)+1;

        return node;
    }

    public int rank(Key key){
        if(key == null) throw new IllegalArgumentException("key is null.");
        if(root == null) throw new RuntimeException("root is null.");

        return rank(root, key);
    }

    private int rank(Node node, Key key) {

        if(node == null) return 0;
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            return rank(node.left, key);
        }
        else if(cmp>0){
            return 1+ size(node.left) + rank(node.right, key);
        }
        else{
            return size(node.left);
        }

    }

    public Iterable<Key> keys(){
        if(isEmpty()) return new Queue<Key>();
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi){
        if(lo == null) throw new IllegalArgumentException("lo in keys() is null.");
        if(hi == null) throw new IllegalArgumentException("hi in keys() is null.");
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;

    }

    private void keys(Node node, Queue<Key> queue, Key lo, Key hi){
        if(node == null) return ;
        int loCmp = lo.compareTo(node.key);
        int hiCmp = hi.compareTo(node.key);
        if(loCmp < 0 ){
            keys(node.left, queue, lo, hi);
        }
        if(hiCmp > 0 ){
            keys(node.right, queue, lo, hi);
        }
        if(loCmp <= 0 && hiCmp>=0){
             queue.enqueue(node.key);
        }
    }

    public boolean isBinaryTree(){
        return isBinaryTree(root);
    }

    public boolean isBinaryTree(Node node){

        if(node == null) return true;
        if(isBinaryTree(node.left) == false) return false;
        if(isBinaryTree(node.right) == false) return false;
        return node.size == size2(node);
    }

    public boolean isOrdered(){
        Key min = min(root).key;
        Key max = max(root).key;

        return isOrdered(root,min, max);
    }

    private boolean isOrdered(Node node, Key min, Key max){
        if(node == null) return true;

        if(isOrdered(node.left, min, max) == false) return false;
        if(min.compareTo(node.key)>0 || max.compareTo(node.key)<0) return false;

        if(isOrdered(node.right, min, max) == false) return false;
        return true;
    }

    public boolean hasNoDuplicate(){
        return hasNoDuplicate(root);
    }

    private boolean hasNoDuplicate(Node node){
        if(node == null) return true;
        if(get(node.left, node.key) != null) return false;
        if(get(node.right, node.key) != null) return false;
        if(hasNoDuplicate(node.left) == false) return false;

        if(hasNoDuplicate(node.right)== false) return false;
        return true;
    }
    private int size2(Node node){
        if(node == null) return 0;
        return size2(node.right)+ size2(node.left)+1;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contain(Key key)
    {
        Value n = get(key);
        return n!= null;
    }

    public int height(){

        return height(root);
    }

    public int height(Node node){
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) +1;
    }

    public void show()
    {
        show(root);
    }

    private void show(Node node)
    {
        if (node == null) return;
        show(node.left);
        StdOut.print(node.key+ ", ");
        show(node.right);
    }


    public void levelShowKey(){
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        queue.enqueue(null);
        boolean swt = true;
        while(!queue.isEmpty()){


            Node item = queue.dequeue();
            if(item == null){
                StdOut.println();
                swt =true;
                if(!queue.isEmpty())
                    queue.enqueue(null);
            }
            else{

                int maxHeight = height(item)+1;
                double lc = Math.pow(2.0,(double)maxHeight);
                //if(swt){

                for (int i = 0; i < lc/2; i++) {
                    StdOut.print(" ");
                }
                StdOut.print(item.key.toString());
                for (int i = 0; i < lc/2; i++) {
                    StdOut.print(" ");
                }
                swt=!swt;
                //}
//                else{
//
//                    StdOut.print(item.key.toString()+ ", ");
//
//                    for (int i = 0; i <  lc/2; i++) {
//                        StdOut.print(" ");
//                    }
//
//                    swt=!swt;
//                }

                if(item.left != null) queue.enqueue(item.left);
                if(item.right != null) queue.enqueue(item.right);
            }

        }
    }





}
