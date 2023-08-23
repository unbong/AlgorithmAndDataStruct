package neetcode150.graph;

import java.util.*;

public class CourceSchedule_207 {



    private final boolean CYCLE = false;
    private final int UNKNOWN = 0;
    private final int VISITED = 1;
    private final int VISITING = 2;


    /**
     * 该题的考点为是否存在环，在对图做拓扑排序的过程中没有发现环，则结果为true
     *
     *  拓扑排序的过程
     *      首先是准备用于记录是否已经访问或正在访问的额外数据集
     *      循环遍历所有节点，通过深度优先搜索的方法找到与起始节点相连的节点并
     *          在深度优先搜索的递归方法内，如果是已访问节点，则退回该搜索
     *              如果是正在访问的节点，则说明发现了环，
     *
     *              如果是未被访问的节点，继续递归的访问未访问节点的邻居节点。
     *
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        if (prerequisites == null) return false;
        if (prerequisites.length == 0) {
//            if (numCourses > 1)
//                return false;
//            else
                return true;
        }

        int[] mark = new int[numCourses];
        List<Integer> order = new ArrayList<>();
        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {

            if(!graph.containsKey(prerequisites[i][0]) ){
                List<Integer> edge = new ArrayList<>();
                edge.add(prerequisites[i][1]);
                graph.put(prerequisites[i][0],edge );
            }
            else{
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }

        for(Map.Entry<Integer,List<Integer>> entry : graph.entrySet())
        {
            if(dfs(graph, entry.getKey(), mark,order)==CYCLE) return false;
        }

        return true;
    }

    private boolean dfs(HashMap<Integer,List<Integer>>  graph, Integer source, int[] mark, List<Integer> order) {

        if(mark[source] == VISITED) return !CYCLE;
        if(mark[source] == VISITING) return CYCLE;
        mark[source] = VISITING;

        for (int i = 0; graph.containsKey(source) && i < graph.get(source).size() ; i++) {
            int neighbor = graph.get(source).get(i);
            if(dfs(graph, neighbor, mark, order) == CYCLE) return CYCLE;
        }

        mark[source] = VISITED;
        order.add(source);
        return !CYCLE;
    }
}
