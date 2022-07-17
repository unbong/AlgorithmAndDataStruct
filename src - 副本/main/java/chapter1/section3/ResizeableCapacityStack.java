package chapter1.section3;


import java.util.Iterator;

public class ResizeableCapacityStack<T> implements Iterable<T>{

    int cur = -1;
    int capacity;
    private T[] array;

    public ResizeableCapacityStack(int cap) {
        this.capacity = cap;
        array = (T[]) new Object[cap];
    }

    public void push(T val) {
        if (isFull()) {
            //  throw new IllegalStateException("array is full");
            resize();
        }
        cur++;
        array[cur] = val;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("array is empty");
        }
        T res = array[cur];
        cur--;
        return res;
    }

    public boolean isFull() {
        return capacity - 1 == cur;
    }

    public boolean isEmpty() {
        return cur < 0;
    }

    public void resize() {
        int newSize = capacity * 2;
        T[] newArray = (T[]) new Object[newSize];
        for (int i = 0; i < capacity; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }


    public Iterator<T> iterator()
    {
        return  new Iter();
    }


    public class Iter implements Iterator<T> {
        private int i = capacity;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public T next() {
            return array[i--];
        }
    }
}
