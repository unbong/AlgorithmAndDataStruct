package chapter4.section3;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimMSTTest {

    @Test
    void edges() {
        In in = new In("src/test/resources/tinyEWG.txt");
        EdgeWeighedGraph eg = new EdgeWeighedGraph(in);

        PrimMST mst = new PrimMST(eg);

    }

    @Test
    void weight() {
    }
}