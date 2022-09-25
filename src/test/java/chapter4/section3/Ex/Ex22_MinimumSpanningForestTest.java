package chapter4.section3.Ex;

import chapter1.section3.Queue;
import chapter4.section3.Edge;
import chapter4.section3.EdgeWeighedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex22_MinimumSpanningForestTest {

    @Test
    void edges() {

        In in = new In("src/test/resources/tinyEWG_Ex22.txt");
        EdgeWeighedGraph g = new EdgeWeighedGraph(in);

        Ex22_MinimumSpanningForest_LazyPrim msf = new Ex22_MinimumSpanningForest_LazyPrim(g);

        assertEquals(2, msf.edges().size());
        for (int i = 0; i < msf.edges().size(); i++) {
            Queue<Edge> mst = msf.edges().get(i);
            for (Edge edge: mst) {
                StdOut.println(edge.toString());
            }
        }
        
    }
}