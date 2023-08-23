package neetcode150.linkedlist;

public class ReorderList_143 {
    int length =0;

    /**
     * 使用递归的方式
     * @param head
     */
    public void reorderList(ListNode head) {

        ListNode node = head;
        while(node!=null) {
            length++;
            node = node.next;
        }
        if(length == 1 || length ==0 || length == 2) return;
        int count = length/2;
        ListNode next = reorder(head, head.next, count, 1);

    }

    private ListNode reorder(ListNode prev, ListNode current, int count, int end){
        if(count == end){

            ListNode next = current.next;
            ListNode res = next.next;
            if(this.length%2 ==0 ) {
                current.next = null;
                return next;
            }
            current.next = null;
            prev.next = next;
            next.next = current;
            return res;
        }

        ListNode next = reorder(current, current.next,count ,end+1);
        ListNode res = next.next;
        //current.next = res;
        prev.next = next;
        next.next = current;

        return res;
    }
}
