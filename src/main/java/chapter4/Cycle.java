package chapter4;


import chapter4.section3.Edge;

import chapter4.section3.EdgeWeighedGraphWithDelete;
import edu.princeton.cs.algs4.Stack;

public class Cycle {

    private boolean marked[];
    private int edgeTo[];
    private Stack<Integer> cycle;

    private Stack<Edge> cycleEdge;
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

    public Cycle(EdgeWeighedGraphWithDelete g){
        marked = new boolean[g.vertices()];
        edgeTo = new int[g.vertices()];
        for(int w = 0; w < g.vertices(); w++)
        {
            if(!marked[w]){
                dfs(g,w,w);
            }
        }
    }

    private void dfs(EdgeWeighedGraphWithDelete g, int u, int v){
        marked[v] = true;

        for (Edge e: g.adjacent(v))
        {
            int other = e.other((v));
            if(cycle != null) return;
            if(!marked[other])
            {
                edgeTo[other] = v;

                dfs(g, v, other);
            }
            else if(other != u){
                cycle = new Stack<Integer>();
                cycleEdge = new Stack<>();
                for (int x = v; x != other; x = edgeTo[x]) {
                    for(Edge eg : g.adjacent(x)){
                        if(eg.other(x) == edgeTo[x])
                            cycleEdge.push(eg);
                    }
                    cycle.push(x);
                }
                for(Edge eg: g.adjacent(v))
                {
                    if(eg.other(v) == other)
                    cycleEdge.push(eg);
                }

                cycle.push(other);
                cycle.push(v);

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

    public Iterable<Integer> cycle(){
        return cycle;
    }

    public Iterable<Edge> cycleEdge(){
        return cycleEdge;
    }

}
