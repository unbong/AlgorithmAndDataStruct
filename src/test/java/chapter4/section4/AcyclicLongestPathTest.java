package chapter4.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcyclicLongestPathTest {

    @Test
    void distTo() {
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
    void pathTo() {
    }
}