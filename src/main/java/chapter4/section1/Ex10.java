package chapter4.section1;

import chapter1.section3.Queue;
import chapter4.Graph;

public class Ex10 {

    private boolean marked[];
    private Queue<Integer> queue = new Queue<>();

    public Ex10(Graph g, int v){
        marked = new boolean[g.V()];
        dfs(g,v);
    }


    private void dfs(Graph g, int v){
        boolean candel = true;
        marked[v] = true;
        for(int w: g.adj(v)){
            if(!marked[w])
            {
                //marked[w] = true;
                candel = false;
                dfs(g,w);
            }
        }
        if(candel)
        {
            queue.enqueue(v);
        }
    }

    public Iterable<Integer> canDeleteVertex()
    {
        return queue;
    }
}
