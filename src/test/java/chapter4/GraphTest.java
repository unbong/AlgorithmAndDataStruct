package chapter4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void v() {
        In in = new In("src/test/resources/tinyG.txt");

        Graph g = new Graph(in);
        StdOut.println("V:" + g.V() );

    }

    @Test
    void e() {
    }

    @Test
    void addEdge() {
    }

    @Test
    void adj() {
    }

    @Test
    void testToString() {
        In in = new In("src/test/resources/tinyG.txt");

        Graph g = new Graph(in);
        String s = g.toString();
        StdOut.print(s);
    }

    @Test
    void testToString2(){
        In in = new In("src/test/resources/test.webp");
        Graph g = new Graph(in);
        StdOut.print(g.toString());
    }
    @Test
    void hasEdge() {
        In in = new In("src/test/resources/tinyG.txt");

        Graph g = new Graph(in);
        assertEquals(true, g.hasEdge(1,0));
        assertEquals(true, g.hasEdge(5,0));
        assertEquals(false, g.hasEdge(2,1));
    }


}
