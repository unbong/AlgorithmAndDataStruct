package chapter4.section4;

import chapter1.section3.Bag;
import chapter1.section3.Queue;
import chapter4.section3.Edge;
import edu.princeton.cs.algs4.In;

import java.util.NoSuchElementException;

/**
 * 加权有向图的API
 */
public class EdgeWeightedDigraph {

    private final int vertices;
    private int edges;
    private Bag<DirectedEdge>[] adjacent;


    public EdgeWeightedDigraph(int vertices){
        this.vertices = vertices;
        adjacent = (Bag<DirectedEdge>[]) new Bag[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacent[i] = new Bag<>();
        }
    }


    public EdgeWeightedDigraph(In in){
        if(in == null) throw new IllegalArgumentException("in is null");

        try{
            int v = in.readInt();
            if(v<0) throw new IllegalArgumentException("v is invalid.");

            vertices = v;
            adjacent = (Bag<DirectedEdge>[]) new Bag[v];
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
                addEdge(new DirectedEdge(s,w,weight));
            }

        }catch (NoSuchElementException e){
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    private void validateVertx(int vertex){
        if(vertex < 0 || vertex>vertices-1) throw new IllegalArgumentException("vertex is invalid.");

    }


    public int vertex(){return  vertices;}

    public int edge(){return edges;}

    public Iterable<DirectedEdge> adjacenties(int vertex){
        validateVertx(vertex);
        return adjacent[vertex];
    }

    public Iterable<DirectedEdge> edges(){
        Queue<DirectedEdge> queue = new Queue<>();
        for (int i = 0; i < this.vertices; i++) {
            for (DirectedEdge edge: adjacent[i])
            {
                queue.enqueue(edge);
            }
        }
        return queue;
    }

    public void addEdge(DirectedEdge edge){
        validateVertx(edge.from());
        validateVertx(edge.to());

        adjacent[edge.from()].add(edge);
        edges++;
    }
}
