package chapter4;

public class DepthFirstSearch {

    private boolean[] marked;
    private int count;

    /**
     * 深度优先搜索构造函数
     * @param g
     * @param s
     */
    public DepthFirstSearch(Graph g, int s){
        marked = new boolean[g.V()];
        dfs(g,s);
    }

    /**
     * 深度优先搜索递归函数。
     * @param g
     * @param v
     */
    private void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for(int w: g.adj(v)) {
            if(!marked[w])
                dfs(g,w);
        }
    }

    /**
     * s与v是否连通
     * @param s
     * @return
     */
    public boolean marked(int s){
        return marked[s];
    }

    /**
     * 与v相连通的顶点数。
     * @return
     */
    public int count(){
        return count;
    }
}
