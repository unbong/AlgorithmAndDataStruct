package LinkedList;

public class ListNode <T>{

    private ListNode prev = null;
    private ListNode next = null;
    private T val = null;

    public ListNode(T value)
    {
        val = value;
    }

    public void setNext (ListNode next)
    {
        this.next = next;
    }

    public ListNode getNext()
    {
        return next;
    }

    public void setPrev(ListNode prev)
    {
        this.prev = prev;
    }
    public ListNode getPrev()
    {
        return  prev;
    }
}
