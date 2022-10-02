package chapter4.section4;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;
import org.jetbrains.annotations.NotNull;

public class DijkstraShortestPath {

    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> minPQ;

    private final int start;

    public DijkstraShortestPath(@NotNull EdgeWeightedDigraph graph, int start){

        this.start = start;
        int vertex = graph.vertex();
        edgeTo = (DirectedEdge[]) new DirectedEdge[vertex];
        distTo = new double[vertex];
        minPQ = new IndexMinPQ<>(vertex);
        for (int i = 0; i < vertex; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[start] = 0.0;

        minPQ.insert(start, 0.0);
        while(!minPQ.isEmpty())
        {
            int from  = minPQ.delMin();
            for(DirectedEdge edge: graph.adjacenties(from)){

                relax(edge);
            }
        }
    }

    /**
     * 顶点的放松 如果w是通过v可到达，且w的距离大于v+v-w的权重，则更新到达w的边以及距离。
     * @param edge
     */
    private void relax(@NotNull DirectedEdge edge){
        int to = edge.to();
        int from = edge.from();
        if(distTo[to] > distTo[from] + edge.getWeight()){

            distTo[to] = distTo[from] + edge.getWeight();
            edgeTo[to] = edge;

            if(minPQ.contains(to)){ minPQ.decreaseKey(to, distTo[to]); }
            else{   minPQ.insert(to,distTo[to] );}
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
        for (int i = edgeTo[vertex].to(); i != this.start ; i= edgeTo[i].from()) {
            stack.push(edgeTo[i]);
        }
        return stack;
    }
}
