package neetcode150.graph;

public class GraphValidTree_261 {

    /**
     * 测试对图的掌握，将图的问题转化为并查集的方式检查图中是否有环
     *  过程如下，首先创建一个并查集并初始化，
     *  在遍历节点的过程中，能够将相连的节点标记为同一个集合
     *  在这个过程中，如果某一个几点已经属于某一个集合，并且再一次要将其放入集合中时说明，形成了一个环。
     *  如果所有边的遍历都结束说明不存在一个环。
     * @param n
     * @param edges
     * @return
     */
    public boolean    validTree(int n, int[][] edges) {

        int parent[] = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int[] edge: edges){
            int x = find(edge[0], parent);
            int y = find(edge[1], parent);

            if(x == y) return false;
            parent[x] = y;
        }
        return  true;

    }

    private int find(int i, int[] parent) {

        while(parent[i] != i){
            i = parent[i];
        }
        return parent[i];
    }
}
