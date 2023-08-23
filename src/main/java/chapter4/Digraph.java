package chapter4;

import chapter1.section3.Bag;
import chapter1.section3.Stack;
import edu.princeton.cs.algs4.In;

import java.util.NoSuchElementException;

/**
 * 有向图
 */
public class Digraph {

    private int vertex;
    private int edge;
    private Bag<Integer> adjacent[];

    public Digraph(int vertex){
        this.vertex = vertex;
        adjacent = (Bag<Integer>[]) new Bag[vertex];
        for (int i = 0; i < vertex; i++) {
            adjacent[i] = new Bag<>();
        }
    }

    public Digraph(Digraph dg){
        vertex = dg.vertex();
        adjacent = (Bag<Integer>[]) new Bag[vertex];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < vertex; i++) {
            adjacent[i] = new Bag<>();
            for (int neighbor: dg.adjacent(i)){
                stack.push(neighbor);
            }

            while(!stack.isEmpty()){
                addEdge(i, stack.pop());
            }
        }
    }
    public Digraph(In in){
        if(in == null) throw new IllegalArgumentException("argument is null.");

        try{
            int v = in.readInt();
            if(v <0) throw new IllegalArgumentException("v must be positive.");
            vertex = v;
            adjacent = (Bag<Integer> []) new Bag[vertex];
            for (int i = 0; i < vertex; i++) {
                adjacent[i] = new Bag<>();
            }

            int E = in.readInt();
            if(E<0 ) throw new IllegalArgumentException("E must be positive.");
            for (int i = 0; i < E; i++) {
                int s = in.readInt();
                int w = in.readInt();

                addEdge(s,w );
            }

        }catch (NoSuchElementException e){
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    public int vertex(){return vertex;}

    public int edge(){return edge;}

    public void addEdge(int source, int dest){
        validateVertex(source);
        validateVertex(dest);

        adjacent[source].add(dest);
        edge++;
    }

    public Iterable<Integer> adjacent(int v){
        validateVertex(v);
        return adjacent[v];
    }

    /**
     * 返回反向图
     * @return
     */
    public Digraph reverse(){

        Digraph digraph = new Digraph(vertex);
        for (int i = 0; i < vertex; i++) {
            for(int w : adjacent[i]){
                digraph.addEdge(w, i);
            }
        }

        return digraph;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int vertex = 0; vertex < this.vertex; vertex++) {
            stringBuilder.append(vertex).append(": ");

            for (int neighbor : adjacent(vertex)) {
                stringBuilder.append(neighbor).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public boolean hasEdge(int source, int dest){
        validateVertex(source);
        validateVertex(dest);

        for(int vertex : adjacent[source]){
            if(vertex == dest) return true;
        }
        return false;
    }

    private void validateVertex(int v){
        if(v<0 || v>vertex-1) throw new IllegalArgumentException("v is invalid.");
    }
}
