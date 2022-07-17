package chapter1.section3.exersize;

import java.util.Arrays;

public class RingBuffer_1_3_39<T> {

    private T array[];
    private int first = 0;
    private int last= 0;
    private int size = 0;
    private int capacity = 0;

    public RingBuffer_1_3_39(int capacity)
    {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public String toString() {
        return "RingBuffer_1_3_39{" +
                "array=" + Arrays.toString(array) +
                ", first=" + first +
                ", last=" + last +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    public boolean isFull()
    {

        return size == capacity;
    }

    public void add(T val)
    {
        if(isFull())
        {
            throw new UnsupportedOperationException("buffer is full");
        }
        else
        {
            array[last++] = val;
            if(last == capacity)
            {
                last = last%capacity;
            }
        }
        size++;
    }

    public T get()
    {
        if(isEmpty())
        {
            throw new UnsupportedOperationException("buffer is empty");
        }

        else {
            T res = array[first++];
            if(first == capacity)
            {
                first = first%capacity;
            }
            size--;
            return res;
        }
    }

    public static void main(String[] args) {
        RingBuffer_1_3_39<Integer> buffer = new RingBuffer_1_3_39<Integer>(10);
        for (int i = 0; i < 9; i++) {
            buffer.add(i);

        }


        Integer res = buffer.get();
        System.out.println(res);
        System.out.println(buffer.toString());

        buffer.add(100);
        buffer.add(101);
        System.out.println(buffer.toString());
        System.out.println( buffer.get());
        System.out.println( buffer.get());
        buffer.add(102);


        System.out.println(buffer.toString());
    }
}
