package chapter4;


/**
 * 传递闭环
 */
public class TransitiveClosure {

    private DepthFirstDirectedPaths[] allVerticesDFS;
    public TransitiveClosure(Digraph dg){
        allVerticesDFS = new DepthFirstDirectedPaths[dg.vertex()];

        for(int vertex = 0; vertex < dg.vertex(); vertex++){
            allVerticesDFS[vertex] = new DepthFirstDirectedPaths(dg, vertex);
        }
    }

    public boolean reachable(int vertex1, int vertex2){
        return allVerticesDFS[vertex1].marked(vertex2);
    }
}
