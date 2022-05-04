package LinkedList;

public class ListNode <T>{

    private ListNode<T> prev = null;
    private ListNode<T> next = null;
    private T val = null;

    public ListNode(T value)
    {
        val = value;
    }

    public T getValue()
    {
        return val;
    }
    public void setNext (ListNode<T> next)
    {
        this.next = next;
    }

    public ListNode<T> getNext()
    {
        return next;
    }

    public void setPrev(ListNode<T> prev)
    {
        this.prev = prev;
    }
    public ListNode<T> getPrev()
    {
        return  prev;
    }
}
