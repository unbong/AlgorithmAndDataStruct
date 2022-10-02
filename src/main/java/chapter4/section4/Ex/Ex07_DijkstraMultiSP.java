package chapter4.section4.Ex;

import chapter4.section4.DirectedEdge;
import chapter4.section4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex07_DijkstraMultiSP {

    private double[] distTo;
    private double[] distToOther;
    private DirectedEdge[] edgeTo;
    private DirectedEdge[] edgeToother;
    private IndexMinPQ<Double> minPQ;

    private boolean isOtherSP = false;
    //private IndexMinPQ<Double> minPQOther;

    public Ex07_DijkstraMultiSP(EdgeWeightedDigraph graph, int start){
        int vertex = graph.vertex();
        distTo = new double[vertex];
        distToOther = new double[vertex];
        edgeTo = new DirectedEdge[vertex];
        edgeToother = new DirectedEdge[vertex];
        minPQ = new IndexMinPQ<>(vertex);
        //minPQOther = new IndexMinPQ<>(vertex);

        for (int i = 0; i < vertex; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
            distToOther[i] = Double.POSITIVE_INFINITY;
        }

        distTo[start] = 0.0;
        distToOther[start] = 0.0;

        minPQ.insert(start, 0.0);
        //minPQOther.insert(start, 0.0);
        while(!minPQ.isEmpty()) {
            int v = minPQ.delMin();

            for(DirectedEdge edge: graph.adjacenties(v)){
                relax(edge);
            }
        }
    }

    private void relax(DirectedEdge edge){
        int to = edge.to();
        int from = edge.from();

        if(distTo[to] > distTo[from]+ edge.getWeight()){
            distTo[to] = distTo[from] + edge.getWeight();
            edgeTo[to] = edge;
            distToOther[to] = distToOther[from]+ edge.getWeight();
            edgeToother[to] = edge;
            if(minPQ.contains(to)){ minPQ.decreaseKey(to, distTo[to]); }
            else{   minPQ.insert(to,distTo[to] );}
        }
        else if( distTo[to] == distTo[from]+ edge.getWeight() ){
            isOtherSP = true;
            distToOther[to] = distToOther[from]+ edge.getWeight();
            edgeToother[to] = edge;
//            if(minPQ.contains(to)){ minPQ.decreaseKey(to, distTo[to]); }
//            else{   minPQ.insert(to,distTo[to] );}
        }
    }

    public double distTo(int vertex)
    {
        return distTo[vertex];
    }

    public boolean hasPathTo(int vertex){
        return distTo[vertex] != Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int vertex){
        Stack<DirectedEdge> stack = new Stack<>();
        for(DirectedEdge edge = edgeTo[vertex]; edge != null; edge = edgeTo[edge.from()])
        {
            stack.push(edge);
        }
        return stack;
    }

    public double distToOther(int vertex)
    {
        if(!hasPathToOther(vertex)) return Double.POSITIVE_INFINITY;
        return distTo[vertex];
    }

    public boolean hasPathToOther(int vertex){
        if(!isOtherSP) return false;
        return vertex < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathToOther(int vertex){
        if(!hasPathToOther(vertex)) return null;
        Stack<DirectedEdge> stack = new Stack<>();
        for(DirectedEdge edge = edgeToother[vertex]; edge != null; edge = edgeToother[edge.from()])
        {
            stack.push(edge);
        }
        return stack;
    }

    /**
     * 0-4-5-1-3 == 0-2-7-3
     * @param args
     */
    public static void main(String[] args) {
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(new In("src/test/resources/tinyEWD_EX07.txt"));
        Ex07_DijkstraMultiSP sp = new Ex07_DijkstraMultiSP(g, 0);

        StdOut.println("exp: true, otherSP:"+sp.hasPathToOther(3));
        for (int v = 0; v < g.vertex(); v++) {
            StdOut.println(String.format("%d, dist:%.4f", v, sp.distTo(v)));
        }
        StdOut.println();
        if(sp.hasPathToOther(3))
        {
            for (DirectedEdge edge: sp.pathToOther(3))
            {
                StdOut.println(edge.toString());
            }
        }
        StdOut.println();

        for (DirectedEdge edge: sp.pathTo(3))
        {
            StdOut.println(edge.toString());
        }
    }

}
