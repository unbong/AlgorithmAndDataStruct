package neetcode150.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReorderList_143Test {

    @Test
    void reorderList() {
        ListNode node6 = new ListNode(6,null);
        ListNode node5 = new ListNode(5,node6);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ReorderList_143 r = new ReorderList_143();
        r.reorderList(node1);

        while (node1!= null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}