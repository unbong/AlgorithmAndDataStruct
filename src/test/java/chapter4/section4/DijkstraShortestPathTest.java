package chapter4.section4;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraShortestPathTest {

    @Test
    void distTo() {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD.txt"));
        DijkstraShortestPath sp = new DijkstraShortestPath(g, 0);

        assertEquals(0.73, sp.distTo(5));
        assertEquals(0.6, sp.distTo(7));



    }

    @Test
    void hasPathTo() {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD.txt"));
        DijkstraShortestPath sp = new DijkstraShortestPath(g, 0);

        assertEquals(true, sp.hasPathTo(5));
        assertEquals(true, sp.hasPathTo(7));

        DijkstraShortestPath sp1 = new DijkstraShortestPath(g, 4);

        for (DirectedEdge e: sp1.pathTo(6))
        {
            StdOut.println(e.toString());
        }

        for (DirectedEdge e: sp1.pathTo(1))
        {
            StdOut.println(e.toString());
        }

    }

    @Test
    void pathTo() {

        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD.txt"));
        DijkstraShortestPath sp = new DijkstraShortestPath(g, 0);

        for (DirectedEdge e: sp.pathTo(6))
        {
            StdOut.println(e.toString());
        }

        for (DirectedEdge e: sp.pathTo(1))
        {
            StdOut.println(e.toString());
        }


    }
}