package chapter4.section3;

import org.jetbrains.annotations.NotNull;

public class Edge implements Comparable<Edge>{

    private final  int vertex;
    private final int other;
    private final double weight;

    public Edge(int vertex, int otherVertex, double weight)
    {
        this.vertex = vertex;
        this.other = otherVertex;
        this.weight = weight;
    }

    public double weight() {return weight;}

    public int eigher() {return vertex;}

    public int other(int v) {
        if(v == this.vertex) return this.other;
        else if (v == this.other) return this.vertex;
        else throw new IllegalArgumentException("vertex is invalid.");
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("vertex: ")
          .append(vertex)
          .append(" other: ")
          .append(other)
                .append(" weight: ")
                .append(weight);
        return sb.toString();
    }


    @Override
    public int compareTo(@NotNull Edge that) {
        if(weight > that.weight) return 1;
        if(weight < that.weight) return -1;
        return 0;
    }
}
