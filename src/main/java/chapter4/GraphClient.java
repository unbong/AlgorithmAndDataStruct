package chapter4;

public class GraphClient {

    /**
     * 计算v的度数
     * @param g
     * @param v
     * @return
     */
    public static int degree(Graph g, int v)
    {
        int degree = 0;
        for(int w: g.adj(v)) degree++;
        return degree;
    }

    /**
     * 计算最大度数
     * @param g
     * @return
     */
    public static int maxDegree(Graph g){
        int max = 0;
        for(int v = 0; v < g.V(); v++){
            if(degree(g, v) >max)
                max = degree(g, v);
        }
        return max;
    }

    /**
     * 计算所有顶点的平均度数
     * @param g
     * @return
     */
    public static double avgDegree(Graph g){
        return 2.0*g.E() / g.V();
    }


    public static int numberOfSelefLoops(Graph g)
    {
        int count = 0;
        for (int v = 0; v < g.V(); v++) {
            for (int w : g.adj(v)) {
                if(v == w) count++;
            }
        }
        return count/2;
    }
}
