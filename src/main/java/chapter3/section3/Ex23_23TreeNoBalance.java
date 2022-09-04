package chapter3.section3;

import chapter3.BinarySearchTree;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

public class Ex23_23TreeNoBalance <Key extends Comparable<Key>, Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private class Node{
        Key key;
        Value value;
        Node left, right;
        int size;
        int height;
        boolean color;

        public Node(Key key, Value value, int size, int height, boolean color)
        {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
            this.color = color;
        }

    }

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if(node == null ) return 0;
        return node.size;
    }

    public int height(){
        return height(root);
    }

    private int height(Node node){
        if(node == null) return -1;
        return node.height;
    }

    public void put(Key key, Value value){
        if(key == null) throw new IllegalArgumentException("key argument of put is null.");
        if(value == null) { delete( key); return;}

        root = put(root, key, value, null);
        root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value, Node parent){
        if(node == null) {
            if (parent != null )
            {
                if(isRed(parent)  )
                    return new Node(key, value, 1, 0, BLACK);
                if(parent.left != null && isRed(parent.left))
                    return new Node(key, value, 1, 0, BLACK);
                if(parent.right != null && isRed(parent.right))
                    return new Node(key, value, 1, 0, BLACK);
            }
            return new Node(key, value, 1, 0, RED);

        }

        int cmp = key.compareTo(node.key);
        if(cmp > 0)
            node.right = put(node.right,key, value, node);
        else if(cmp < 0)
            node.left = put(node.left,key, value, node);
        else
            node.value = value;

        node.size = size(node.left)+size(node.right)+1;
        node.height = height(node.left)+height(node.right)+1;

        return node;
    }


//    private void flipColor(Node node){
//
//    }



    public void delete(Key key){
        return ;
    }


    private boolean isRed(Node node){
        if(node == null) return BLACK;
        return node.color == RED;
    }


    public double getAVGPathLength(){

        int height = height();
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        queue.enqueue(null);
        int sumPL = 0;
        int levelP =0;
        while(queue.isEmpty() == false){
            Node node = queue.dequeue();
            if(node ==null){
                if(queue.isEmpty() == false) {
                    queue.enqueue(null);

                }
                levelP++;
                continue;
            }

            sumPL += levelP;
            if(node.left != null ) queue.enqueue(node.left);
            if(node.right != null )    queue.enqueue(node.right);
        }

        return (double)sumPL / (double)size();

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


    public static void main(String[] args) {



        int N = 100;
        for (int i = 0; i < 6; i++) {
            Ex23_23TreeNoBalance<Integer, Integer> rbt = new Ex23_23TreeNoBalance<>();
            Integer a[] = IntRandom.getIntRandom(N);
            for (int j = 0; j < a.length; j++) {
                rbt.put(a[j],a[j]);
            }
            StdOut.println( rbt.getAVGPathLength());

            N = N*10;
        }

    }
}
