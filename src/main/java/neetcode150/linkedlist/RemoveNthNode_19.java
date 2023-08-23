package neetcode150.linkedlist;

import java.rmi.UnexpectedException;

public class RemoveNthNode_19 {

    ListNode root ;
    private int removeNthNodeFromEnd(ListNode prev, ListNode current, int n){
        if(current == null){
            return 0;
        }

        int count = removeNthNodeFromEnd(current, current.next, n);
        count++;
        if(count == n){
            if(prev != null)
                prev.next = current.next;
            else
                root = current.next;
        }
        return count;
    }

    /**
     * 用递归的形式去找到，要删除的节点。
     *  当到了最后的节点是，递归方法返回0
     *   取得递归方法的返回值后，返回值加1
     *   判断是否与要删除的节点相同 如果相同则删除，
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        root = head;
        removeNthNodeFromEnd(null, head,n);
        return root;
    }
}
