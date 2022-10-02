package chapter4.section4.Ex;

import chapter1.section3.Queue;
import chapter1.section3.Stack;
import edu.princeton.cs.algs4.In;

import java.util.NoSuchElementException;

public class Ex03_EdgeWeigtedDigraphWIthTable {

    private int vertices;
    private int edges;
    private double[][] adjacents;

    public Ex03_EdgeWeigtedDigraphWIthTable(int vertex){
        this.vertices = vertex;
        adjacents = new double[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            adjacents[i] = new double[vertex];
            for (int j = 0; j < vertex; j++) {
                adjacents[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }

    public Ex03_EdgeWeigtedDigraphWIthTable(In in){
        if(in == null) throw new IllegalArgumentException("in is null");

        try{
            int v = in.readInt();
            if(v<0) throw new IllegalArgumentException("v is invalid.");

            vertices = v;

            for (int i = 0; i < v; i++) {
                adjacents[i] = new double[v];
                for (int j = 0; j < v; j++) {
                    adjacents[i][j] = Double.POSITIVE_INFINITY;
                }
            }

            int e = in.readInt();
            if(e < 0) throw new IllegalArgumentException("e is invalid.");
            for (int i = 0; i < e; i++) {
                int from = in.readInt();
                int to = in.readInt();
                validateVertx(from );
                validateVertx(to);
                double weight = in.readDouble();
                addEdge(from, to , weight);
            }

        }catch (NoSuchElementException e){
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    public int vertex(){
        return vertices;
    }

    public int edge(){
        return edges;
    }

    public void addEdge(int  from, int to, double weight)
    {
        adjacents[from][to] = weight;
        edges++;
    }

    public Iterable<Integer> adjacent(int vertex){

        validateVertx(vertex);
        Stack<Integer> adj = new Stack<>();
        for (int i = 0; i < adjacents[vertex].length; i++) {
            if(adjacents[vertex][i] < Double.POSITIVE_INFINITY)
            {
                adj.push(i);
            }
        }
        return adj;
    }

//    public Iterable<Integer> edges(){
//        Queue<Integer> edge = new Queue<>();
//        for (int i = 0; i < vertices; i++) {
//            for (int j = 0; j < vertices; j++) {
//                if(adjacents[i][j] < Double.POSITIVE_INFINITY)
//                    edge.enqueue(j);
//            }
//        }
//        return
//    }

    private void validateVertx(int v){
        if(v< 0 || v> this.vertices ) throw new IllegalArgumentException("vertex is invalid.");
    }


}
