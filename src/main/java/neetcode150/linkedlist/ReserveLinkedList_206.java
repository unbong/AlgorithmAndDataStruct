package neetcode150.linkedlist;

public class ReserveLinkedList_206 {


    ListNode root;

    private void reverseList(ListNode prev, ListNode current){
        if(current.next == null){
            this.root = current;
            current.next = prev;
            return;
        }

        reverseList(current, current.next);
        current.next = prev;
    }

    /**
     * 用递归方法中将当前节点的下一个节点更新为前一个节点。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null ) return null  ;
        this.root = head;
        reverseList(null, head);
        return this.root;
    }
}
