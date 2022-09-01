package chapter3.section2;

import edu.princeton.cs.algs4.StdOut;

/**
 *   为二叉树实现非递归版的put与get方法
 *
 *  14 实现非递归 min max floor ceiling rank select
 */
public class Ex13_BST_NoRecursive<Key extends Comparable<Key>, Value> {

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

    public void put(Key key, Value value){
        if(key == null) throw new IllegalArgumentException("key argument of put is null.");
        if(value == null ) delete(key);

        if(this.root == null) {
            this.root = new  Node(key, value, 1);
            return;
        }

        Node node = this.root;
        boolean isAdded = true;
        while(node != null){

            int cmp = key.compareTo(node.key);
            if(cmp > 0){
                if(node.right == null){
                    node.right = new Node(key, value, 1);
                    break;
                }
                node = node.right;

            }
            else if(cmp < 0){
                if(node.left == null){
                    node.left = new Node(key, value, 1);
                    break;
                }
                node = node.left;

            }
            else{
                node.value = value;
                isAdded = false;
                break;
            }
        }

        Node tmp = this.root;
        while(tmp != null && isAdded)
        {
            int cmp = key.compareTo(tmp.key);
            if(cmp >0 ){
                tmp.size++;
                tmp = tmp.right;
            }
            else if(cmp< 0){
                tmp.size++;
                tmp = tmp.left;
            }
            else{
                break;
            }
        }
        //this.root.size = size(this.root.left)+ size(this.root.left)+1;

    }


    public Value get(Key key)
    {
        if(key == null) throw new IllegalArgumentException("key is null");
        if(root == null ) throw new RuntimeException("root is null.");

        Node node = this.root;
        int cmp ;
        while(node != null){
            cmp = key.compareTo(node.key);
            if(cmp > 0)
                node = node.right;
            else if(cmp < 0)
                node = node.left;
            else break;
        }
        if(node == null) return null;
        return node.value;
    }

    public int size(Node node){
        if(node == null) return 0;
        return node.size;
    }

    public Key min(){
        if(this.root == null) throw new IllegalStateException("root is null.");
        Node node = this.root;
        while(node.left != null)
        {
            node = node.left;
        }

        return node.key;
    }

    public Key max(){
        if(this.root == null) throw new IllegalStateException("root is null.");
        Node node = this.root;
        while(node.right != null)
        {
            node = node.right;
        }

        return node.key;
    }

    public Key floor(Key key){
        if (key == null) throw new IllegalArgumentException("key argument of floor is null.");
        Node prevLessNode = null;
        Node node = this.root;
        int cmp ;
        while(node != null){
            cmp = key.compareTo(node.key);
            if(cmp > 0) {
                prevLessNode = node;
                node = node.right;
            }
            else if(cmp < 0){
                node = node.left;
            }
            else {
                prevLessNode = node;
                break;
            }
        }
        if(prevLessNode== null) return null;
        return prevLessNode.key;
    }

    public Key ceiling(Key key ){
        if (key == null) throw new IllegalArgumentException("key argument of ceiling is null.");
        Node prevGreatNode = null;
        Node node = this.root;
        int cmp ;

        while(node != null){
            cmp = key.compareTo(node.key);
            if(cmp > 0){
                node = node.right;
            }
            else if(cmp < 0){
                prevGreatNode = node;
                node = node.left;
            }
            else {
                prevGreatNode = node;
                break;
            }
        }
        if (prevGreatNode == null) return null;
        return prevGreatNode.key;
    }


    public int rank(Key key){
        if(key == null )  throw new IllegalArgumentException("key argument of rank is null.");
        Node node = this.root;
        int bc = 0;
        int cmp ;
        while(node != null){
            cmp = key.compareTo(node.key);
            if(cmp>0){
                bc += size(node.left)+1;
                node = node.right;
            }
            else if(cmp<0){
                node = node.left;
            }
            else {
                bc += size(node.left);
                break;
            }
        }
//        if(node == null) return 0;
        return bc;
    }

    public Key select(int i){

        if(i<0 || i>=size(this.root)) throw new IllegalArgumentException("i is not in range.");

        Node node = this.root;
        while(node != null){
            if(i>size(node.left) ){
                i = i - size(node.left) -1;
                node = node.right;
            }
            else if(i<size(node.left) ){

                node = node.left;
            }
            else{
                break;
            }
        }

        return node.key;
    }

    public void show(){
        show(root);
    }

    private void show(Node node){
        if(node == null) return ;
        show(node.left);
        StdOut.print(node.key+"," );
        show(node.right);
    }
    public void delete(Key key){

    }
}
