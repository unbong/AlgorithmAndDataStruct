package chapter4.section4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeWeightedDirectedCycleTest {

    @Test
    void cycle() {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD_Cycle_Test.txt"));
        EdgeWeightedDirectedCycle cycle = new EdgeWeightedDirectedCycle(g);
        assertEquals(true, cycle.hasCycle());

        for(DirectedEdge edge : cycle.cycle()){
            StdOut.println(edge.toString());

        }
    }

        @Test
    void hasCycle() {
    }
}