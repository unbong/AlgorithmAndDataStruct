package chapter3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class RedBlackTree <Key extends Comparable<Key>, Value>{

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private class Node{
        private Key key;
        private Value value;
        private Node left, right;
        private int size;
        private boolean color;

        public Node(Key key, Value value, int size, boolean color)
        {
            this.key = key;
            this.value = value;
            this.size = size;
            this.color = color;
        }
    }


    public boolean isRed(Node node)
    {
        if(node == null) return BLACK;
        return node.color == RED;
    }

    /**
     *
     * @param key
     * @param value
     */
    public void put(Key key , Value value){
        if(key == null) throw new IllegalArgumentException("key argument of put is null.");
        if(value == null) { delete( key); return;}

        root = put(root, key, value);
        root.color = BLACK;
    }

    /**
     * 插入新键
     * @param node
     * @param key
     * @param value
     * @return
     */
    private Node put(Node node, Key key, Value value){
        if(node == null) return new Node(key, value, 1, RED);

        int cmp = key.compareTo(node.key);
        if(cmp > 0)
            node.right = put(node.right,key, value);
        else if(cmp < 0)
            node.left = put(node.left, key, value);
        else
            node.value = value;

        if(!isRed(node.left) && isRed(node.right)) node =  rotateLeft(node);
        if(isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if(isRed(node.left) && isRed(node.right))  node = flipColor(node);
        node.size = size(node.left)+ size(node.right)+1;
        return node;
    }


    /**
     * 删除key 结点
     * @param key
     */
    public void delete(Key key){

    }

    /**
     * 取得键对应的值
     * @param key
     *
     * @return
     */
    public Value get(Key key){
        if(key == null) throw new IllegalArgumentException("key argument of get is null.");
        return get(root, key).value;
    }

    /**
     * 取得键对应值的递归方法
     * @param node
     * @param key
     * @return
     */
    private Node get(Node node, Key key){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp > 0) return get(node.right,key);
        else if(cmp < 0) return get(node.left, key);
        return node;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    /**
     * 获取索引i的键 索引值须在树的大小之内。
     * @param i 索引值
     * @return
     */
    public Key select(int i){
        if(i<0 || i >= size(root)) throw new IllegalArgumentException("i is not in range");
        return select(root , i).key;
    }

    private Node select(Node node, int i){
        if(node == null) return null;
        if(i>size(node.left)) return select(node.right, i-size(node.left)-1);
        else if(i<size(node.left)) return select(node.left, i);
        else return node;
    }


    public int rank(Key key){
        if(key == null) throw new IllegalArgumentException("key argument of rank is null.");

        return rank(root, key);
    }

    private int rank(Node node, Key key){
        if(node == null) return 0;
        int cmp = key.compareTo(node.key);
        if(cmp > 0) return rank(node.right, key) + size(node.left)+1;
        else if(cmp < 0) return rank(node.left, key);
        else {
            return size(node.left);
        }
    }

    public Key min(){
        return min(root).key;
    }

    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);
    }

    public Key max(){
        return max(root).key;
    }

    private Node max(Node node){
        if(node.right == null) return node;
        return max(node.right);
    }

    public void deleteMax(){
        delete(max());
    }

    public void deleteMin(){
        delete(min());
    }


    public Key floor(Key key){
        if(key == null) throw new IllegalArgumentException("key argument of floor is null.");
        return floor(root, key).key;
    }

    private Node floor(Node node, Key key){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        if(cmp > 0 ) return floor(node.right, key);
        Node t = floor(node.left, key);
        if(t == null) return node;
        else return t;
    }

    public Key ceiling(Key key){
        if(key == null) throw new IllegalArgumentException("key argument of ceiling is null.");
        return ceiling(root, key).key;
    }

    private Node ceiling(Node node, Key key){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        if(cmp < 0) return ceiling(node.left, key);
        Node t = ceiling(node.right, key);
        if(t == null) return node;
        else return t;
    }


    /**
     * 左旋转
     *      10 <- node
     *    5   19  <- x
     *      12
     * @param node
     * @return
     */
    private Node rotateLeft(Node node){
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        x.size = node.size;
        node.size = size(node.left)+size(node.right)+1;
        return x;
    }

    /**
     * 右旋转
     *     10  <-node
     *   5     <- x
     *  3 4
     * @param node
     * @return
     */
    private Node rotateRight(Node node){
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        x.size = node.size;
        node.size = size(node.left) + size(node.right)+1;
        return x;
    }

    /**
     * 转换颜色
     * @param node
     * @return
     */
    private Node flipColor(Node node){
        node.right.color = BLACK;
        node.left.color = BLACK;
        node.color = RED;
        return node;
    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if(node == null) return 0;
        return node.size;
    }

    public int height()
    {
        return height(root);
    }

    private int height(Node node)
    {
        if (node == null) return -1;
        return Math.max(height(node.left), height(node.right)) +1;
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
                    if(item.color)
                        StdOut.print(item.key.toString()+"_R");
                    else
                        StdOut.print(item.key.toString());

                    for (int i = 0; i < lc/4; i++) {
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
