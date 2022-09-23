package chapter4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigraphTest {

    @Test
    void vertex() {
        In in = new In("src/test/resources/tinyDG2.txt");

        Digraph g = new Digraph(in);
        String s = g.toString();

        DirectedCycle c = new DirectedCycle(g);
        StdOut.println(c.hasCycle());

        KosarajuSharirSCC scc = new KosarajuSharirSCC(g);
        StdOut.println(scc.count());

        DepthFirstOrder order = new DepthFirstOrder(g);
        for (int i : order.reversePost()) {
            StdOut.print(i+", ");
        }


        StdOut.println("");
        DepthFirstOrder order1 = new DepthFirstOrder(g.reverse());
        for (int i : order1.reversePost()) {
            StdOut.print(i+", ");
        }
    }

    @Test
    void edge() {
    }

    @Test
    void addEdge() {
    }

    @Test
    void adjacent() {
    }

    @Test
    void reverse() {
    }

    @Test
    void testToString() {
    }
}