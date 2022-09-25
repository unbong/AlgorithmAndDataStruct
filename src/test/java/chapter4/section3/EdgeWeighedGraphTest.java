package chapter4.section3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeWeighedGraphTest {

    @Test
    void vertices() {
        In in = new In("src/test/resources/tinyEWG.txt");
        EdgeWeighedGraph eg = new EdgeWeighedGraph(in);

        assertEquals(8, eg.vertices());
    }

    @Test
    void getEdges() {
        In in = new In("src/test/resources/tinyEWG.txt");
        EdgeWeighedGraph eg = new EdgeWeighedGraph(in);
        assertEquals(16, eg.edges());
    }

    @Test
    void addEdge() {
        In in = new In("src/test/resources/tinyEWG.txt");
        EdgeWeighedGraph eg = new EdgeWeighedGraph(in);

        Edge e = new Edge(7,6,0.1 );
        eg.addEdge(e);

        eg.addEdge(new Edge(5,0, 0.2));

        for(Edge g: eg.adjacent(7)){
            assertEquals(7, g.eigher());
            assertEquals(6, g.other(g.eigher()));
            assertEquals(0.1, g.weight());
            break;
        }

        for(Edge g: eg.adjacent(6)){
            assertEquals(7, g.eigher());
            assertEquals(6, g.other(g.eigher()));
            assertEquals(0.1, g.weight());
            break;
        }
        assertEquals(18, eg.getEdges());
    }

    @Test
    void edges() {
        In in = new In("src/test/resources/tinyEWG.txt");
        EdgeWeighedGraph eg = new EdgeWeighedGraph(in);

        for(Edge e:eg.edges()){
            StdOut.println(e.toString());
        }
    }

    @Test
    void adjacent() {
        In in = new In("src/test/resources/tinyEWG.txt");
        EdgeWeighedGraph eg = new EdgeWeighedGraph(in);

        Edge e = new Edge(7,6,0.1 );
        eg.addEdge(e);

        eg.addEdge(new Edge(5,0, 0.2));

        for(Edge g: eg.adjacent(7)){
            assertEquals(7, g.eigher());
            assertEquals(6, g.other(g.eigher()));
            assertEquals(0.1, g.weight());
            break;
        }
    }

    @Test
    void testToString() {
    }
}