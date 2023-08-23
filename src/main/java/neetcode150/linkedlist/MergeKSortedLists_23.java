package neetcode150.linkedlist;

public class MergeKSortedLists_23 {


    /**
     * 使用自底向上的方法一对，一对的进行合并
     *  合并次数为每一级的数组的长度除以2的值，如果是奇数则再加一
     *  总的级别级别次数是以2为底的原始数组的长度的对数，并且如果不取整则加1
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length ==0) return null;
        double loopTurn = Math.ceil(Math.log(lists.length)/Math.log(2));
        ListNode [] origin = lists;
        for (double i = 0.0; i <loopTurn; i++) {
            int listsLen = origin.length;
            int mergedArraySize = listsLen/2 + listsLen%2;
            ListNode[] mergedArray = new ListNode[mergedArraySize];
            for (int j = 0; j < mergedArraySize; j++) {
                ListNode mergedList;
                if(2*j+1 == origin.length)
                {
                    mergedList = origin[2*j];
                }else{
                    mergedList  = merge(origin[2*j], origin[2*j+1]);
                }

                mergedArray[j] = mergedList;
            }

            origin = mergedArray;

        }
        if(origin[0] == null ) return null;
        return origin[0];
    }

    private ListNode merge(ListNode list1, ListNode list2) {

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
