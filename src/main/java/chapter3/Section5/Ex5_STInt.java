package chapter3.Section5;

import chapter3.RedBlackTree;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex5_STInt<Value> {

    private final static boolean RED = true;
    private final static boolean BLACK = false;
    private class Node{
        int key;
        Value value;
        Node left, right;
        int size;
        boolean color;


        public Node(int key,Value val, int size, boolean color){
            this.key = key;
            this.value = val;
            this.size = size;
            this.color = color;
        }
    }

    private Node root;

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if(node == null) return 0;
        return size(node.left) + size(node.right)+1;
    }

    public boolean isEmpty()
    {
        return root == null;
    }


    public void put(int key , Value value){
        if(value == null) delete(key);
        root = put(root, key, value);
        root.size = size(root.left)+size(root.right)+1;
        if(!isEmpty()) root.color = BLACK;
    }

    private Node put(Node node, int key, Value value){
        if(node == null) return new Node(key, value , 1,RED);

        if(key > node.key) node.right = put(node.right, key , value);
        else if(key < node.key) node.left = put(node.left, key, value);
        else {
            node.value = value;
        }

        node = balance(node);
        node.size = size(node.left)+size(node.right)+1;
        return node;
    }

    private Node balance(Node node){

        if(!isRed(node.left) && isRed(node.right)) node = rotateLeft(node);
        if(isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if(isRed(node.left) && isRed(node.right)) node = flipColors(node);
        return node;
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.color = node.color;
        x.right = node;
        x.size = node.size;
        node.color = RED;
        node.size = size(node.left) + size(node.right)+1;
        return x;

    }

    private Node rotateLeft(Node node) {

        Node x = node.right;
        node.right = x.left;
        x.color = node.color;
        x.left = node;
        x.size = node.size;
        node.color = RED;
        node.size = size(node.right)+size(node.left)+1;
        return x;
    }

    private boolean isRed(Node node){
        if(node == null) return false;
        return node.color == RED;
    }
    private Node flipColors(Node node){
        node.color = !node.color;
        node.left.color = !node.left.color;
        node.right.color = !node.right.color;
        return node;
    }

    public void delete(int key)
    {
        //todo delete
    }

    public Value get(int key)
    {
        return get(root, key).value;
    }

    private Node get(Node node, int key){
        if(node == null) return null;

        if(key > node.key) return get(node.right, key );
        else if(key < node.key) return get(node.left, key);
        else return node;
    }

    public void levelShow(){


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

                int maxHeight = size(item);
                double lc = Math.log(maxHeight) / Math.log(2);
                //if(swt){

                for (int i = 0; i < lc/2; i++) {
                    StdOut.print(" ");
                }
                if(item.color)
                    StdOut.print(item.key + "_R");
                else
                    StdOut.print(item.key);

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

    public static void main(String[] args) {

        Ex5_STInt<Integer> st = new Ex5_STInt<>();
        int[] arr = new int[19];
        for (int i = 0; i < 19; i++) {
            arr[i] = i;
        }

        StdRandom.shuffle(arr);

        for (int i = 0; i < 19; i++) {
            st.put(arr[i], arr[i]);
        }

        st.levelShow();
    }
}
