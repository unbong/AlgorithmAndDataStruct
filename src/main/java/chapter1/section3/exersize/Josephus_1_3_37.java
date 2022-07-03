package chapter1.section3.exersize;

import chapter1.section3.Queue;

import java.util.Iterator;

public class Josephus_1_3_37<T> implements Iterable<T>{


    @Override
    public Iterator<T> iterator() {
        return null;
    }


    private class Node {
        T item;
        Node next;
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
        else{ last.next = first; }
        return oldFirst.item;
    }

    public void enqueue(T val)
    {

        Node tmp = last;
        last = new Node();
        last.next = first;
        last.item = val;
        if(isEmpty()) first = last;
        else tmp.next = last;
        size ++;

    }

    public int getSize(){return size;}

    public boolean isEmpty(){return size == 0;}

    public void kill(int n )
    {
        Node current = first;
        Node prev = current;
        int count = 1;
        while(current != null)
        {
            if(count == n)
            {
                count = 0;
                System.out.println(", "+current.item);
                if(size==1)
                {
                    current = null;
                    continue;
                }else {

                    prev.next = current.next;
                    //prev = current;
                }
                size--;
                //continue;
            }
            prev = current;
            current = current.next;
            count++;
        }
    }

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
            T res = current.next.item;
            current = current.next;
            return res;
        }
    }


    public static void main(String[] args) {
        Josephus_1_3_37<Integer>  que = new Josephus_1_3_37<>();
        for (int i = 0; i < 7; i++) {
            que.enqueue(i);
        }

        que.kill(2);

    }
}
