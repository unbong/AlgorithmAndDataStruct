package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex24_LinkedListPQTest {

    @Test
    void insert() {
        Ex24_LinkedListPQ<Integer> lpq = new Ex24_LinkedListPQ<>();
        lpq.insert(12);
        lpq.insert(13);
        lpq.insert(14);
        lpq.insert(15);

        StdOut.println();


    }
}