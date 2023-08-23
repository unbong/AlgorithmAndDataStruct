package neetcode150.linkedlist;

public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {

        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        if(fast != null) fast= fast.next;
        while(slow!=null && fast != null)
        {
            if(slow.val == fast.val) return true;
            slow = slow.next;
            fast = fast.next;
            if(fast != null) fast= fast.next;
            else return false;

        }
        return false;
    }
}
