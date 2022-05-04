package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CircleLinkedList<T> {

    private ListNode<T> first = null;
    private ListNode<T> last = null;
    private int length = 0;


    public int getLength()
    {
        return length;
    }

    public void addNode(T value , int position)
    {
        ListNode<T> newNode = new ListNode<>(value);
        if (first == null) {
            first = newNode;
            last = first;
            first.setNext(last);
            last.setNext(first);
        }
        else if ( position <= 1 )
        {
            newNode.setNext(first);
            last.setNext(newNode);
            first = newNode;
        }
        else {
            int count = 0;
            ListNode<T> cursor = first;
            ListNode<T> cursorFront = null;
            do {
                count++;
                cursorFront = cursor;
                cursor = cursor.getNext();
            } while (cursor != last && count < position);

            // last node
            if (cursor == last) {
                last.setNext(newNode);
                newNode.setNext(first);
                last = newNode;
            } else {
                cursorFront.setNext(newNode);
                newNode.setNext(cursor);
            }
        }
        length++;
    }

    public void removeNode(int position)
    {
        if(first == null)
        {
            return;
        }

        // first node
        if(position <= 1)
        {
            ListNode<T> tmp = first;
            first = first.getNext();
            tmp.setNext(null);
        }
        else
        {
            ListNode<T> cursorFront = null;
            ListNode<T> cursor = first;
            int count = 0;
            do{
                count++;
                cursorFront = cursor;
                cursor = cursor.getNext();

            }while(cursor!=last && count< position);

            // last node
            if(cursor == last)
            {
                cursorFront.setNext(first);
                last = cursorFront;
                cursor.setNext(null);
            }else
            {
                cursorFront.setNext(cursor.getNext());
                cursor.setNext(null);
            }
        }
        length --;
    }


    public void printAllNode()
    {
        ListNode<T> cursor = first;
        int count = 1;
        do{
            System.out.println(String.format("No.%d, value* %s", count,cursor.getValue().toString()));
            cursor= cursor.getNext();
        }while(cursor != first);
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
        ListNode<T> twoStepCursor = first.getNext();

        while(oneStepCursor != twoStepCursor )
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

            if(twoStepCursor == null)
            {
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
     * 3-40
     */

    public ListNode<T> getLastSurviveNode(int m)
    {
        int length = getLength();
        while(length> 1)
        {
            if(length > m)
            {
                removeNode(m);
            }else {
                int removeIndex =m % length;
                if(removeIndex > 0)
                {
                    removeNode(removeIndex);
                }
                else {
                    removeNode(length);
                }
            }
            length--;
        }


        return first;
    }

    /**
     * lesson 3-9
     * @return
     */
//    public boolean isCircle3_9()
//    {
//        if(length <= 1)
//        {
//            return  false;
//        }
//        ListNode<T> current = first;
//        int count = 1;
//        while(current.getNext() != first  )
//        {
//            count++;
//            current = current.getNext();
//            if(current == null)
//            {
//                return false;
//            }
//        }
//        return  true;
//    }
    public static void main(String[] args) {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        list.addNode(1,1);
        list.addNode(2,2);
        list.addNode(3,3);
        list.addNode(4,4);

        list.removeNode(5);
        list.removeNode(5);
        list.removeNode(5);
        list.removeNode(5);
        System.out.println("te");
    }
}
