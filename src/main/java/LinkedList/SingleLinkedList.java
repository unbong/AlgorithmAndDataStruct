package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleLinkedList<T> {

    public ListNode<T> first = null;
    public ListNode<T> last = null;
    public int length = 0;

    public void addLast(T value)
    {
        if (first == null)
        {
            first = new ListNode<>(value);
            last = first;
        }else
        {
            ListNode<T> newNode = new ListNode<>(value);
            last.setNext(newNode);
            last = newNode;
        }
        length ++;
    }

    public void addFirst(T value)
    {
        if (first == null)
        {
            first = new ListNode<>(value);
        }else
        {
            ListNode<T> newNode = new ListNode<>(value);
            newNode.setNext(first);
            first = newNode;

        }
        last = first;
        length ++;
    }

    public void addNodeAtPosition(T value , int position){

        if(position >= length)
        {
            addLast(value);
        }else if(position <= 1)
        {
            addFirst(value);
        }
        else{
            int count = 1;
            ListNode<T> cursor = first;
            ListNode<T> cursorFront = null;
            while( cursor != null  && count < position  )
            {
                count ++;
                cursorFront  = cursor;
                cursor = cursor.getNext();
            }

            ListNode<T> newNode =  new ListNode(value);
            cursorFront.setNext(newNode);
            newNode.setNext(cursor);

            length ++;
        }

    }

    public void removeAll()
    {
        ListNode<T> cursor = first;
        ListNode<T> tempNode = null;
        while(cursor!= null)
        {
            tempNode = cursor.getNext();
            cursor.setNext(null);
            cursor = tempNode;
        }
        first = null;
        last = null;
        length = 0;
    }

    public void removeNode(int position)
    {
        if(position <= 1)
        {
            first = first.getNext();

        }
        else
        {
            ListNode<T> cursor = first;
            ListNode<T> cursorFront = null;
            int count = 1;

            while(cursor != null && count< position )
            {
                count++;
                cursorFront = cursor;
                cursor = cursor.getNext();
            }
            // last node
            if(position >= length)
            {
                cursorFront.setNext(null);
                last = cursorFront;

            }else
            {
                cursorFront.setNext(cursor.getNext());
                cursor.setNext(null);
            }
        }
        length--;

    }

    public int listLength()
    {
        ListNode<T> cursor = first;
        int count = 0;
        while (cursor != null )
        {
            count++;
            cursor = cursor.getNext();
        }

        return count;
    }

    /**
     * lesson 3-3
     *  利用总长度-n后做循环后获得
     * @param n
     * @return
     */
    public T getNthNodeFromLast(int n)
    {
        int index = length-n+1;
        int count = 1;
        ListNode<T> current = first;

        if(first == null)
        {
            throw new IllegalStateException("list is empty");
        }
        if(n > length)
        {
            throw new IllegalArgumentException(String.format("n大于总长【%d】", length));

        }

        while (current != null && count < index){
            count++;
            current = current.getNext();
        }

        return current.getValue();
    }

    public T getNthNodeFromLast3_4(int n)
    {

        int count = 1;
        ListNode<T> current = first;
        ListNode<T> nThTmp = first;
        if(first == null)
        {
            throw new IllegalStateException("list is empty");
        }
        if(n > length)
        {
            throw new IllegalArgumentException(String.format("n大于总长【%d】", length));
        }

        while(current.getNext() != null )
        {
            if(count>n-1)
            {
                nThTmp = nThTmp.getNext();
            }
            count++;
            current = current.getNext();
        }
        return nThTmp.getValue();
    }


    public boolean testIsCircle()
    {

        if(length == 1)
        {
            return false;
        }

        ListNode<T> oneStepCursor = first;
        ListNode<T> twoStepCursor = first.getNext();

        while(oneStepCursor != twoStepCursor )
        {
            oneStepCursor = oneStepCursor.getNext();

            if(oneStepCursor == null)
            {
                return false;
            }
            int count = 0;
            while(twoStepCursor != null && count < 2)
            {
                count++;
                twoStepCursor = twoStepCursor.getNext();
            }
            if(twoStepCursor == null)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * lesson 3-6
     * @return
     */
    public boolean isCircle3_6()
    {
        Map<ListNode<T>, String> map = new HashMap<>();

        ListNode<T> current = first;
        while(!map.containsKey(current))
        {
            map.put(current, "");
            current = current.getNext();
            if(current == null)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * lesson 3-9
     * @return
     */

    public boolean isCircle3_9()
    {

        if(length == 1)
        {
            return false;
        }

        ListNode<T> oneStepCursor = first;
        ListNode<T> twoStepCursor = first;

        while(oneStepCursor !=null && twoStepCursor != null )
        {
            oneStepCursor = oneStepCursor.getNext();

            if(oneStepCursor == null)
            {
                return false;
            }
            int count = 0;
//            while(twoStepCursor != null && count < 2)
//            {
//                count++;
//                twoStepCursor = twoStepCursor.getNext();
//            }

            if(twoStepCursor != null)
            {
                twoStepCursor = twoStepCursor.getNext();
            }
            if(twoStepCursor != null)
            {
                twoStepCursor = twoStepCursor.getNext();
            }

            if(twoStepCursor == oneStepCursor)
            {
                System.out.println(oneStepCursor.getValue());

                return true;
            }
        }

        return false;
    }

    /**
     * 制造环链
     *
     */
    public void madeCircleData3_11()
    {

        if(length < 3)
        {
            throw new RuntimeException("link length less than 3");
        }
        last.setNext(first.getNext().getNext());

    }

    public ListNode<T> findCircleStart()
    {
        boolean isCircle = false;
        ListNode<T> oneStepCursor = first;
        ListNode<T> twoStepCursor = first;

        while(oneStepCursor !=null && twoStepCursor != null )
        {
            oneStepCursor = oneStepCursor.getNext();

            if(oneStepCursor == null)
            {
                break;
            }
            int count = 0;
//            while(twoStepCursor != null && count < 2)
//            {
//                count++;
//                twoStepCursor = twoStepCursor.getNext();
//            }

            if(twoStepCursor != null)
            {
                twoStepCursor = twoStepCursor.getNext();
            }
            else{
                break;
            }
            if(twoStepCursor != null)
            {
                twoStepCursor = twoStepCursor.getNext();
            }
            else {
                break;
            }

            if(twoStepCursor == oneStepCursor)
            {
                System.out.println(oneStepCursor.getValue());

                isCircle =  true;
                break;
            }
        }


        if(isCircle)
        {
            oneStepCursor = first;
            while(oneStepCursor != twoStepCursor)
            {
                oneStepCursor = oneStepCursor.getNext();
                twoStepCursor = twoStepCursor.getNext();
            }
            return oneStepCursor;

        }

       return null;

    }


    /** lesson 3-16
     * 将链表反转
     * @param
     */
    public void reverseList()
    {
        ListNode<T> current = first.getNext();
        ListNode<T> prev = first;

        while(current != null){
            ListNode<T> next = current.getNext();
            if(prev == first)
            {
                prev.setNext(null);
            }
            current.setNext(prev);
            prev = current;
            current = next;
        }

    }

    public void madeCrossList(SingleLinkedList<T> newList)
    {
        if(length <3)
        {
            throw new RuntimeException("list length less than 4");
        }

        newList.last = first.getNext().getNext();
    }

    /**
     *
     * @param crossedList
     * @return
     */
    public ListNode<T> getCrossNode(SingleLinkedList<T> crossedList)
    {
        int firstCount =1 , secondCount= 1;

        ListNode<T> firstCursor = first;
        ListNode<T> secondCursor = crossedList.first;
        while( firstCursor != null && secondCursor != null  )
        {
            if(firstCursor != null)
            {
                firstCount++;
                firstCursor = firstCursor.getNext();
            }
            if(secondCursor != null)
            {
                secondCount++;
                secondCursor= secondCursor.getNext();
            }
        }

        int stepCountnb =Math.abs(firstCount-secondCount);
        firstCursor = first;
        secondCursor = crossedList.first;
        // 判断哪个链更称
        while(stepCountnb>0)
        {
            stepCountnb--;
            if(firstCount>secondCount){
                firstCursor = firstCursor.getNext();
            }else {
                secondCursor= secondCursor.getNext();
            }
        }

        while(firstCursor != null && secondCursor != null)
        {
            if(firstCursor == secondCursor)
            {
                return firstCursor;
            }
            firstCursor = firstCursor.getNext();
            secondCursor = secondCursor.getNext();
        }

        return firstCursor;
    }

    /**
     * lesson 3-24 找到链表的中间节点
     * @param args
     */

    public ListNode<T> getMiddleNode()
    {
        ListNode<T> fastCursor = first;
        ListNode<T> slowCursor = first;
        while(fastCursor != null || slowCursor != null)
        {

            fastCursor = fastCursor.getNext();
            if(fastCursor != null)
            {
                fastCursor = fastCursor.getNext();
            }
            slowCursor = slowCursor.getNext();
        }
        return slowCursor;
    }

    /**
     * lesson 3-32 反转相邻的节点
     */
    public void reverseData()
    {
        ListNode<T> prev = first;
        ListNode<T> current = first.getNext();

        first = current;
        int count =1;
        while(current != null)
        {
            prev.setNext( current.getNext()); ;

            if(count %2 == 1)
            {
                current.setNext(prev);
            }
            ListNode<T> tmp = current;
            current = prev.getNext();

            if(count %2 == 0)
            {prev = tmp;}

            count++;
        }

    }


    /**3-38
     *
     * 输入K 将k个的块进行反转
     * @param args
     */

    public void reverseKblock(int K)
    {
        ListNode<T> currentCursor = first;
        ListNode<T> innerFirstNode = null;
        ListNode<T> innerLastNode = null;
        ListNode<T> prevLastNode= null;
        while(currentCursor != null)
        {
            int count = 1;
            ListNode<T> innerPrev = currentCursor;
            ListNode<T> innerCurrent = currentCursor.getNext();
            while( innerCurrent != null &&  count < K)
            {
                ListNode<T> tmpNext = innerCurrent.getNext();

                if (count == 1) {
                    //innerPrev.setNext(innerLastNode);
                   innerLastNode = innerPrev;

                }
                count ++;
                if (count ==  K ||  innerCurrent.getNext() == null)
                {
                    innerFirstNode = innerCurrent;
                    if(prevLastNode!= null)
                    {
                        prevLastNode.setNext(innerFirstNode);
                    }
                }
                innerCurrent.setNext(innerPrev);
                innerPrev = innerCurrent;
                innerCurrent = tmpNext;
            }

            if(currentCursor == first)
            {
                first = innerFirstNode;
            }
            currentCursor = innerCurrent;

            innerLastNode.setNext(currentCursor);
            prevLastNode = innerLastNode;
           // innerLastNode =
        }

        printList();

    }

    private void  printList(){
        StringBuilder b = new StringBuilder();
        ListNode<T> cursor  = first;
        while(cursor != null)
        {
            b.append(cursor.getValue());
            b.append(",");
            cursor = cursor.getNext();
        }
        System.out.println(b.toString());

    }

    public static void main(String[] args) {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

    //    list.madeCircleData3_11();

//        //2 ,4 ,1,3
//
//        list.removeNode(1);
//
//        //2,1,3
//
//        list.removeNode(0);
//
//        // 1,3
//
//        list.removeNode(2);
//        //1
  //      list.removeAll();

  //      int length = list.listLength();

        list.reverseKblock(4);

        System.out.println("test");
    }
}
