package stack;

public class ListStack<T> implements Stack<T>{

    int capacity = 0;
    private ListNode<T> top = null;

    public class ListNode<T>{
        private T value;
        private ListNode<T> next;
        public ListNode()
        {

        }
        public ListNode(T val)
        {
            value = val;
        }
        public T getValue(){return value;}

        public void setNext(ListNode<T> next) {
            this.next = next;
        }

        public ListNode<T> getNext(){
            return next;
        }
    }
    @Override
    public T pop() {
        if(isEmpty())
        {
            return null;
        }
        T result = top.getValue();
        top = top.getNext();
        capacity--;
        return result;
    }

    @Override
    public T top() {
        if(isEmpty())
        {
            return null;
        }
        T result = top.getValue();
        //top = top.getNext();

        return result;
    }

    @Override
    public void push(T val) {

        ListNode<T> newNode = new ListNode<>(val);
        newNode.setNext(top);
        top = newNode;
        capacity++;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return true;
    }

    public void deleteStack(){
        top = null;
    }


    /**
     * 4-11 只使用pop和push 将stack反转
     * 先把所有的数据用递归的方式取出来后，用递归的方式写入数据
     */
    public void reverStack()
    {
        if(isEmpty())
        {
            return ;
        }
        T data = pop();
        reverStack();;
        insertAtBottom(data);
    }

    public void insertAtBottom(T data)
    {
        if(isEmpty())
        {
            push(data);
            return ;
        }

        T tmp = pop();
        insertAtBottom(data);
        push(tmp);

    }
}
