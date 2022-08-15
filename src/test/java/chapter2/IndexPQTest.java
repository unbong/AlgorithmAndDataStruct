package chapter2;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexPQTest {

    @Test
    void insert() {

        IndexPQ<Integer> ipq = new IndexPQ<>(10,IndexPQ.Orientation.MAX );

        ipq.insert(1, 4);
        ipq.insert(2, 7);
        ipq.insert(3, 6);

        Integer i = ipq.top();

        Assertions.assertEquals(7, i);
        i = ipq.top();
        Assertions.assertEquals(6, i);
        i = ipq.top();
        Assertions.assertEquals(4, i);
    }

    @Test
    void change() {

        IndexPQ<Integer> ipq = new IndexPQ<>(10,IndexPQ.Orientation.MAX );

        ipq.insert(6, 4);
        ipq.insert(2, 7);
        ipq.insert(8, 6);
        ipq.insert(3, 8);

        ipq.change(2, 1);
        Integer i = ipq.top();
        Assertions.assertEquals(8, i);
        i = ipq.top();

        Assertions.assertEquals(6, i);
        i = ipq.top();
        Assertions.assertEquals(4,i);
        i = ipq.top();
        Assertions.assertEquals(1,i);

    }

    @Test
    void contains() {
    }

    @Test
    void delete() {
    }

    @Test
    void top() {
    }

    @Test
    void topIndex() {
    }

    @Test
    void deleteTop() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void size() {
    }
}