package chapter4.section1;

import chapter2.section4.Ex13;
import chapter4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex13_BFSWithDistanceTest {

    @Test
    void hasPathTo() {
        In in = new In("src/test/resources/tinyG.txt");

        Graph g = new Graph(in);

        Ex13_BFSWithDistance ex = new Ex13_BFSWithDistance(g, 0);

        assertEquals(true, ex.hasPathTo(1));
        assertEquals(false, ex.hasPathTo(9));
    }

    @Test
    void pathTo() {
        In in = new In("src/test/resources/tinyG.txt");

        Graph g = new Graph(in);

        Ex13_BFSWithDistance ex = new Ex13_BFSWithDistance(g, 0);
        for(int w: ex.pathTo(1)){
            StdOut.println(w);
        }

        for(int w: ex.pathTo(3)){
            StdOut.println(w);
        }
    }

    @Test
    void distTo() {
        In in = new In("src/test/resources/tinyG.txt");

        Graph g = new Graph(in);
        StdOut.print(g.toString());
        Ex13_BFSWithDistance ex = new Ex13_BFSWithDistance(g, 0);

        assertEquals(1, ex.distTo(5));

        assertEquals(2, ex.distTo(4));
        assertEquals(0, ex.distTo(0));
        assertEquals(1, ex.distTo(2));
        assertEquals(
                2, ex.distTo(3));
    }
}