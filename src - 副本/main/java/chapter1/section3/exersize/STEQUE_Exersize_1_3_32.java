package chapter1.section3.exersize;

/**
 * Steque
 */
public class STEQUE_Exersize_1_3_32<T> {

    private class Node{
        T item;
        Node next;
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public boolean isEmpty()
    {
        return size == 0;
    }
    public void push(T val)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = val;
        first.next = oldFirst;
        if(isEmpty()) { last = first;}
        size++;
    }

    public T pop()
    {
        Node res = first;
        first = first.next;
        size --;
        return res.item;
    }

    public void enqueue(T val)
    {
        Node oldLast = last;
        last = new Node();
        last.item=val;
        last.next = null;

        if(isEmpty()) { first = last;}
        else { oldLast.next = last;}
        size++;
    }
}
