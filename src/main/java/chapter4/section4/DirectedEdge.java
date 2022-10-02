package chapter4.section4;

import org.jetbrains.annotations.NotNull;

/**
 * 加权有向边
 */
public class DirectedEdge implements Comparable<DirectedEdge>{

    private int from;
    private int to;
    private double weight;

    public DirectedEdge(int from, int to, double weight)
    {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public double getWeight(){return weight;}

    public int from(){return from;}

    public int to(){return to;}

    public String toString(){
        return String.format("%d->%d, weight:%.5f", from, to, weight);
    }

    @Override
    public int compareTo(@NotNull DirectedEdge that) {

        if(this.weight>that.weight) return 1;
        else if(this.weight < that.weight) return -1;
        return 0;
    }
}
