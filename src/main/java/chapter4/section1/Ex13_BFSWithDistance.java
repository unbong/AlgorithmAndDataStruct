package chapter4.section1;

import chapter4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class Ex13_BFSWithDistance {

    private boolean marked[];
    private int edgeTo[];
    private int dist[];
    private int source;
    private int levelCount = 0;

    public Ex13_BFSWithDistance(Graph g, int s){
        source = s;
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        dist = new int[g.V()];

        bfs(g, s);
    }

    private void bfs(Graph g , int v){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);
        queue.enqueue(null);
        dist[v] = levelCount;
        levelCount++;
        while( !queue.isEmpty() ){
            Integer n = queue.dequeue();
            if(n == null){
                levelCount ++;
                if(!queue.isEmpty()) queue.enqueue(null);
                continue;
            }
            marked[n] = true;
            for(int w : g.adj(n)){
                if(!marked[w])
                {
                    edgeTo[w] = n;
                    dist[w] = levelCount;
                    marked[w] = true;
                    queue.enqueue(w);
                }

            }
        }
    }

    public boolean hasPathTo(int w){return marked[w];}

    public Iterable<Integer> pathTo(int w){
        if(!hasPathTo(w)) return null;
        Stack<Integer> stack = new Stack<>();
        for (int i = edgeTo[w]; i != source ; i = edgeTo[i]) {
            stack.push(i);
        }
        return stack;
    }

    public int distTo(int w){
        if(!hasPathTo(w)) return -1;
        return dist[w];
    }

}
