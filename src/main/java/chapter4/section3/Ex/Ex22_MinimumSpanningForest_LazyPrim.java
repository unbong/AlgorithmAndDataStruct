package chapter4.section3.Ex;

import chapter1.section3.Queue;
import chapter4.ConnectedComponent;
import chapter4.section3.Edge;
import chapter4.section3.EdgeWeighedGraph;
import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.List;

/**
 * 最小生成森林
 */
public class Ex22_MinimumSpanningForest_LazyPrim {

    private Queue<Edge> mst ;
    private List<Queue<Edge>> msf;
    private boolean[] marked;
    private MinPQ<Edge> pq;


    public Ex22_MinimumSpanningForest_LazyPrim(EdgeWeighedGraph g){

        // 确认连通分量
        ConnectedComponent cc = new ConnectedComponent(g);
        msf = new ArrayList<>();
        for (int i = 0; i < cc.count(); i++) {
            mst = new Queue<>();
            marked = new boolean[g.vertices()];
            pq = new MinPQ<>();
            int start = 0;
            for (int j = 0; j < g.vertices(); j++) {
                if(i == cc.id(j)){
                    start = j;
                    break;
                }
            }
            visited(g,start);
            while(!pq.isEmpty()){
                Edge edge = pq.delMin();
                int v = edge.eigher();
                int other = edge.other(v);
                if(marked[v] && marked[other]) continue;
                mst.enqueue(edge);
                if(!marked[v]) visited(g,v);
                if(!marked[other]) visited(g, other);

            }

            msf.add(mst);
        }
    }

    private void visited(EdgeWeighedGraph g, int vertex){
        marked[vertex] = true;
        for (Edge e: g.adjacent(vertex))
        {
            int other = e.other(vertex);
            if(!marked[other]) pq.insert(e);
        }
    }

    public List<Queue<Edge>> edges(){
        return msf;
    }

}
