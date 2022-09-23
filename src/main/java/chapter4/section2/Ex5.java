package chapter4.section2;

import chapter1.section3.Bag;
import chapter1.section3.Stack;
import chapter4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.NoSuchElementException;

public class Ex5 {

    private int vertex;
    private int edge;
    private Bag<Integer> adjacent[];

    public Ex5(int vertex){
        this.vertex = vertex;
        adjacent = (Bag<Integer>[]) new Bag[vertex];
    }

    public Ex5(Digraph dg){
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
    public Ex5(In in){
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

    /**
     * 不允许存在平行边和自环
     * @param source
     * @param dest
     */
    public void addEdge(int source, int dest){
        if(hasSelfLoop(source, dest) || hasEdge(source, dest))
            return ;
        adjacent[source].add(dest);
        edge++;
    }

    private boolean hasSelfLoop(int source, int dest){
        return source == dest;
    }

    public boolean hasEdge(int source, int dest)
    {
        for(int vertex: adjacent[source])
        {
            if(vertex == dest) return true;
        }

        return false;
    }
}
