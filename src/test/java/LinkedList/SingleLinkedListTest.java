package LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SingleLinkedListTest {


    @Test
    void getNthNodeFromLast() {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        Integer exp = list.getNthNodeFromLast(2);
        Assertions.assertEquals(exp.intValue(), 3);
    }

    @Test
    void getNthNodeFromLast3_4() {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        Integer exp1 = list.getNthNodeFromLast3_4(1);
        Assertions.assertEquals(exp1.intValue(), 4);

        Integer exp2 = list.getNthNodeFromLast3_4(4);
        Assertions.assertEquals(1,exp2.intValue());

    }

    @Test
    void testIsCircle() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        boolean exp = list.testIsCircle();
        Assertions.assertEquals(false, exp);
    }

    @Test
    void isCircle3_6() {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        boolean exp = list.isCircle3_6();
        Assertions.assertEquals(false, exp);

    }

    @Test
    void isCircle3_9() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        boolean exp = list.isCircle3_6();
        Assertions.assertEquals(false, exp);
    }

    @Test
    void findCircleStart() {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.madeCircleData3_11();

        ListNode<Integer> exp = list.findCircleStart();
        if(exp == null)
        {
            return ;
        }
        Assertions.assertEquals(3, exp.getValue());
    }

    @Test
    void reverseList() {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        list.reverseList();

        System.out.println("");
    }

    @Test
    void getCrossNode() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);


        SingleLinkedList<Integer> crossList = new SingleLinkedList<>();
        crossList.addFirst(10);
        crossList.addLast(11);
        list.madeCrossList(crossList);

        ListNode<Integer> node =  list.getCrossNode(crossList);
        System.out.println("");
        Assertions.assertEquals(3, node.getValue());
    }

    @Test
    void getMiddleNode() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        ListNode<Integer> node = list.getMiddleNode();
        Assertions.assertEquals(4, node.getValue());


        SingleLinkedList<Integer> list2 = new SingleLinkedList<>();
        list2.addFirst(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(7);

        ListNode<Integer> node2 = list2.getMiddleNode();

        Assertions.assertEquals(4, node2.getValue());
    }

    @Test
    void reverseData() {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

         list.reverseData();
        //Assertions.assertEquals(4, node.getValue());


        SingleLinkedList<Integer> list2 = new SingleLinkedList<>();
        list2.addFirst(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);
        list2.addLast(5);
        list2.addLast(6);
        list2.addLast(7);

         list2.reverseData();

        //Assertions.assertEquals(4, node2.getValue());
        System.out.println("");
    }
}