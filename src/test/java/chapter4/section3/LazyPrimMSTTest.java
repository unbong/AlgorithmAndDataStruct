package chapter4.section3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LazyPrimMSTTest {

    @Test
    void edges() {
        In in = new In("src/test/resources/tinyEWG.txt");
        EdgeWeighedGraph eg = new EdgeWeighedGraph(in);

        LazyPrimMST mst = new LazyPrimMST(eg);

        for (Edge e : mst.edges())
        {
            StdOut.println(e.toString());
        }
    }

    @Test
    void weight() {
        In in = new In("src/test/resources/tinyEWG.txt");
        EdgeWeighedGraph eg = new EdgeWeighedGraph(in);

        LazyPrimMST mst = new LazyPrimMST(eg);
        StdOut.print(mst.weight());
    }
}