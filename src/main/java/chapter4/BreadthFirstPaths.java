package chapter4;

import chapter1.section3.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean marked[];
    private final int s;
    private int edgeTo[];

    private int dist[];

    public BreadthFirstPaths(Graph g, int s){
        this.s = s;
        marked= new boolean[g.V()];
        edgeTo = new int[g.V()];
        dist = new int[g.V()];
        bfs(g, s);
    }

    /**
     * 广度优先的方法生成顶点v的路径
     * @param g
     * @param v
     */
    private void bfs(Graph g, int v) {

        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < g.V(); i++) {
            dist[i] = INFINITY;
        }
        queue.enqueue(v);
        marked[v] = true;
        dist[v]  = 0;
        while(!queue.isEmpty()){
            Integer wq = queue.dequeue();
            for (int ws : g.adj(wq)){
                if(!marked[ws]){
                    marked[ws] = true;
                    edgeTo[ws] = wq;
                    dist[ws] = dist[wq] +1;
                    queue.enqueue(ws);
                }
            }
        }
    }


    public int distTo(int w){return dist[w];}

    /**
     * v-w是否存在路径
     * @param w
     * @return
     */
    public boolean hasPathTo(int w){
        return marked[w];
    }

    /**
     * v-w的路径
     * @param w
     * @return
     */
    public Iterable<Integer> pathTo(int w){
        if(!hasPathTo(w)) return null;
        Queue<Integer> queue = new Queue<>();
        for (int i = edgeTo[w]; i != this.s ; i=edgeTo[i]) {
            queue.enqueue(i);
        }

        return queue;
    }

    public static void main(String[] args) {
        In in = new In("src/test/resources/tinyG.txt");

        Graph g = new Graph(in);

        //StdOut.print(g.toString());
        BreadthFirstPaths ex = new BreadthFirstPaths(g, 0);

        StdOut.print(ex.distTo(3));
        StdOut.println("");
        for(int v : ex.pathTo(3))
        {
            StdOut.println(v);
        }
    }
}
