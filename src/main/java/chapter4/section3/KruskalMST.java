package chapter4.section3;

import chapter1.section3.Queue;
import chapter2.PriorityQueue;
import edu.princeton.cs.algs4.QuickFindUF;
import edu.princeton.cs.algs4.UF;

public class KruskalMST {

    private Queue<Edge> mst;                    // 最小生成树的边
    private double weight;

    public KruskalMST(EdgeWeighedGraph graph)
    {
        mst = new Queue<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(PriorityQueue.Orientation.MIN);   // 权重从小到大的所有边。
        for(Edge e: graph.edges()) pq.insert(e);
        QuickFindUF uf = new QuickFindUF(graph.vertices());                             // 最小生成森林的顶点集合 用于判断是否已经加入到最小生成树中

        while(!pq.isEmpty() && mst.getSize() < graph.vertices()-1)
        {
            Edge e = pq.pop();                              // 取得边
            int vertex = e.eigher();
            int other = e.other(vertex);
            if(uf.connected(vertex, other)) continue;       // 如果两个顶点已经连接，则表明两个顶点的权重最小的边已经加到了最小生成森林或树中。
            mst.enqueue(e);
            weight += e.weight();
            uf.union(vertex,other);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        return weight;
    }
}
