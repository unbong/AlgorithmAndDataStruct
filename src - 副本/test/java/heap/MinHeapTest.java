package heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    @Test
    void add() {
        MinHeap<Integer> mheap = new MinHeap<>(10);

        mheap.add(65);

        mheap.add(55);

        mheap.add(45);

        mheap.add(35);

        mheap.add(25);

        mheap.add(20);

        mheap.add(10);
        System.out.println(mheap.toString());

        Integer m = mheap.remove();

        //Assertions.assertEquals(10, m);
        System.out.println(mheap.toString());

    }

    @Test
    void remove() {

    }
}