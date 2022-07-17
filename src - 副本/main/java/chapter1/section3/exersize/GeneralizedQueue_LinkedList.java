package chapter1.section3.exersize;

import java.util.Arrays;

/**
 * 链表实现  1.3.38
 * @param <T>
 */
public class GeneralizedQueue_LinkedList<T>{


    private class Node
    {
        T item;
        Node next;
    }
    private int size =0;

    private Node first;
    private  Node last;


    public GeneralizedQueue_LinkedList(int capacity)
    {

    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void insert(T val)
    {
        Node oldLast = last;
        last = new Node();
        last.item = val;
        last.next = null;
        if(isEmpty()) first = last;
        else  oldLast.next = last;
        size++;
    }

    public T delete(int k)
    {

        Node current = first;
        Node delNode = null;
        if(k>size)
        {
            throw new IllegalArgumentException("k: " +k + "  > size: " + size);
        }
        // 找到删除节点前一个
        for (int i = 1; i < k; i++) {
            current = current.next;
        }

        delNode = current.next;
        current.next = delNode.next;
        size--;
        return delNode.item;
    }


    @Override
    public String toString() {

        String ss ="";
        Node current = first;
        while(current != null)
        {
            ss = ss+ " " + current.item.toString();
            current = current.next;
        }

        return "GeneralizedQueue_LinkedList{" +
                "size=" + size +
                ", datas =" + ss +
                '}';
    }

    public static void main(String[] args) {
        GeneralizedQueue_LinkedList<Integer> gs = new GeneralizedQueue_LinkedList<>(20);
        for (int i = 0; i < 20; i++) {
            gs.insert(i);
        }

        gs.delete(3);

        System.out.println(gs.toString());
    }

}
