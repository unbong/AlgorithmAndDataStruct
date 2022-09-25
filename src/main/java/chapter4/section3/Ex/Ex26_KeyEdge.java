package chapter4.section3.Ex;

import chapter1.section3.Queue;
import chapter4.section3.Edge;
import chapter4.section3.EdgeWeighedGraph;
import edu.princeton.cs.algs4.MinPQ;

public class Ex26_KeyEdge {

    private boolean[] marked;
    private MinPQ<Edge> pq;
    private Queue<Edge> keyEdges;

    public Ex26_KeyEdge(EdgeWeighedGraph g){
//        marked = new boolean[g.vertices()];
//        pq = new MinPQ<>();
//        keyEdges = new Queue<>();
//
//        visited(g, 0);
//        while(!pq.isEmpty())
//        {
//            Edge edge = pq.delMin();
//            int vertex =edge.eigher();
//            int other = edge.other(vertex);
//            if(marked[vertex]&& marked[other]) continue;
//            keyEdges.enqueue(edge);
//
//            while(edge.weight() == pq.min().weight())
//            {
//                keyEdges.enqueue(pq.delMin());
//            }
//
//            if(!marked[vertex]) visited(g, vertex);
//            if(!marked[other]) visited(g, other);
//        }

    }

    private void visited(EdgeWeighedGraph g, int vertex){
        marked[vertex] = true;
        for(Edge edge: g.adjacent(vertex))
        {
            pq.insert(edge);
        }
    }


    public Iterable<Edge> keyEdges(){
        return keyEdges;
    }

}
