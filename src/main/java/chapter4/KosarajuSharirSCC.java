package chapter4;

/**
 * Kosaraju算法
 * 生成有向图中的强连通分量
 */
public class KosarajuSharirSCC {

    private int id[];
    private int count;
    private boolean marked[];
    public KosarajuSharirSCC(Digraph dg){
        id = new int[dg.vertex()];
        marked = new boolean[dg.vertex()];
        DepthFirstOrder dfo = new DepthFirstOrder(dg.reverse());
        for(int currentVertex: dfo.reversePost())
        {
            if(!marked[currentVertex]) {
                dfs(dg, currentVertex);
                count++;
            }
        }
    }

    private void dfs(Digraph dg, int source){
        marked[source] = true;
        id[source] = count;
        for (int neighbor:dg.adjacent(source))
        {
            if(!marked[neighbor])
            {
                dfs(dg, neighbor);
            }
        }
    }

    /**
     * 是否强连通？
     * @param source
     * @param dest
     * @return
     */
    public boolean stronglyConnected(int source , int dest){
        return id[source] == id[dest];
    }

    public int id(int vertex){
        return id[vertex];
    }

    public int count(){return count;}
}
