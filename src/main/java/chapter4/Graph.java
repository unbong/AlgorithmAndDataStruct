package chapter4;

import chapter1.section3.Bag;
import chapter1.section3.Stack;
import edu.princeton.cs.algs4.In;

import java.util.NoSuchElementException;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    /**
     * 创建大小为v的顶点数组，没有边
     * @param v
     */
    public Graph(int v){
        if(v<0) throw new IllegalArgumentException("v must be positive");
        V = v;
        E = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Bag<>();
        }
    }

    public Graph(String stream, String delim){
        In in = new In(stream);



        V = in.readInt();
        E = in.readInt();
        adj = (Bag<Integer>[]) new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
        in = new In(stream);
        while(in.hasNextLine()){
            String keys[] = in.readLine().split(delim);
            int key = Integer.valueOf(keys[0]);
            for (int i = 1; i < keys.length; i++) {
                adj[key].add(i);
            }
        }
    };

    public Graph(In in){
        if(in == null) throw new IllegalArgumentException("argument is null.");

        try{
            int v = in.readInt();
            if(v <0) throw new IllegalArgumentException("v must be positive.");
            V = v;
            adj = (Bag<Integer> []) new Bag[V];
            for (int i = 0; i < V; i++) {
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

    public Graph(Graph G){
        V =G.V();
        adj = (Bag<Integer>[]) new Bag[V];
        E = G.E();

        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<>();
        }
        
        
        for (int i = 0; i < V; i++) {
            Stack<Integer> stack = new Stack<>();
            for(int w: G.adj(i)) {
                stack.push(w);
            }

            for(int w: stack)
            {
                adj[i].add(w);
            }
        }
    }

    /**
     * 返回v-w是否含有边
     * @param v
     * @param w
     * @return
     */
    public boolean hasEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        boolean hasEdge = false;
        for (int i :adj[v]) {
            if(i == w) return true;
        }
        return hasEdge;
    }

    /**
     * 返回顶点数
     * @return
     */
    public int V(){
        return V;
    }

    /**
     * 返回边数
     * @return
     */
    public int E(){
        return E;
    }

    /**
     * 添加一条边v-w
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
        E++;

    }

    /**
     * 返回与v邻接的顶点
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();

    }

    private void validateVertex(int v) {
        if(v<0 || v> V-1 ) throw new NoSuchElementException("v is valid.");
    }

    public static void main(String[] args) {

    }
}
