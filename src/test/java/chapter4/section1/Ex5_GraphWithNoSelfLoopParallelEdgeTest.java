package chapter4.section1;

import chapter4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex5_GraphWithNoSelfLoopParallelEdgeTest {

    @Test
    void addEdge() {
        In in = new In("src/test/resources/tinyG_test5.txt");

        Ex5_GraphWithNoSelfLoopParallelEdge g = new Ex5_GraphWithNoSelfLoopParallelEdge(in);

        StdOut.print(g.toString());


    }

    @Test
    void hasEdge() {
    }

    @Test
    void v() {
    }

    @Test
    void e() {
    }

    @Test
    void adj() {
    }
}