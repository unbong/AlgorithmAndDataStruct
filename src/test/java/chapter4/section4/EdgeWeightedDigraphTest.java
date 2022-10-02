package chapter4.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeWeightedDigraphTest {

    @Test
    void vertex() {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD.txt"));
        assertEquals(8, g.vertex());
    }

    @Test
    void edge() {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD.txt"));
        assertEquals(15, g.edge());
        g.addEdge(new DirectedEdge(0,7, 0.12));
        assertEquals(16, g.edge());
        for(DirectedEdge e : g.adjacenties(0))
        {
            StdOut.println(e.toString());
        }
    }

    @Test
    void adjacenties() {


    }

    @Test
    void edges() {

        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD.txt"));

        for(DirectedEdge e: g.edges())
        {
            StdOut.println(e.toString());
        }
    }

    @Test
    void addEdge() {


    }
}