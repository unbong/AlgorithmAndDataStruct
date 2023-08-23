package neetcode150.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedLists_23Test {

    @Test
    void mergeKLists() {

        ListNode node8 = new ListNode(6,null);
        ListNode node7 = new ListNode(2,node8);

        ListNode node6 = new ListNode(4,null);
        ListNode node5 = new ListNode(3,node6);
        ListNode node4 = new ListNode(1,node5);

        ListNode node3 = new ListNode(5,null);
        ListNode node2 = new ListNode(4, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode[] lists = {node1, node4, node7};

        MergeKSortedLists_23 m = new MergeKSortedLists_23();
        ListNode s = m.mergeKLists(lists);

        while(s!= null){
            System.out.println(s.val);
            s= s.next;
        }


        ListNode[] nl = new ListNode[1];

        s = m.mergeKLists(nl);

        ListNode n1 = new ListNode();
        nl[0] = n1;
        s = m.mergeKLists(nl);

    }
}