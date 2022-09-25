package chapter4.section3.Ex;

import chapter4.section3.Edge;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.NoSuchElementException;

public class Ex10_EegeWeightedGraphWithMatrix {

    private final  int vertex;
    private int edge;
    private double[][] weight;

    public Ex10_EegeWeightedGraphWithMatrix(int vertex){
        this.vertex = vertex;
        weight = new double[vertex][vertex];
        for (int i = 0; i < vertex; i++) {
            weight[i] = new double[vertex];
            for (int j = 0; j < vertex; j++) {
                weight[i][j] = Double.POSITIVE_INFINITY;
            }
        }
    }

    public Ex10_EegeWeightedGraphWithMatrix(In in){
        if (in == null) throw new IllegalArgumentException("in is null.");
        try{
            int v = in.readInt();
            if(v<0) throw new IllegalArgumentException("v is invalid.");

            vertex = v;
            weight = new double[vertex][vertex];
            for (int i = 0; i < vertex; i++) {
                weight[i] = new double[vertex];
                for (int j = 0; j < v; j++) {
                    weight[i][j] = Double.POSITIVE_INFINITY;
                }
            }

            int e = in.readInt();
            if(e < 0) throw new IllegalArgumentException("e is invalid.");
            for (int i = 0; i < e; i++) {
                int s = in.readInt();
                int w = in.readInt();
                validateVertx(s);
                validateVertx(w);
                double weight = in.readDouble();
                addEdge( s,  w,  weight);
            }

        }catch (NoSuchElementException e){
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }

    }

    public void addEdge(int vertex, int other, double weight){
        // 不允许平行边
        if(this.weight[vertex][other] != Double.POSITIVE_INFINITY
                || this.weight[other][vertex] != Double.POSITIVE_INFINITY)
            return ;

        this.weight[vertex][other] = weight;
        this.weight[other][vertex] = weight;

        edge ++;
    }


    public Iterable<Edge> adjacents(int vertex){
        Bag<Edge> adjacent = new Bag<Edge>();
        for (int i = 0; i < vertex; i++) {
            Edge e = new Edge(vertex, i, weight[vertex][i]);
            adjacent.add(e);
        }
        return adjacent;
    }
    public Iterable<Edge> edges(){
        Bag<Edge> bag = new Bag<>();
        for (int i = 0; i < vertex; i++) {
            for(Edge e: adjacents(i)){
                if(e.other(i) > vertex)
                    bag.add(e);
            }
        }
        return bag;
    }

    private void validateVertx(int vertex) {
        if(vertex < 0 || vertex> this.vertex) throw new NoSuchElementException("vertex is null");
    }
}
