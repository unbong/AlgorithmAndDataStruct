package chapter4.section1;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;

import java.util.NoSuchElementException;

public class Ex5_GraphWithNoSelfLoopParallelEdge {

    private static final String NEWLINE = System.getProperty("line.separator");
    private int vertex;
    private int edge;
    private Bag<Integer> adj[];

    public Ex5_GraphWithNoSelfLoopParallelEdge(int v){
        if(v<0) throw new IllegalArgumentException("v must be positive");
        this.vertex = v;
    }

    public Ex5_GraphWithNoSelfLoopParallelEdge(In in){
        if(in == null) throw new IllegalArgumentException("argument is null.");

        try{
            int v = in.readInt();
            if(v <0) throw new IllegalArgumentException("v must be positive.");
            vertex = v;
            adj = (Bag<Integer>[]) new Bag[vertex];
            for (int i = 0; i < vertex; i++) {
                adj[i] = new Bag<>();
            }

            int E = in.readInt();
            if(E<0 ) throw new IllegalArgumentException("E must be positive.");
            for (int i = 0; i < E; i++) {
                int s = in.readInt();
                int w = in.readInt();
                validateVertex(s);
                validateVertex(w);
                addEdge(s,w );
            }

        }catch (NoSuchElementException e){
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    private void validateVertex(int v){
        if(v < 0 || v > vertex-1) throw new NoSuchElementException("v is invalid.");
    }

    public void addEdge(int v, int w)
    {
        if(v != w && ! hasEdge(v,w )){
            adj[v].add(w);
            adj[w].add(v);
            edge++;
        }
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(vertex + " vertices, " + edge + " edges " + NEWLINE);
        for (int v = 0; v < vertex; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();

    }

    public boolean hasEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        for(int i: adj[v]){
            if(i == w ) return true;
        }
        return false;
    }

    public int V(){
        return vertex;
    }


    public int E(){
        return edge;
    }

    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }

}
