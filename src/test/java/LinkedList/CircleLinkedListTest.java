package LinkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleLinkedListTest {

    @Test
    void testIsCircle() {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        list.addNode(1,1);
        list.addNode(2,2);
        list.addNode(3,3);
        list.addNode(4,4);

        boolean exp = list.testIsCircle();
        Assertions.assertEquals(true, exp);

    }

    @Test
    void isCircle3_6() {

        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        list.addNode(1,1);
        list.addNode(2,2);
        list.addNode(3,3);
        list.addNode(4,4);

        boolean exp = list.isCircle3_6();
        Assertions.assertEquals(true, exp);
    }

    @Test
    void isCircle3_9() {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        list.addNode(1,1);
        list.addNode(2,2);
        list.addNode(3,3);
        list.addNode(4,4);

        boolean exp = list.isCircle3_9();
        Assertions.assertEquals(true, exp);
    }

    @Test
    void getLastSurviveNode() {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        list.addNode(1,1);
        list.addNode(2,2);
        list.addNode(3,3);
        list.addNode(4,4);

        ListNode<Integer> exp = list.getLastSurviveNode(2);
        Assertions.assertEquals(exp.getValue(), 1);

    }
}