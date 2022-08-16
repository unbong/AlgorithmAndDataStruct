package chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {

    @Test
    void insert() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(2, PriorityQueue.Orientation.MAX);
        pq.insert(3);
        pq.insert(4);
        Assertions.assertEquals(2, pq.size());
        pq.insert(2);
        Assertions.assertEquals(3,pq.size());

        Assertions.assertEquals(4,pq.max());
        Assertions.assertEquals(3,pq.max());
        Assertions.assertEquals(2,pq.max());
    }

    @Test
    void max() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(16, PriorityQueue.Orientation.MAX);
        for (int i = 0; i < 16; i++) {
            pq.insert(i);
        }

        Assertions.assertEquals(16, pq.size());

        for (int i = 0; i < 12; i++) {
            pq.max();
        }
        Assertions.assertEquals(4, pq.size());
    }
}