package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;

public class Ex24_LinkedListPQ <key extends Comparable<key>>{

    // 链表的节点
    private class Node {
        public Node(key it)
        {
            item = it;
        }
        key item;
        Node first;
        Node second;
        Node parent;
    }

    private  Node root = null;


    public void insert(key val)
    {
        Node newNode = new Node(val);
        if(isEmpty()){
            root = newNode;
            return;
        }

        sink(newNode);
    }

    public key top()
    {
        return null;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    private void sink(Node node)
    {
        Node tmpNode = root;
        while(tmpNode != null)
        {
            if(less(tmpNode.item, node.item))
            {
                key tmp = node.item;
                node.item = tmpNode.item;
                tmpNode.item = tmp;
            }

            node.parent = tmpNode;

            if( tmpNode.second != null && less(tmpNode.first.item, tmpNode.second.item) )
            {
                tmpNode = tmpNode.second;
            }
            else if(tmpNode.first != null){
                tmpNode.second = node;
                tmpNode = tmpNode.first;
            }
            else {
                tmpNode.first = node;
                tmpNode  = null;
            }


        }
    }

    private boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

//    private void exch(Comparable v, Comparable w)
//    {
//        Comparable tmp = v;
//        v. = w;
//        w = v;
//    }

    private void swim()
    {

    }


    public static void main(String[] args) {

        Ex24_LinkedListPQ<Integer> pq = new Ex24_LinkedListPQ<>();


        pq.insert(5);
        pq.insert(45);
        pq.insert(15);
        pq.insert(51);
        pq.insert(25);

        StdOut.println();




    }
}
