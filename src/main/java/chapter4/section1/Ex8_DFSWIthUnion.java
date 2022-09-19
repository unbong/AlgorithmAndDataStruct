package chapter4.section1;

import chapter1.section5.QuickUnion;
import chapter4.Graph;

import java.util.NoSuchElementException;

public class Ex8_DFSWIthUnion {
    private  QuickUnion qu ;
    private final int cu;
    private int count;
    public Ex8_DFSWIthUnion(Graph g, int s){
        if(s<0 || s> g.V()) throw new NoSuchElementException("s is invalid.");
        qu = new QuickUnion(g.V());
        cu = qu.find(s);
        count++;
        dfs(g, s);
    }

    public void dfs(Graph g, int v){

        for(int w: g.adj(v)){
            if(qu.find(w)!= cu){
                qu.union(w,v);
                count++;
                dfs(g,w);
            }
        }
    }

    public boolean marked(int v){
        return qu.find(v) == cu;
    }

    public int count(){return count;}
}
