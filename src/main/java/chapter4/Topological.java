package chapter4;

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

    public boolean isDAG(){return order != null;}

    public Iterable<Integer> order(){
        return order;
    }
}
