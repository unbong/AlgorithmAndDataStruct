package chapter4;

import chapter1.section3.Stack;

/**
 * 检测环
 */
public class DirectedCycle {

    private boolean marked[];
    private Stack<Integer> cycle;
    private int edgeTo[];
    private boolean onStack[];

    public DirectedCycle(Digraph dg)
    {
        marked = new boolean[dg.vertex()];
        edgeTo = new int[dg.vertex()];
        onStack = new boolean[dg.vertex()];
        for(int i = 0 ; i < dg.vertex(); i++)
        {
            if(!marked[i])
                dfs(dg, i);
        }

    }

    /**
     * 深度优先的方法，当存在环被标记的顶点且是调用栈中的顶点时即判定为环
     * @param dg
     * @param source
     */
    private void dfs(Digraph dg, int source){
        marked[source] = true;
        onStack[source] = true;
        for(int neighbor : dg.adjacent(source))
        {
            if(hasCycle()) return;
            if(!marked[neighbor])
            {
                edgeTo[neighbor] = source;
                dfs(dg, neighbor);
            }
            else if(onStack[neighbor])
            {
                cycle = new Stack<>();
                for(int currentVertex = source ; currentVertex != neighbor;currentVertex = edgeTo[currentVertex]){
                    cycle.push(currentVertex);
                }
                cycle.push(neighbor);
                cycle.push(source);

            }
        }
        onStack[source] = false;
    }

    public boolean hasCycle() {return  cycle != null;}

    public Iterable<Integer> cycle(){
        return cycle;
    }
}
