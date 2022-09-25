package chapter4.section3.Ex;

import chapter1.section3.Queue;
import chapter4.Cycle;
import chapter4.section3.Edge;
import chapter4.section3.EdgeWeighedGraph;
import chapter4.section3.EdgeWeighedGraphWithDelete;
import edu.princeton.cs.algs4.ST;

import java.util.HashSet;
import java.util.Set;

public class Ex23_Vyssotsky {
    private Queue<Edge> mst;
    private double weight;
    private boolean[] marked;
    public Ex23_Vyssotsky(EdgeWeighedGraph g){

        marked = new boolean[g.vertices()];
        EdgeWeighedGraphWithDelete tmp = new EdgeWeighedGraphWithDelete(g.vertices());
        mst = new Queue<>();
        dfs(g, 0, tmp);

        // 加一条
        for (Edge e: g.edges())
        {
            tmp.addEdge(e);
            Cycle cycle = new Cycle(tmp);
            if(cycle.isHasCycle())
            {
                Edge maxWeithEdge = null ;
                double weight = Double.NEGATIVE_INFINITY;
                // 删除在环内的权重最大边
                for(Edge tmpE: cycle.cycleEdge()){
                    if(weight < tmpE.weight())
                    {
                        maxWeithEdge = tmpE;
                        weight = tmpE.weight();
                    }
                }
                tmp.deleteEdge(maxWeithEdge);
            }
        }

        //
        for(Edge e: tmp.edges()){
            mst.enqueue(e);
            weight+=e.weight();
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double getWeight(){return weight;}

    private void dfs(EdgeWeighedGraph g, int vertex, EdgeWeighedGraphWithDelete msfg){
        marked[vertex] = true;
        for(Edge e: g.adjacent(vertex)){
            int other = e.other(vertex);
            if(!marked[other]) {
                msfg.addEdge(e);
                dfs(g, other, msfg);

            }
        }
    }

}
