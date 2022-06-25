package chapter1.section3;

import java.util.Iterator;

public class Stack <T> implements Iterable<T>{

    private class Node{
        T item ;
        Node next;
    }

    private int size = 0;
    private Node first = null;

    public T pop()
    {
        if(isEmpty())
        {
            throw new UnsupportedOperationException("stack is empty");
        }
        T res = first.item;
        first = first.next;
        size--;
        return res;
    }

    public T peek()
    {
        if(isEmpty())
        {
            throw new UnsupportedOperationException("stack is empty");
        }
        return first.item;
    }

    public void push(T val)
    {
        Node oldFirst = first;
        first = new Node();
        first.item = val;
        first.next = oldFirst;
        size++;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {return size;}


    public Iterator<T> iterator()
    {
        return new StackIteraor<>();
    }

    private class StackIteraor<T>  implements Iterator<T>{

        private Node current = first;
        // todo
        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            Node res = current;
            current = current.next;
            return (T) res.item;
        }
    }
}
