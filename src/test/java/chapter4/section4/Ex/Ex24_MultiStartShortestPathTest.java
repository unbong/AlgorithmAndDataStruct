package chapter4.section4.Ex;

import chapter4.section4.DijkstraShortestPath;
import chapter4.section4.DirectedEdge;
import chapter4.section4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex24_MultiStartShortestPathTest {

    @Test
    void pathTo() {

        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/meiumEWD.txt"));
        int[] starts = {0,10, 20,30};
        Ex24_MultiStartShortestPath msp = new Ex24_MultiStartShortestPath(g, starts);

        DijkstraShortestPath sp = new DijkstraShortestPath(g, 20);

        if(msp.hasPathTo(109))
        {
            for(DirectedEdge e: msp.pathTo(109)){
                StdOut.println(e.toString());
            }
        }

        StdOut.println("--start 0-----");

        if(sp.hasPathTo(109))
        {
            for(DirectedEdge e: sp.pathTo(109)){
                StdOut.println(e.toString());
            }
        }


    }
}