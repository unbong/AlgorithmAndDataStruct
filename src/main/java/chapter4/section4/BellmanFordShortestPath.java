package chapter4.section4;

import chapter1.section3.Queue;
import chapter1.section3.Stack;
import chapter4.Graph;

/**
 * BellmanFord最短路径
 */
public class BellmanFordShortestPath {

    private double[] distTo;
    private DirectedEdge[] edgeTo;
    private Queue<Integer> queue;
    private boolean[] onQueue;
    private int count;
    private Iterable<DirectedEdge> cycle;

    private static final double EPSILON = 1E-14;

    public BellmanFordShortestPath(EdgeWeightedDigraph graph, int start){

        distTo = new double[graph.vertex()];            // 与起始顶点的距离
        validateVertex(start);
        edgeTo = new DirectedEdge[graph.vertex()];      // 起始顶点到某个顶点的最后一条边
        queue = new Queue<>();                          // 正在被放松的顶点
        onQueue = new boolean[graph.vertex()];          // 该顶点是否存在与队列中，
        for (int i = 0; i < graph.vertex(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        distTo[start] = 0.0;

        queue.enqueue(start);
        onQueue[start] = true;

        // 起始顶点开始放松
        while (!queue.isEmpty() && !hasNegativeCycle())
        {
            int vertex = queue.dequeue();
            onQueue[vertex] = false;
            relax(graph, vertex);
        }
    }

    private void relax(EdgeWeightedDigraph graph, int vertex) {

        // 放松vertex顶点的邻居。
        for(DirectedEdge edge: graph.adjacenties(vertex))
        {
            int to = edge.to();
            // 这里是关键，如果存在负的边，且没有形成负有向环时，根据下面的计算，会对负有向边的起始顶点相关的其他顶点也会进行一次重新的计算。
            if(distTo[to]> distTo[vertex] + edge.getWeight()+EPSILON) {
                distTo[to] = distTo[vertex] + edge.getWeight();
                edgeTo[to] = edge;
                if(!onQueue[to]) {
                    queue.enqueue(to);
                    onQueue[to] = true;
                }
            }

            // 当循环的此时达到顶点的倍数时，如果由负有向环，则在edgeTo中会存在环。
            if(++count % graph.vertex() ==0 ){
                findNegativeCycle();
                if(hasNegativeCycle()) return;
            }
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

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    private void findNegativeCycle() {
        int vertex = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(vertex);
        for (int i = 0; i < vertex; i++) {
            if(edgeTo[i] != null)
                spt.addEdge(edgeTo[i]);
        }
        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(spt);
        cycle = finder.cycle();

    }

    private void validateVertex(int vertex){
        if(vertex< 0 || vertex> distTo.length-1) throw new IllegalArgumentException("vertex is invalid.");
    }


}
