package chapter4.section2;

import chapter4.BreadthFirstDirectedPaths;
import chapter4.Degrees;
import chapter4.Digraph;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.List;

public class Ex21_LCA {

    private int LCA = -1;
    public Ex21_LCA(Digraph g, int v, int w)
    {
        // 找到所有出度大于0 入度为0的顶点

        Degrees degrees = new Degrees(g);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < g.vertex() ; i++) {
            if(degrees.indegree(i) ==0 && degrees.outdegree(i) > 0){
                list.add(i);
            }
        }
        // 广度优先的方式找到v和w的根顶点
        for(int i : list)
        {
            BreadthFirstDirectedPaths bfspath = new BreadthFirstDirectedPaths(g, i);
            // 当v 和 w都有路径存在时，认为找到了根
            if(bfspath.hasPathTo(v) && bfspath.hasPathTo(w)){

                int distV = bfspath.distTo(v);  // 跟到v的距离
                int distW = bfspath.distTo(w);
                Digraph reverse = g.reverse();  // 生成反向图
                // 距离比较
                if(distW>distV)
                {
                    //生成反向图的路径距离
                    BreadthFirstDirectedPaths reverseBfsPath = new BreadthFirstDirectedPaths(reverse, v);

                    // 遍历根到w的各个顶点，各顶点在v的反向路径中存在路径的最后一个结点为最近共同祖先
                    for(int vertex: bfspath.pathTo(w))
                    {
                        if(  reverseBfsPath.hasPathTo(vertex) )
                        {
                            LCA = vertex;

                        }
                    }
                }
                else{
                    BreadthFirstDirectedPaths reverseBfsPath = new BreadthFirstDirectedPaths(reverse, w);
                    for(int vertex: bfspath.pathTo(v))
                    {
                        if(reverseBfsPath.hasPathTo(vertex) )
                        {
                            LCA = vertex;

                        }
                    }
                }
                break;
            }
        }


    }

    public int lca(){
        return LCA;
    }


    public static void main(String[] args) {
        Digraph g = new Digraph(8);
        g.addEdge(1,0);
        g.addEdge(2,1);
        g.addEdge(3,2);
        g.addEdge(4,2);
        g.addEdge(5,4);
        g.addEdge(2,6);
        g.addEdge(4,1);
        Ex21_LCA lca = new Ex21_LCA(g, 2,0);
        StdOut.println("expect 2"+ " LCA " + lca.LCA);
        Ex21_LCA lca2 = new Ex21_LCA(g, 1,6);
        StdOut.println("expect 2"+ " LCA " + lca2.LCA);
    }
}
