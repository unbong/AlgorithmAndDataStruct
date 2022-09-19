package chapter4;

import chapter1.section3.Stack;

public class Cycle {

    private boolean marked[];
    private int edgeTo[];
    private Stack<Integer> stack;
    private boolean hasCycle;

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

    public boolean hasSelfLoop(){
        return hasCycle;
    }

    private void dfs(Graph g, int v, int u){
        marked[v]=true;
        for (int w: g.adj(v))
        {
            if(u ==w) hasCycle = true;
            marked[w] = true;
            dfs(g,w,v);
        }
    }

    public boolean isHasCycle(){return hasCycle;}
}
