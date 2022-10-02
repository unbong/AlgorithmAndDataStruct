package chapter4.section4.Ex;

import chapter4.section4.DijkstraShortestPath;
import chapter4.section4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex09_CityDistance {

    public static void main(String[] args) {

        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/Ex09"));

        for (int i = 0; i < g.vertex(); i++) {
            DijkstraShortestPath sp = new DijkstraShortestPath(g, i);
            for (int j = 0; j < g.vertex(); j++) {
                StdOut.println(String.format("%d->%d, dist %.2f",i, j, sp.distTo(j)));
            }
        }
    }
}
