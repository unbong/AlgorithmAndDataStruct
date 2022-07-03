package chapter1.section3.exersize;

import java.util.Calendar;

public class MoveToFront_1_3_40<T> {
    private class Node{
        T item;
        Node next;
    }

    private int size = 0;

    private Node first;

    public void add(T val)
    {
        Node current = first;
        Node prev = current;
        while(current != null)
        {
            if(current.item.equals(val))
            {
                if(current == first)
                {
                    first = current.next;
                }
                else {
                    prev.next = current.next;
                }
                size--;
                break;
            }

            prev = current;
            current = current.next;
        }

        Node oldFirst = first;
        first = new Node();
        first.item = val;
        first.next = oldFirst;
        size++;
    }

    public static void main(String[] args) {


        MoveToFront_1_3_40<Character> m = new MoveToFront_1_3_40<>();
        String ss = "AAAABBBCCCDAA";

        for (int i = 0; i < ss.length(); i++) {
            char cc = ss.charAt(i);
            m.add(Character.valueOf(cc));
        }

        System.out.println("ss");

    }
}
