package chapter4;

import chapter1.section3.Stack;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Queue;

/**
 * 深度优先排序
 *
 */
public class DepthFirstOrder {

    private Queue<Integer> pre;            // 前排序 dfs的调用顺序

    private Queue<Integer> post;           // 后排序  顶点遍历完成的顺序
    private Stack<Integer> reversePost;    // 逆后排序

    private boolean marked[];

    public DepthFirstOrder(Digraph dg)
    {
        marked = new boolean[dg.vertex()];
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();

        for (int currentVertex = 0; currentVertex < dg.vertex(); currentVertex++) {

            if(! marked[currentVertex]) dfs(dg, currentVertex);
        }
    }

    public Iterable<Integer> pre(){return pre;}

    public Iterable<Integer> post(){return post;}

    public Iterable<Integer> reversePost(){return reversePost;}
    private void dfs(Digraph dg, int vertex){
        marked[vertex] = true;
        pre.enqueue(vertex);
        for (int neighbor : dg.adjacent(vertex)) {
            if(! marked[neighbor]) dfs(dg, neighbor);
        }
        post.enqueue(vertex);
        reversePost.push(vertex);
    }
}
