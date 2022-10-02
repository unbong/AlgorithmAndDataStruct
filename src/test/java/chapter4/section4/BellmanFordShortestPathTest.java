package chapter4.section4;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BellmanFordShortestPathTest {

    @Test
    void distTo() {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD_BellmanFord.txt"));
        BellmanFordShortestPath sp = new BellmanFordShortestPath(g, 0);

        assertEquals(false, sp.hasPathTo(5));
        assertEquals(false, sp.hasPathTo(7));
    }

    @Test
    void pathTo() {
    }

    @Test
    void hasPathTo() {
    }
}