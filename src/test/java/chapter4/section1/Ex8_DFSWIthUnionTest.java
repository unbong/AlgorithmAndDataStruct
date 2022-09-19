package chapter4.section1;

import chapter4.Graph;
import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex8_DFSWIthUnionTest {

    @Test
    void dfs() {
    }

    @Test
    void marked() {
        In in = new In("src/test/resources/tinyG.txt");

        Graph g = new Graph(in);
        Ex8_DFSWIthUnion ex8 = new Ex8_DFSWIthUnion(g, 1);
        assertEquals(true, ex8.marked(0));
        assertEquals(false, ex8.marked(7));
        assertEquals(true, ex8.marked(1));

        Ex8_DFSWIthUnion ex18 = new Ex8_DFSWIthUnion(g, 8);
        assertEquals(false, ex18.marked(0));
        assertEquals(true, ex18.marked(7));
        assertEquals(false, ex18.marked(1));
    }

    @Test
    void count() {
        In in = new In("src/test/resources/tinyG.txt");

        Graph g = new Graph(in);
        Ex8_DFSWIthUnion ex8 = new Ex8_DFSWIthUnion(g, 1);

        assertEquals(7, ex8.count());
    }
}