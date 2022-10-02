package chapter4.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcyclicShortedPathTest {

    @Test
    void distTo() {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD.txt"));
        assertThrows(IllegalArgumentException.class,()->{new AcyclicShortedPath(g, 0);});

        EdgeWeightedDigraph g1 = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD_AcyclicTest.txt"));
        // 5 1 0.32
        g1.addEdge(new DirectedEdge(5,1,0.32));
        AcyclicShortedPath sp = new AcyclicShortedPath(g1, 0);

        //assertEquals(0.73, sp.distTo(5));
        //assertEquals(0.6, sp.distTo(7));

        for(DirectedEdge e: sp.pathTo(6)){
            StdOut.println(e.toString());
        }
        StdOut.println("");
        for(DirectedEdge e: sp.pathTo(1 )){
            StdOut.println(e.toString());
        }
    }

    @Test
    void pathTo() {

        EdgeWeightedDigraph g1 = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD_AcyclicTest.txt"));
        // 5 1 0.32
        //g1.addEdge(new DirectedEdge(5,1,0.32));
        AcyclicShortedPath sp = new AcyclicShortedPath(g1, 4);
        for(DirectedEdge e: sp.pathTo(5)){
            StdOut.println(e.toString());
        }
    }

    @Test
    void hasPathTo() {

    }

    @Test
    void testDistTo() {
    }

    @Test
    void testPathTo() {
    }

    @Test
    void testHasPathTo() {
    }
}