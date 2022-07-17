package chapter1.section3.exersize;

import java.util.Arrays;

/**
 * 数组实现  1.3.38
 * @param <T>
 */
public class GeneralizedQueue <T>{

    private int size =0;
    private int capacity;
    private T[] array;

    public GeneralizedQueue(int capacity)
    {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private void resize()
    {

    }

    public void insert(T val)
    {
        array[size++] = val;
    }

    public T delete(int k)
    {
        if(k>size)
        {
            throw new IllegalArgumentException("k: " +k + "  > size: " + size);
        }
        T res = array[k];
        T prev = null;
        for(int i = size-1; i > k; i--)
        {
            T tmp  = array[i];
            array[i] = prev;
            prev = tmp;
        }

        return res;
    }

    @Override
    public String toString() {
        return "GeneralizedQueue{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String[] args) {
        GeneralizedQueue<Integer> gs = new GeneralizedQueue<>(20);
        for (int i = 0; i < 20; i++) {
            gs.insert(i);
        }

        gs.delete(3);

        System.out.println(gs.toString());
    }

}
