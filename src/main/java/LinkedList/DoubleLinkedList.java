package LinkedList;

public class DoubleLinkedList<T> {

    private ListNode<T> first = null;
    private ListNode<T> last = null;
    private int length = 0;

    public void addNode(T value, int position)
    {
        ListNode<T> newNode = new ListNode<>(value);
        if(first == null)
        {
            first =newNode;
            last = first;
        }
        else if(position == 1)
        {
            first.setPrev(newNode);
            newNode.setNext(first);
            first = newNode;
        }
        else
        {
            ListNode<T> cursor = first;
            ListNode<T> cursorFront = null;
            int count = 1;
            while(cursor != null && count < position)
            {
                count++;
                cursorFront = cursor;
                cursor = cursor.getNext();
            }
            // last node
            if(cursor == null)
            {
                newNode.setPrev(cursorFront);
                cursorFront.setNext(newNode);
                last = newNode;
            }
            else {
                newNode.setPrev(cursorFront);
                cursorFront.setNext(newNode);
                newNode.setNext(cursor);
                cursor.setPrev(newNode);
            }
        }
        length++;
    }

    public void removeNode(int position)
    {
        int count = 1;
        ListNode<T> cursor = null;

        if(first == null)
        {
            return ;
        }
        // first node
        if(position <= 1)
        {
            cursor = first.getNext();
            if(cursor != null)
            {
                cursor.setPrev(null);
            }
            first.setNext(null);
            first=cursor;
        }
        else
        {
            cursor = first;
            ListNode<T> prevNode = null;
            while( cursor != null && count< position )
            {
                prevNode = cursor;
                cursor = cursor.getNext();
                count++;
            }
            // last node
            if(cursor == null)
            {
                last = prevNode.getPrev();
                prevNode.getPrev().setNext(null);
                prevNode.setPrev(null);


            }
            else
            {
                prevNode.setNext(cursor.getNext());
                cursor.getNext().setPrev(prevNode);
                cursor.setNext(null);
                cursor.setNext(null);
            }
        }
        length--;
    }


    public static void main(String[] args) {
        DoubleLinkedList<Integer> list  = new DoubleLinkedList<>();
        list.addNode(1, 1);
        list.addNode(2,2);
        list.addNode(3, 3);
        list.addNode(4, 4);
        list.removeNode(5);
        //1,2，3
        list.removeNode(0);
        //2，3
        list.removeNode(1);
        list.removeNode(1);
        list.removeNode(1);

        System.out.println("");
    }

}
