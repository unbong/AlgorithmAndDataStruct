package neetcode150.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReserveLinkedList_206Test {

    @Test
    void reverseList() {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ReserveLinkedList_206 r = new ReserveLinkedList_206();

        ListNode s = r.reverseList(node1);

        while(s.next != null){
            System.out.println(s.val);
        }

    }
}