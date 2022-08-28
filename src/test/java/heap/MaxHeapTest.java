package heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxHeapTest {


    @Test
    void remove() {

        MaxHeap<Integer> mheap = new MaxHeap<>(10);

        mheap.add(10);
        mheap.add(20);
        mheap.add(25);
        mheap.add(35);
        mheap.add(45);
        mheap.add(55);
        mheap.add(65);

        System.out.println(mheap.toString());
        Integer m = mheap.remove();
        Assertions.assertEquals(65, m);

        System.out.println(mheap.toString());
    }
}