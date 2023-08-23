package neetcode150.linkedlist;

public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode res;
        ListNode root = null;
        ListNode prev = null;
        boolean isFirst=true;
        int left ;
        int right;
        while(list1 != null || list2 != null)
        {
            res = new ListNode();
            if(isFirst){
                root = res;
                isFirst = false;
            }
            else{
                prev.next = res;
            }
            if(list1 == null){
                left = Integer.MAX_VALUE;
            }
            else
                left = list1.val;

            if(list2 == null)
                right = Integer.MAX_VALUE;
            else
                right = list2.val;

            if(left > right)
            {
                res.val = right;
                list2 = list2.next;
            }
            else{
                res.val = left;
                list1 = list1.next;
            }
            prev = res;
        }
        return root;
    }
}
