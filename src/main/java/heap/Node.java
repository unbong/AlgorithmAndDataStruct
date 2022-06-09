package heap;

public class Node <E>{

    private E val;

    public Node(E value)
    {
        val = value;
    }

    public Node()
    {

    }

    public E getVal() {
        return val;
    }

    public void setVal(E val) {
        this.val = val;
    }
}
