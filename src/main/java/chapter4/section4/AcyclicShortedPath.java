package chapter4.section4;

import chapter1.section3.Stack;
import chapter4.Topological;

/**
 * 无环加权图
 */
public class AcyclicShortedPath {

    private double[] distTo;
    private DirectedEdge[] edgeTo;

    public AcyclicShortedPath(EdgeWeightedDigraph graph, int start)
    {
        Topological topological = new Topological(graph);
        if(!topological.isDAG()) throw new IllegalArgumentException("graph has a cycle");
        distTo = new double[graph.vertex()];
        validateVertex(start);
        edgeTo = new DirectedEdge[graph.vertex()];



        for (int i = 0; i < graph.vertex(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[start] = 0;

        for(int orderedVertex : topological.order())
        {
            for(DirectedEdge edge: graph.adjacenties(orderedVertex))
            {
                relax(edge);
            }
        }
    }

    private void relax(DirectedEdge edge){
        int from = edge.from();
        int to = edge.to();
        if(distTo[to]> distTo[from]+edge.getWeight())
        {
            distTo[to] = distTo[from] + edge.getWeight();
            edgeTo[to] = edge;
        }
    }

    public double distTo(int vertex){
        return distTo[vertex];
    }

    public Iterable<DirectedEdge> pathTo(int vertex){

        validateVertex(vertex);
        if(!hasPathTo(vertex)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge edge = edgeTo[vertex]; edge != null ; edge = edgeTo[edge.from()])
        {
            path.push(edge);
        }
        return path;
    }

    public boolean hasPathTo(int vertex){
        validateVertex(vertex);
        return distTo[vertex] != Double.POSITIVE_INFINITY;
    }

    private void validateVertex(int  vertex){
        if(vertex< 0 || vertex> distTo.length-1) throw new IllegalArgumentException("vertex is invalid.");
    }
}
