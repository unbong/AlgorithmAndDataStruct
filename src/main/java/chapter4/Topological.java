package chapter4;

import chapter4.section4.EdgeWeightedDigraph;
import chapter4.section4.EdgeWeightedDirectedCycle;

/**
 * 拓扑排序
 */
public class Topological {

    private Iterable<Integer> order;
    public Topological(Digraph dg)
    {
        // 当图中存在环时停止，因为拓扑排序的充要条件为无环
        DirectedCycle directedCycle = new DirectedCycle(dg);
        if(directedCycle.hasCycle())
        {
            return;
        }

        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(dg);
        // 当无环时深度优先排序的逆后续排序结果的拓扑排序
        order = depthFirstOrder.reversePost();
    }

    public Topological(EdgeWeightedDigraph g){

        EdgeWeightedDirectedCycle cycle = new EdgeWeightedDirectedCycle(g);
        if( cycle.hasCycle()) return;

        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(g);
        order = depthFirstOrder.reversePost();
    }

    /**
     * 是否为无环加权图
     * @return
     */
    public boolean isDAG(){return order != null;}

    public Iterable<Integer> order(){
        return order;
    }
}
