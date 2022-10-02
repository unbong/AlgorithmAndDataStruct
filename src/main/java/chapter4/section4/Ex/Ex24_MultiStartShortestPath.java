package chapter4.section4.Ex;

import chapter1.section3.Queue;
import chapter4.section4.DirectedEdge;
import chapter4.section4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.IndexMinPQ;

public class Ex24_MultiStartShortestPath {
    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private IndexMinPQ<Double> pq;

    public Ex24_MultiStartShortestPath(EdgeWeightedDigraph graph, int[] start)
    {
        int v = graph.vertex();
        distTo = new double[v];
        edgeTo = new DirectedEdge[v];
        pq = new IndexMinPQ<>(v);
        for (int i = 0; i < v; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        for (int i = 0; i < start.length; i++) {
            distTo[start[i]] = 0;
            pq.insert(start[i], 0.0);
        }

        while(!pq.isEmpty())
        {
            for(DirectedEdge e: graph.adjacenties(pq.delMin()))
            {
                relax(e);
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

    public boolean hasPathTo(int target){
        return distTo[target] < Double.POSITIVE_INFINITY;
    }


    public Iterable<DirectedEdge> pathTo(int target)
    {
        Queue<DirectedEdge> path = new Queue<>();

        for( DirectedEdge edge = edgeTo[target]; edge!=null ; edge = edgeTo[edge.from()] ){
            path.enqueue(edge);
        }
        return path;
    }

}
