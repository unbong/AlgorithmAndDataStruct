package chapter4.section3;

import chapter1.section3.Bag;
import chapter1.section3.Queue;
import edu.princeton.cs.algs4.In;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class EdgeWeighedGraphWithDelete {

    private static final String NEW_LINE = System.getProperty("line.separator");
    private final int vertices;
    private int edges;
    private Set<Edge>[] adjacent;

    public EdgeWeighedGraphWithDelete(int v){
        vertices = v;
        adjacent = (Set<Edge>[]) new HashSet[v];
        for (int i = 0; i < v; i++) {
            adjacent[i] = new HashSet<Edge>();
        }
    }

    public EdgeWeighedGraphWithDelete(In in){
        if(in == null) throw new IllegalArgumentException("in is null");

        try{
            int v = in.readInt();
            if(v<0) throw new IllegalArgumentException("v is invalid.");

            vertices = v;
            adjacent = (Set<Edge>[]) new HashSet[v];
            for (int i = 0; i < v; i++) {
                adjacent[i] = new HashSet<Edge>();
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
        if(hasEdge(edge)) return;
        int vertex = edge.eigher();
        int other = edge.other(vertex);
        adjacent[vertex].add(edge);
        adjacent[other].add(edge);
        edges++;
    }

    public void deleteEdge(Edge e){
        int vertex = e.eigher();
        int other = e.other(vertex);

        adjacent[vertex].remove(e);
        adjacent[other].remove(e);
        edges--;
    }

    private boolean hasEdge(Edge e){

        return adjacent[e.eigher()].contains(e);
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
