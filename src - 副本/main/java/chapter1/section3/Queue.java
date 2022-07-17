package chapter1.section3;

import java.util.Iterator;

public class Queue <T> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class Node {
        T item;
        Node next;
    }


    public Queue()
    {

    }

    public Queue(Queue<T> q)
    {
        for (T item :
                q) {
            enqueue(item);
        }
    }
    private Node first;
    private Node last;
    private int size=0;

    public T dequeue()
    {
        Node oldFirst = first;
        first = first.next;
        size--;
        if(isEmpty()) first = last;
        return oldFirst.item;
    }

    public void enqueue(T val)
    {

        Node tmp = last;
        last = new Node();
        last.next = null;
        last.item = val;
        if(isEmpty()) first = last;
        else tmp.next = last;
        size ++;

    }

    public int getSize(){return size;}

    public boolean isEmpty(){return size == 0;}


    private class QueueIterator implements Iterator<T> {

        private Node current = first;
        // todo
        @Override
        public boolean hasNext() {
            return current != null;
        }

        // todo
        @Override
        public T next() {
            T res = current.item;
            current = current.next;
            return res;
        }
    }
}
