package LinkedList;

public class SingleLinkedList<T> {

    private ListNode<T> firstNode = null;
    private ListNode<T> lastNode = null;
    private int length = 0;

    public void addLast(T value)
    {
        if (firstNode == null)
        {
            firstNode = new ListNode<>(value);
            lastNode = firstNode;
        }else
        {
            ListNode<T> newNode = new ListNode<>(value);
            lastNode.setNext(newNode);
            lastNode = newNode;
        }
        length ++;
    }

    public void addFirst(T value)
    {
        if (firstNode == null)
        {
            firstNode = new ListNode<>(value);
        }else
        {
            ListNode<T> newNode = new ListNode<>(value);
            newNode.setNext(firstNode);
            firstNode = newNode;
        }
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
            ListNode<T> cursor = firstNode;
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
        ListNode<T> cursor = firstNode;
        ListNode<T> tempNode = null;
        while(cursor!= null)
        {
            tempNode = cursor.getNext();
            cursor.setNext(null);
            cursor = tempNode;
        }
        firstNode = null;
        lastNode = null;
        length = 0;
    }

    public void removeNode(int position)
    {
        if(position <= 1)
        {
            firstNode = firstNode.getNext();

        }
        else
        {
            ListNode<T> cursor = firstNode;
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
                lastNode = cursorFront;

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
        ListNode<T> cursor = firstNode;
        int count = 0;
        while (cursor != null )
        {
            count++;
            cursor = cursor.getNext();
        }

        return count;
    }

    public static void main(String[] args) {

        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.addLast(1);
        list.addFirst(2);
        list.addLast(3);

        list.addNodeAtPosition(4, 1);

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
        list.removeAll();

        int length = list.listLength();

        System.out.println("test");


    }
}
