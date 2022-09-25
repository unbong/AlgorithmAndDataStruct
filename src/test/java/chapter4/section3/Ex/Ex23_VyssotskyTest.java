package chapter4.section3.Ex;

import chapter4.section3.Edge;
import chapter4.section3.EdgeWeighedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex23_VyssotskyTest {

    @Test
    void edges() {

        In in = new In("src/test/resources/tinyEWG.txt");
        EdgeWeighedGraph g = new EdgeWeighedGraph(in);

        Ex23_Vyssotsky v = new Ex23_Vyssotsky(g);

        for(Edge e:v.edges()){
            StdOut.println(e.toString());
        }

        assertEquals(1.81 *2, v.getWeight());
    }

    @Test
    void getWeight() {
    }
}