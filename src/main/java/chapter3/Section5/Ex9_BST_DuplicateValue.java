package chapter3.Section5;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 *
 * 将键相同的值放到，键相同结点的右结点当中。
 *  插入 删除 查找都依据上述结构，进行相应的调整。
 * @param <Key>
 * @param <Value>
 */
public class Ex9_BST_DuplicateValue <Key extends Comparable<Key>,Value> {

    private class Node{
        Key key;
        Value value;
        Node left, right;
        int size;

        public Node(Key key, Value value, int size){
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    private Node root;

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if (node == null) return 0;
        return size(node.left) + size(node.right)+1;
    }

    public boolean contains(Key key){
        return get(root, key) != null;
    }

    public boolean isEmpty(){
        return root != null;
    }

    public void put(Key key, Value value){
        if(key == null ) throw new IllegalArgumentException("key is null.");
        if(value == null) delete(key);

        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if(node == null) return new Node(key, value, 1);

        int cmp = key.compareTo(node.key);
        if(cmp >= 0) node.right = put(node.right, key, value);
        else  node.left = put(node.left, key, value);

        node.size = size(node.left)+ size(node.right)+1;
        return node;
    }

    public Value get(Key key)
    {
        if(key==null) throw new IllegalArgumentException("key is null.");
        return get(root, key).value;
    }

    private Node get(Node node, Key key){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp >0) return get(node.right, key);
        else if(cmp <0) return get(node.left, key);
        else return node;
    }

    public void delete(Key key) {
        if(key==null) throw new IllegalArgumentException("key is null.");

        root = delete(root, key);

    }

    public Node delete(Node node, Key key){
        if(node == null) return null;

        int cmp = key.compareTo(node.key);
        if(cmp > 0) node.right = delete(node.right,key);
        else if(cmp < 0) node.left = delete(node.left, key);
        else{

            node.right = delete(node.right, node.key);

            if(node.left == null) return node.right;
            if(node.right == null) return node.left;

            Node x = node;
            node = min(x.right);
            node.right = delete(x.right, node.key);
            node.left = x.left;
        }

        node.size = size(node.left)+size(node.right)+1;

        return node;
    }


    public Value min(){
        return min(root).value;
    }

    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);
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
//                if(item.color)
//                    StdOut.print(item.key + "_R");
//                else
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
}
