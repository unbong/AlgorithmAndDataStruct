package chapter4.section4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectedEdgeTest {

    @Test
    void getWeight() {
        DirectedEdge edge = new DirectedEdge(0,1 , 0.1);
        assertEquals(0.1, edge.getWeight());
    }

    @Test
    void from() {
        DirectedEdge edge = new DirectedEdge(0,1 , 0.1);
        assertEquals(0, edge.from());
    }

    @Test
    void to() {
        DirectedEdge edge = new DirectedEdge(0,1 , 0.1);
        assertEquals(1, edge.to());
    }

    @Test
    void testToString() {
        DirectedEdge edge = new DirectedEdge(0,1 , 0.1);
        assertEquals("0->1, weight:0.10000", edge.toString());
    }

    @Test
    void compareTo() {
        DirectedEdge edge = new DirectedEdge(0,1 , 0.1);
        DirectedEdge edge1 = new DirectedEdge(1,2 , 0.11);
        DirectedEdge edge2 = new DirectedEdge(2,3 , 0.01);

        DirectedEdge edge3 = new DirectedEdge(0,1 , 0.1);

        assertEquals(-1, edge.compareTo(edge1));
        assertEquals(1, edge.compareTo(edge2));
        assertEquals(0, edge.compareTo(edge));
    }
}