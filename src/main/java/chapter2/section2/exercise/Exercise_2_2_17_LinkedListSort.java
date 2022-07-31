package chapter2.section2.exercise;

import chapter1.section3.Queue;
import edu.princeton.cs.algs4.StdOut;
import org.jetbrains.annotations.NotNull;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;


/**
 * 链表的自然归并排序，实现链表的最快排序 线性对数级别，且不需要额外空间
 * @param <Item>
 */
public class Exercise_2_2_17_LinkedListSort<Item> implements Iterable<Item> {

    @NotNull
    @Override
    public Iterator<Item> iterator() {

        return new ListIterator();
    }

    private class   ListIterator implements Iterator<Item>
    {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item res =  current.val;
            current = current.next;
            return res;
        }
    }

    class Node {
        public Item val;
        public Node next;
        public Node prev;
    }



    private int size;
    private Node first;


    public boolean isEmpty()
    {
        return size==0;
    }

    public int getSize()
    { return size;}

    public  void add(Item value)
    {

        Node newNode = new Node();
        newNode.val = value;
        newNode.next = first;

        first = newNode;
        size++;
    }

    public void remove()
    {
        if(isEmpty()) throw  new RuntimeException("empty");

        first = first.next;

        size--;
    }

    public Item get(int index)
    {
        Node tmp = first;
        if(index > size-1 ) throw new IllegalArgumentException("index > size.");
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.val;
    }


    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }

    public static void sort(Exercise_2_2_17_LinkedListSort<Comparable>.Node source)
    {
        Exercise_2_2_17_LinkedListSort<Comparable>.Node lo;
        Exercise_2_2_17_LinkedListSort<Comparable>.Node mi;
        Exercise_2_2_17_LinkedListSort<Comparable>.Node hi;
        Exercise_2_2_17_LinkedListSort<Comparable>.Node curent ;
        curent = source;
        lo = source;

        while (true)
        {
            boolean isBreak = false;
            mi = lo;

            while (curent != null &&curent.next != null)
            {
                if( !less(curent.val, curent.next.val))
                {
                    mi = curent;
                    break;
                }
                curent = curent.next;

            }

            hi = mi;
            curent = mi.next;
            while( curent != null&& curent.next != null)
            {
                if( !less(curent.val, curent.next.val))
                {
                    hi = curent;
                    break;
                }
                curent = curent.next;
            }


            merge(lo, mi, hi);

            if(lo == source && hi.next == null)
            {
                break;
            }

        }


    }

    public static void merge(Exercise_2_2_17_LinkedListSort.Node lo, Exercise_2_2_17_LinkedListSort.Node mi,
                             Exercise_2_2_17_LinkedListSort.Node hi)
    {

    }



    public static void main(String[] args) {

        Exercise_2_2_17_LinkedListSort<Integer> list = new Exercise_2_2_17_LinkedListSort<>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
        }

        for(Integer it : list)
        {
            StdOut.print(it.toString()+" ");
        }
        StdOut.println("");

    }

}
