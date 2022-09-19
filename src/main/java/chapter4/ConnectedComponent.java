package chapter4;

public class ConnectedComponent {

    private boolean marked[];
    private int id[];
    private int count;


    public ConnectedComponent(Graph g) {
        count = 0;
        marked = new boolean[g.V()];
        id = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!marked[i]) {
                dfs(g, i);
                count++;
            }
        }
    }

    /**
     *  深度优先的方式生成连通分量。
     * @param g
     * @param v
     */
    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if(!marked[w]){
                dfs(g,w);
            }
        }
    }

    /**
     * v-w　是否连通
     * @param v
     * @param w
     * @return
     */
    public boolean connected(int v, int w){
        return id[w] == id[v];
    }

    /**
     * 连通分量数
     *
     * @return
     */
    public int count(){
        return count;
    }

    /**
     * v 所在连通分量标识符号
     * @param v
     * @return
     */
    public int id(int v){
        return id[v];
    }

}