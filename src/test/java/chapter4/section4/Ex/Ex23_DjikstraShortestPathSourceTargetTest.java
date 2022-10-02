package chapter4.section4.Ex;

import chapter4.section4.DirectedEdge;
import chapter4.section4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex23_DjikstraShortestPathSourceTargetTest {

    @Test
    void pathTo() {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD.txt"));

        Ex23_DjikstraShortestPathSourceTarget dd = new Ex23_DjikstraShortestPathSourceTarget(g, 0, 3);

        for (DirectedEdge e : dd.pathTo())
        {
            StdOut.println(e.toString());
        }
    }
}