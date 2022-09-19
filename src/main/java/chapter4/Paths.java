package chapter4;

import edu.princeton.cs.algs4.Stack;

/**
 * 寻找路径
 */
public class Paths {
    private boolean marked[];
    private int edgeTo[];

    private final int s;
    public Paths(Graph g, int s){
        marked = new boolean[g.V()];
        edgeTo = new int[g.V()];
        this.s = s;
        dfs(g, s);
    }

    /**
     * 起点v的路径生成递归函数
     * @param g
     * @param v
     */
    private void dfs(Graph g, int v) {
        marked[v] = true;
        for(int w: g.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

    /**
     * v 与w是否存在路径
     * @param w
     * @return
     */
    public boolean haspathTo(int w){
        return marked[w];
    }

    /**
     * 返回v与w的路径。
     * @param w
     * @return
     *  当不存在路径时返回null。
     */
    public Iterable<Integer> pathTo(int w){

        if(!haspathTo(w)) return null;
        Stack<Integer> stack =new Stack<>();
        for (int i = edgeTo[w]; i != this.s; i = edgeTo[i]) {
            stack.push(i);
        }
        return stack;
    }

}
