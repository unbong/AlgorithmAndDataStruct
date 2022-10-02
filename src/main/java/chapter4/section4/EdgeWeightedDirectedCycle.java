package chapter4.section4;


import chapter1.section3.Stack;

public class EdgeWeightedDirectedCycle {

    private boolean[] marked;
    private DirectedEdge[] edgeTo;
    private boolean[] onStack;
    private Stack<DirectedEdge> cycle;

    public EdgeWeightedDirectedCycle(EdgeWeightedDigraph graph){
        marked = new boolean[graph.vertex()];
        edgeTo = new DirectedEdge[graph.vertex()];
        onStack = new boolean[graph.vertex()];

        for (int i = 0; i < graph.vertex(); i++) {
            if(!marked[i] )
            {
                dfs(graph, i);
            }
        }
    }

    private void dfs(EdgeWeightedDigraph g, int vertex){
        marked[vertex] = true;
        onStack[vertex] = true;

        for (DirectedEdge edge: g.adjacenties(vertex)){
            int to = edge.to();
            if(hasCycle()) return;
            if(!marked[to]){
                edgeTo[to] = edge;
                dfs(g, to);
            }
            else if(onStack[to])
            {
                cycle = new Stack<>();
                DirectedEdge f = edge;
                while(f.from() != to){
                    cycle.push(f);
                    f= edgeTo[f.from()];
                }
                cycle.push(f);
                return;
            }
        }

        onStack[vertex] = false;
    }

    public Iterable<DirectedEdge> cycle(){
        return cycle;
    }

    public boolean hasCycle(){ return cycle != null;}
}
