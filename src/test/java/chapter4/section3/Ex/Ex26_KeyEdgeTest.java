package chapter4.section3.Ex;

import chapter4.section3.Edge;
import chapter4.section3.EdgeWeighedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex26_KeyEdgeTest {

    @Test
    void keyEdges() {

        In in = new In("src/test/resources/tinyEWG_Ex26.txt");
        EdgeWeighedGraph g = new EdgeWeighedGraph(in);

        Ex26_KeyEdge ex26_keyEdge = new Ex26_KeyEdge(g);

        for(Edge e: ex26_keyEdge.keyEdges())
        {
            StdOut.println(e.toString());

        }

    }
}