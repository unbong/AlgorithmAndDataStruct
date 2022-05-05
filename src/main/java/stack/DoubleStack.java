package stack;

public class DoubleStack<T> {

    public class Node<T> {
        private T value = null;
        public Node()
        {

        }
        public Node(T val)
        {
            value = val;
        }
        public T getValue(){return value;}
        public void setValue(T val)
        {
            this.value = val;
        }
    }

    int capacity= 0;
    int top1 = -1;
    int top2= -1;

    private Node<T>[] array = null;

    public DoubleStack(int size){
        capacity = size;
        array = new Node[size];
        top2 = capacity;
    }

    
    public T popOne() {
        if(isEmpty1()){
            return null;
        }

        Node<T> node = array[top1];
        array[top1] = null;
        top1--;

        return node.getValue();
    }

    private boolean isEmpty1() {
        return top1 == -1;
    }

    public T popTwo() {

        if(isEmpty2()){
            return null;
        }

        Node<T> node = array[top2];
        array[top2] = null;
        top1++;

        return node.getValue();

    }

    
    public T top1() {
        if(isEmpty1()){
            return null;
        }

        Node<T> node = array[top1];


        return node.getValue();
    }

    public T top2() {
        if(isEmpty2()){
            return null;
        }

        Node<T> node = array[top2];
        return node.getValue();
    }

    
    public void push1(T val) {
        // full
        if(top1 ==top2-1 )
        {
            throw new RuntimeException("stack is full");
        }
        top1++;
        array[top1] = new Node<>(val);

    }

//    1 2 3 4 5 6 7
//    0 1 2   2 1 0
//    0 1 2 3 4 5 6
//        o   t
    public void push2(T val) {
        // full
        if(top1 ==top2-1 )
        {
            throw new RuntimeException("stack is full");
        }
        top2--;
        array[top2] = new Node<>(val);
    }
    
    public int size1() {
        return top1+1;
    }




    public int size2() {
        return capacity - top2 - 1;
    }

    
    public boolean isEmpty2() {
        return top2==capacity;
    }

    
    public boolean isFull() {
        return top1 ==top2-1;
    }

    public static void main(String[] args) {

        DoubleStack<Integer> sd = new DoubleStack<>(10);

        sd.push1(1);
        sd.push1(2);
        sd.push2(1);
        sd.push2(2);
        System.out.println("sdf");

    }
}
