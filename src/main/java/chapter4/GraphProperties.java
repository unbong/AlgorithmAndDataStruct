package chapter4;

public class GraphProperties {

    private int eccentricity[];
    private int diameter;
    private int radius;
    private int center;
    private int grith;

    public GraphProperties(Graph g)
    {
        ConnectedComponent cc = new ConnectedComponent(g);
        if(cc.count() != 1) throw new IllegalStateException("not connected.");
        eccentricity = new int[g.V()];
    }

    private void getProperties(Graph g)
    {
        radius = Integer.MIN_VALUE;
        for (int i = 0; i < g.V(); i++) {
            BreadthFirstSearch bfs = new BreadthFirstSearch(g, i);

            for (int j = 0; j < g.V(); j++) {
                if(i == j) continue;

                eccentricity[i] =Math.max(bfs.distTo(j), eccentricity[i]);
            }

            if(radius > eccentricity[i])
            {
                radius = eccentricity[i];
                center = i;
            }

            if(diameter < eccentricity[i])
                diameter = eccentricity[i];

        }

    }

    /**
     * w 的离心率
     * @param w
     * @return
     */
    public int eccentricity(int w){return eccentricity[w];}

    /**
     * G的直径 最大离心率
     * @return
     */
    public int diameter(){return diameter;}

    /**
     * G的半径 最小离心率
     * @return
     */
    public int radius(){return radius;}

    /**
     * G的某个终点
     * @return
     */
    public int center(){return center;}

}
