package chapter4.section3;

import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    @Test
    void weight() {
        Edge e = new Edge(1,2,0.1);
        assertEquals(0.1, e.weight());
    }

    @Test
    void eigher() {
        Edge e = new Edge(1,2,0.1);
        assertEquals(1, e.eigher());
    }

    @Test
    void other() {
        Edge e = new Edge(1,2,0.1);
        assertEquals(2, e.other(e.eigher()));
    }

    @Test
    void testToString() {
        Edge e = new Edge(1,2,0.1);

        StdOut.print(e.toString());
    }

    @Test
    void compareTo() {
        Edge e1 = new Edge(1,2,0.1);

        Edge e2 = new Edge(1,2,0.21);

        assertEquals(-1, e1.compareTo(e2));


    }
}