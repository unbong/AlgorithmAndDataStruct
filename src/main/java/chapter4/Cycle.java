package chapter4;

import chapter1.section3.Stack;

public class Cycle {

    private boolean marked[];
    private int edgeTo[];
    private Stack<Integer> cycle;
    public Cycle(Graph g){

        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        for(int w = 0; w < g.V(); w++)
        {
            if(!marked[w]){
                dfs(g,w,w);
            }
        }
    }


    private void dfs(Graph G, int u, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {

            // short circuit if cycle already found
            if (cycle != null) return;

            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, v, w);
            }

            // check for cycle (but disregard reverse of edge leading to v)
            else if (w != u) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }

    public boolean isHasCycle(){return cycle != null;}
}
