package neetcode150.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNode_19Test {

    @Test
    void removeNthFromEnd() {

        ListNode node6 = new ListNode(6,null);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        RemoveNthNode_19 r = new RemoveNthNode_19();
        ListNode s =r.removeNthFromEnd(node6,1);


    }
}