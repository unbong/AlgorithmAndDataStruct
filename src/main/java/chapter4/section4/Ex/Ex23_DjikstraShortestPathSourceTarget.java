package chapter4.section4.Ex;

import chapter1.section3.Queue;
import chapter4.section4.DirectedEdge;
import chapter4.section4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.IndexMinPQ;

public class Ex23_DjikstraShortestPathSourceTarget {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    private int target ;

    public Ex23_DjikstraShortestPathSourceTarget(EdgeWeightedDigraph graph, int start, int target){

        int v = graph.vertex();
        distTo = new double[v];
        edgeTo = new DirectedEdge[v];
        pq = new IndexMinPQ<>(v);
        this.target = target;
        for (int i = 0; i < v; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[start] = 0.0;

        pq.insert(start, 0.0);
        while(!pq.isEmpty())
        {
            int vertex = pq.delMin();
            for(DirectedEdge edge: graph.adjacenties(vertex )){
                relax(edge);
            }

            if(target == vertex)
            {
                break;
            }
        }
    }

    private void relax(DirectedEdge edge)
    {
        int to = edge.to();
        int from = edge.from();
        if(distTo[to] > distTo[from] + edge.getWeight())
        {
            distTo[to] = distTo[from] + edge.getWeight();
            edgeTo[to] = edge;
            if(pq.contains(to)){
                pq.decreaseKey(to, distTo[to]);
            }else{
                pq.insert(to, distTo[to]);
            }
        }
    }


    public Iterable<DirectedEdge> pathTo()
    {
        Queue<DirectedEdge> path = new Queue<>();

        for( DirectedEdge edge = edgeTo[target]; edge!=null ; edge = edgeTo[edge.from()] ){
            path.enqueue(edge);
        }
        return path;
    }
}
