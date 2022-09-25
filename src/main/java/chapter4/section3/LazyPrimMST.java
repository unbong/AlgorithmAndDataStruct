package chapter4.section3;

import chapter1.section3.Queue;
import chapter2.PriorityQueue;

/**
 * Prim算法的延时实现
 */
public class LazyPrimMST {

    private double weight;
    private boolean marked[];           // 最小生成树的顶点

    private PriorityQueue<Edge> pq;     // 保存所有与最小生成树连接的横切边
    private Queue<Edge>  mst;           // 最小生成书的边

    public LazyPrimMST(EdgeWeighedGraph graph){
        marked = new boolean[graph.vertices()];
        pq = new PriorityQueue<>(PriorityQueue.Orientation.MIN);
        mst = new Queue<>();

        visted(graph, 0);
        while(!pq.isEmpty()){
            Edge edge = pq.pop();                           // 从优先队列中取得边。
            int vertex = edge.eigher();                     // 取得顶点
            int other = edge.other(vertex);
            if(marked[vertex] && marked[other]) continue;   // 如果两个顶点已经加到最小生成树中，则返回

            mst.enqueue(edge);                              // 将权重最小的边加到最小生成树中
            weight += edge.weight();
            if(!marked[vertex])                             //
                visted(graph, vertex);
            if(!marked[other])
                visted(graph, other);

        }
}


    private void visted(EdgeWeighedGraph graph, int vertex){

        marked[vertex] = true;
        for(Edge edge: graph.adjacent(vertex))
        {
            if(!marked[edge.other(vertex)])pq.insert(edge);
        }
    }

    /**
     * 最小生成树的所有边
     * @return
     */
    public Iterable<Edge> edges(){
        return mst;
    }

    /**
     * 最小生成树的权重
     * @return
     */
    public double weight(){

        return weight;
    }
}
