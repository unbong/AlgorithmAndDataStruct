package chapter4;

import chapter4.section3.Edge;
import chapter4.section3.EdgeWeighedGraph;

public class ConnectedComponent {

    private boolean marked[];
    private int id[];
    private int count;


    public ConnectedComponent(EdgeWeighedGraph g){

        marked = new boolean[g.vertices()];
        id = new int[g.vertices()];

        for (int i = 0; i < g.vertices(); i++) {
           if(!marked[i]) {
               dfs(g, i);
               count++;
           }
        }
    }

    private void dfs(EdgeWeighedGraph g, int vertex){
        marked[vertex] = true;
        id[vertex] = count;
        for (Edge edge: g.adjacent(vertex)){
            int other = edge.other(vertex);
            if( !marked[other]) {
                dfs(g, other);
            }
        }
    }

    public ConnectedComponent(Graph g) {
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