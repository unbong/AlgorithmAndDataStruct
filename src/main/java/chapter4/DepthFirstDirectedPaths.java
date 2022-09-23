package chapter4;

/**
 * 深度优先搜索
 */
public class DepthFirstDirectedPaths {
    private boolean marked[];
    public DepthFirstDirectedPaths(Digraph dg, int source){

        validateVertex(source);
        marked = new boolean[dg.vertex()];
        for(int w: dg.adjacent(source)) {
            dfs(dg, w);
        }
    }

    public DepthFirstDirectedPaths(Digraph dg, Iterable<Integer> sources){
        marked = new boolean[dg.vertex()];
        for(int w : sources){
            if( !marked[w]) dfs(dg, w);
        }
    }

    /**
     * source到vertex是否可达？
     *
     * @param vertex
     * @return
     */
    public boolean marked(int vertex){
        return marked[vertex];
    }

    private void dfs(Digraph dg, int source){
        marked[source] = true;
        for(int w: dg.adjacent(source)){
            if(!marked[w]) dfs(dg, w);
        }
    }
    private void validateVertex(int vertex){
        if(vertex <0 || vertex > marked.length-1 ){ throw new IllegalArgumentException("vertex is invalid.");}
    }
}
