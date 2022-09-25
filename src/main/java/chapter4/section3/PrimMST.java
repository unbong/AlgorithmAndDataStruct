package chapter4.section3;

import chapter1.section3.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * Prim算法的即时实现
 */
public class PrimMST {

    private Edge[] edgeTo;              // 距离树最近的边
    private double[] distTo;            // distTo[w]= edgeTo[w].weight;
    private boolean[] marked;           // 如果v在书中则为 true
    private IndexMinPQ<Double> pq;      // 有效的横切边

    public PrimMST(EdgeWeighedGraph graph)
    {
        edgeTo = new Edge[graph.vertices()];
        distTo = new double[graph.vertices()];
        marked = new boolean[graph.vertices()];
        pq = new IndexMinPQ<Double>(graph.vertices());

        for (int i = 0; i < graph.vertices(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        distTo[0] = 0.0;
        pq.insert(0,0.0);
        while(!pq.isEmpty())
            visit(graph, pq.delMin());
    }

    private void visit(EdgeWeighedGraph graph, int vertex){
        marked[vertex] = true;
        for (Edge edge: graph.adjacent(vertex))
        {
            int other = edge.other(vertex);

            if(marked[other]) continue;
            if(edge.weight() < distTo[other])
            {
                edgeTo[other] = edge;
                distTo[other] = edge.weight();
                if(pq.contains(other)) pq.change(other,distTo[other]);
                else                   pq.insert(other, distTo[other]);
            }
        }

    }

    public Iterable<Edge> edges()
    {
        Bag<Edge> edges = new Bag<>();
        for (int i = 0; i < edgeTo.length; i++) {
            edges.add(edgeTo[i]);
        }
        return edges;
    }

    public double weight(){
        double weight = 0.0;
        for(Edge e: edgeTo){
            weight += e.weight();
        }
        return weight;
    }
}
