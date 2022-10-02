package chapter4.section4;

import chapter1.section3.Stack;
import chapter4.Topological;

/**
 * 无环加权图的最长路径
 */
public class AcyclicLongestPath {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private Iterable<Integer> order;

    public AcyclicLongestPath(EdgeWeightedDigraph graph, int start){
        int vertex = graph.vertex();
        distTo = new double[vertex];
        edgeTo = new DirectedEdge[vertex];
        for (int i = 0; i < vertex; i++) {
            distTo[i] = Double.NEGATIVE_INFINITY;
        }
        distTo[start] = 0.0;

        Topological topological = new Topological(graph);
        order = topological.order();

        if(!topological.isDAG())
            throw new IllegalArgumentException("graph is not acyclic.");
        for (int v:order)
        {
            for(DirectedEdge e: graph.adjacenties(v))
                relax(e);
        }

    }

    private void relax(DirectedEdge e){

        int to = e.to();
        int from = e.from();
        if(distTo[to] < distTo[from]+e.getWeight())
        {
            distTo[to] = distTo[from]+e.getWeight();
            edgeTo[to] = e;
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hasPathTo(int vertex){
        return distTo[vertex] > Double.NEGATIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int vertex){

        if(!hasPathTo(vertex)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[vertex]; e != null; e = edgeTo[e.from()])
        {
            path.push(e);
        }
        return path;
    }
}
