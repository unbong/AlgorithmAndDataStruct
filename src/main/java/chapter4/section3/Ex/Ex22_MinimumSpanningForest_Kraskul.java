package chapter4.section3.Ex;

import chapter1.section3.Queue;
import chapter1.section5.QuickUnion;
import chapter4.section3.Edge;
import chapter4.section3.EdgeWeighedGraph;
import edu.princeton.cs.algs4.MinPQ;

public class Ex22_MinimumSpanningForest_Kraskul {

    private Queue<Edge> msf;

    private  double weight;

    public Ex22_MinimumSpanningForest_Kraskul(EdgeWeighedGraph g){

        msf =new Queue<>();
        QuickUnion qu = new QuickUnion(g.vertices());
        MinPQ<Edge> pq = new MinPQ<>();
        boolean[] marked = new boolean[g.vertices()];
        for(Edge e: g.edges()) pq.insert(e);

        while(!pq.isEmpty() && msf.getSize() <= g.vertices()-1 )
        {
            Edge e = pq.delMin();
            int vertex = e.eigher();
            int other = e.other(vertex);
            if(qu.connected(vertex, other)) continue;
            weight += e.weight();
            qu.union(vertex, other);
            msf.enqueue(e);
        }
    }

    public double getWeight(){return weight;}

    public Iterable<Edge> edges(){return msf;}

}
