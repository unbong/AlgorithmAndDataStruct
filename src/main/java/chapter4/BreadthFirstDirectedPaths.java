package chapter4;


import chapter1.section3.Queue;
import chapter1.section3.Stack;

/**
 * 广度优先路径
 */
public class BreadthFirstDirectedPaths {

    private boolean marked[];
    private int edgeTo[];
    private int dist[];
    private final int source;

    public BreadthFirstDirectedPaths(Digraph dg, int source){
        this.source = source;
        marked = new boolean[dg.vertex()];
        edgeTo = new int[dg.vertex()];
        dist = new int[dg.vertex()];

        dfs(dg, source);
    }

    private void dfs(Digraph dg, int source){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(source);
        marked[source] =true;
        while(!queue.isEmpty())
        {
            Integer vertex = queue.dequeue();
            for(int neighbor: dg.adjacent(vertex))
            {
                if(!marked[neighbor])
                {
                    edgeTo[neighbor] = vertex;
                    dist[neighbor] = dist[vertex]+1;
                    marked[neighbor] = true;
                    queue.enqueue(neighbor);
                }

            }
        }
    }

    public int distTo(int vertex){
        return dist[vertex];
    }

    public int edgeTo(int vertex){
        return edgeTo[vertex];
    }

    public boolean hasPathTo(int vertex){
        return marked[vertex];
    }

    public Iterable<Integer> pathTo(int vertex){
        if(!hasPathTo(vertex))
        {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = vertex ; i != this.source; i= edgeTo[i])
        {
            stack.push(i);
        }
        stack.push(this.source);
        return stack;
    }
}
