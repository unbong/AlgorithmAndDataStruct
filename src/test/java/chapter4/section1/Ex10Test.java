package chapter4.section1;

import chapter4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex10Test {

    @Test
    void canDeleteVertex() {

        In in = new In("src/test/resources/tinyG_test5.txt");

        Graph g = new Graph(in);
        String s = g.toString();

        Ex10 ex = new Ex10(g, 9);

        for(Integer i: ex.canDeleteVertex())
        {
            StdOut.println(i);
        }
    }
}