package stack;

import LinkedList.ListNode;
import LinkedList.SingleLinkedList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListStackTest {

    @Test
    void reverStack() {

        ListStack<Integer> listStack = new ListStack<>();
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        listStack.push(4);
        listStack.reverStack();


        System.out.println("");
    }

    @Test
    void findCircleStart(){


        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        SingleLinkedList<Integer> list2 = new SingleLinkedList<>();

        list2.addFirst(11);
        list2.addLast(12);
        list2.addLast(13);
        list2.addLast(14);
        list2.addLast(15);

        list2.first.getNext().setNext(list.first.getNext().getNext());

        ListNode<Integer> firstCursor = list.first;
        ListNode<Integer> secondCursor = list2.first;

        ListStack<ListNode<Integer>> firstStack = new ListStack<>();
        ListStack<ListNode<Integer>> secondStack = new ListStack<>();

        while( firstCursor!= null && secondCursor != null)
        {

            firstStack.push(firstCursor);
            secondStack.push(secondCursor);

            if(firstCursor != null)
            {
                firstCursor = firstCursor.getNext();
            }
            if(secondCursor != null)
            {
                secondCursor = secondCursor.getNext();
            }
        }

        ListNode<Integer> sameNode = null;
        firstCursor = null;
        secondCursor = null;
        while(firstCursor == secondCursor)
        {
            sameNode = firstCursor;
            firstCursor = firstStack.pop();
            secondCursor = secondStack.pop();
        }

        if( sameNode != null )
        {
            System.out.println(sameNode.getValue());
        }

    }

    @Test
    void getSpan() {

        ListStack<Integer> stack = new ListStack<>();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(6);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(2);

        ArrayList<Integer> span = stack.getSpan(input);

        System.out.println(span.toString());

    }
}