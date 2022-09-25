package chapter4.section3;

import chapter1.section3.Bag;
import chapter1.section3.Queue;
import edu.princeton.cs.algs4.In;

import java.util.NoSuchElementException;

public class EdgeWeighedGraph {

    private static final String NEW_LINE = System.getProperty("line.separator");
    private final int vertices;
    private int edges;
    private Bag<Edge>[] adjacent;

    public EdgeWeighedGraph(int v){
        vertices = v;
        adjacent = (Bag<Edge>[]) new Bag[v];
        for (int i = 0; i < v; i++) {
            adjacent[i] = new Bag<Edge>();
        }
    }

    public EdgeWeighedGraph(In in){
        if(in == null) throw new IllegalArgumentException("in is null");

        try{
            int v = in.readInt();
            if(v<0) throw new IllegalArgumentException("v is invalid.");

            vertices = v;
            adjacent = (Bag<Edge>[]) new Bag[v];
            for (int i = 0; i < v; i++) {
                adjacent[i] = new Bag<>();
            }

            int e = in.readInt();
            if(e < 0) throw new IllegalArgumentException("e is invalid.");
            for (int i = 0; i < e; i++) {
                int s = in.readInt();
                int w = in.readInt();
                validateVertx(s);
                validateVertx(w);
                double weight = in.readDouble();
                addEdge(new Edge(s,w,weight));
            }

        }catch (NoSuchElementException e){
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    public int vertices(){return vertices;}

    public int getEdges() {return edges;}

    public void addEdge(Edge edge){
        int vertex = edge.eigher();
        int other = edge.other(vertex);
        adjacent[vertex].add(edge);
        adjacent[other].add(edge);
        edges++;
    }


    public Iterable<Edge> edges(){
        Queue<Edge> queue = new Queue<>();
        for (int i = 0; i < vertices; i++) {
            for(Edge e: adjacent[i])
            {
                queue.enqueue(e);
            }
        }
        return queue;
    }

    public Iterable<Edge> adjacent(int vertex){
        validateVertx(vertex);

        return adjacent[vertex];
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("vertex: %d, edge: %d %s", vertices, edges, NEW_LINE));
        for (int i = 0; i < vertices; i++) {
            sb.append("v : " +i);
            for(Edge e : adjacent[i])
            {
                sb.append(String.format("%s ,", e.toString()));
            }
            sb.append(NEW_LINE);
        }
        return sb.toString();
    }

    private void validateVertx(int vertex) {
        if(vertex < 0 || vertex> this.vertices) throw new NoSuchElementException("vertex is null");
    }


}
