package chapter1.section3.exersize;

/**
 * Steque
 */
public class DEQUE_Exersize_1_3_33<T> {

    private class Node{
        T item;
        Node next;
        Node prev;
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void pushLeft(T val)
    {

        Node oldFirst = first;
        first = new Node();
        first.item = val;
        first.next = oldFirst;
        first.prev = null;
        if(isEmpty()) { last = first;}
        else{ oldFirst.prev = first; }
        size++;
    }

    public T popLeft()
    {
        if(isEmpty()) throw new UnsupportedOperationException("queue is empty");
        Node res = first;
        first = first.next;
        if(first!= null) {first.prev = null;}
        size --;
        return res.item;
    }

    public void pushRight(T val)
    {
        Node oldLast = last;
        last = new Node();
        last.item=val;
        last.next = null;
        last.prev = oldLast;
        if(isEmpty()) { first = last;}
        else { oldLast.next = last;}
        size++;
    }

    public T popRight()
    {
        if(isEmpty()) throw new UnsupportedOperationException("queue is empty");

        Node res = last;
        Node prev = last.prev;
        last = prev;
        if(prev != null ){ prev.next = null; }
        size --;
        return res.item;
    }

}
