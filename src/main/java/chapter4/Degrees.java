package chapter4;

import chapter1.section3.Queue;

/**
 * 出度为0的顶点为"终点"
 * 入度为0的顶点为"起点"
 * 一幅允许出现自环且每个顶点的出度均为1的有向图叫"映射"
 *
 */
public class Degrees {

    private int[] indegree;
    private int[] outdegree;

    public Degrees(Digraph dg){
        indegree = new int[dg.vertex()];
        outdegree = new int[dg.vertex()];

        for (int i = 0; i < dg.vertex(); i++) {
            for(int vertex: dg.adjacent(i))
            {
                indegree[vertex] = indegree[vertex]+1;
                outdegree[i] =outdegree[i]+1;
            }
        }
    }

    /**
     * 顶点的入度
     * @param vertex    顶点
     * @return          顶点的入度
     */
    public int indegree(int vertex){
        return indegree[vertex];
    }

    /**
     * 顶点的出度
     * @param vertex
     * @return
     */
    public int outdegree(int vertex){
        return outdegree[vertex];
    }

    /**
     * 所有起点的集合
     * @return
     */
    public Iterable<Integer> sources(){
        Queue<Integer> sources = new Queue<>();

        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) sources.enqueue(i);
        }
        return  sources;
    }

    /**
     * 所有终点的集合
     * @return
     */
    public Iterable<Integer> sinks()
    {
        Queue<Integer> sinks= new Queue<>();
        for (int i = 0; i < outdegree.length; i++) {
            if(outdegree[i] == 0) sinks.enqueue(i);
        }

        return sinks;
    }

    /**
     * 是否为映射
     * @return
     */
    public boolean isMap() {
        for (int i = 0; i < outdegree.length; i++) {
            if(outdegree[i] != 1) return false;
        }
        return true;
    }
}
