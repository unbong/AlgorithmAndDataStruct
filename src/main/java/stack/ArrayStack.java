package stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T>{

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

    private Node<T>[]  array=null;
    private int capacity = 0;
    private int top = -1;
    public ArrayStack (int size)
    {
        array = new Node[size];
        capacity = size;
    }

    /**
     *
     * @return
     */
    @Override
    public T pop() {
        if(isEmpty())
        {
            return null;
        }
        Node<T> node = array[top];
        T result = node.getValue();
        array[top].setValue(null);
        top--;
        return result;
    }

    @Override
    public T top() {
        if(isEmpty())
        {
            return null;
        }
        Node<T> node = array[top];

        return node.getValue();
    }

    @Override
    public void push(T val) {

        // TODO: 2022/5/4 如果超过size 扩容处理
        if(isFull())
        {
            capacity = capacity *2;
            Node<T>[] newArray =new Node[capacity];
            int index = 0;
            for (Node<T> iter: array ) {
                newArray[index] = new Node(array[index].getValue());
                index++;
            }
            array = newArray;
        }
        top++;
        array[top] = new Node<>(val);

    }

    @Override
    public int size() {

        return top+1;
    }

    @Override
    public boolean isEmpty() {

        return top < 0;
    }

    @Override
    public boolean isFull() {
        return top == capacity-1;
    }

    public void deleteStack(){
        array = null;
    }

    

    public static void main(String[] args) {
        Stack<Integer> arrayStacks = new ArrayStack<>(1);
        arrayStacks.push(1);
        arrayStacks.push(2);
        arrayStacks.push(3);
        arrayStacks.push(4);
        arrayStacks.push(5);

        System.out.println(arrayStacks.pop());
        System.out.println(arrayStacks.pop());
        System.out.println(arrayStacks.pop());
        System.out.println(arrayStacks.pop());
        System.out.println(arrayStacks.pop());
        System.out.println(arrayStacks.pop());

        System.out.println("sd");
    }
}
