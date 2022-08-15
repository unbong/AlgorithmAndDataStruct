package chapter2;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 索引优先队列
 */
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
    void insert2()
    {
        IndexPQ<Integer> ipq = new IndexPQ<>(10,IndexPQ.Orientation.MIN );

        ipq.insert(6, 4);
        ipq.insert(2, 7);
        ipq.insert(8, 6);
        ipq.insert(3, 8);

        //ipq.change(2, 1);
        Integer i = ipq.top();
        Assertions.assertEquals(4, i);
        i = ipq.top();

        Assertions.assertEquals(6, i);
        i = ipq.top();
        Assertions.assertEquals(7,i);
        i = ipq.top();
        Assertions.assertEquals(8,i);
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

        IndexPQ<Integer> ipq = new IndexPQ<>(10,IndexPQ.Orientation.MAX );

        ipq.insert(6, 4);
        ipq.insert(2, 7);
        ipq.insert(8, 6);
        ipq.insert(3, 8);

        boolean exist = ipq.contains(1);
        Assertions.assertEquals(false, exist);

        exist = ipq.contains(2);
        Assertions.assertEquals(true , exist);
    }

    @Test
    void delete() {
    }

    @Test
    void top() {
    }

    @Test
    void topIndex() {

        IndexPQ<Integer> ipq = new IndexPQ<>(10,IndexPQ.Orientation.MAX );

        ipq.insert(6, 4);
        ipq.insert(2, 7);
        ipq.insert(8, 6);
        ipq.insert(3, 8);

        int index = ipq.topIndex();
        Assertions.assertEquals(3, index);

        ipq.change(3,1);
        index = ipq.topIndex();
        Assertions.assertEquals(2, index);
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