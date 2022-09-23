package chapter4.section2;

import chapter4.BreadthFirstDirectedPaths;
import chapter4.Digraph;
import edu.princeton.cs.algs4.StdOut;

/**
 * 解1：使用广度优先搜索找到v和w所有的可达顶点
 *  * 遍历所有顶点，如果该顶点即可以通过v顶点到达，又可以通过w顶点到达，计算该点的先导路径
 *  * 记录所有先导路径中的最短点
 *
 *
 *
 */
public class Ex22_ShortedAncesstPath {

    private int s =-1;
    public Ex22_ShortedAncesstPath(Digraph g, int v, int w)
    {
        BreadthFirstDirectedPaths bfsV = new BreadthFirstDirectedPaths(g, v);
        BreadthFirstDirectedPaths bfsW = new BreadthFirstDirectedPaths(g, w);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < g.vertex(); i++) {
            if(bfsV.hasPathTo(i) && bfsW.hasPathTo(i))
            {
                int dist = bfsV.distTo(i) + bfsW.distTo(i);
                if(min > dist) {
                    s = i;
                    min = dist;
                }
            }

        }
    }

    public int shortestAncestorPath(){return s;}

    public static void main(String[] args) {
        Digraph g = new Digraph(8);
        g.addEdge(1,0);
        g.addEdge(2,1);
        g.addEdge(3,2);
        g.addEdge(4,2);
        g.addEdge(5,4);
        g.addEdge(2,6);
        g.addEdge(4,1);
        Ex22_ShortedAncesstPath lca = new Ex22_ShortedAncesstPath(g, 2,0);
        StdOut.println("expect 2"+ " LCA " + lca.shortestAncestorPath());
        Ex22_ShortedAncesstPath lca2 = new Ex22_ShortedAncesstPath(g, 3,5);
        StdOut.println("expect 2"+ " LCA " + lca2.shortestAncestorPath());
    }

}
