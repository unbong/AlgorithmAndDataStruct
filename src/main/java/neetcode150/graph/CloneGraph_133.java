package neetcode150.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CloneGraph_133 {

    private Set<Integer> mark= new HashSet<>();
    private HashMap<Node, Node> map = new HashMap();

    /**
     *
     * 使用深度优先探索方法去找出每个节点的邻居，同时需要用一个辅助数据结构来记录已经访问过的节点。
     * 在访问到已经访问过得节点时，从辅助数据结构中取得
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Node clone = new Node(node.val);
        dfs(node, clone);

        return clone;
    }

    private void dfs(Node source, Node clone) {
        mark.add(source.val);
        map.put(source,clone);
        for (Node neighbor: source.neighbors){
            Node neighborClone = null;
            if(map.containsKey(neighbor))
                neighborClone = map.get(neighbor);
            else
                neighborClone= new Node(neighbor.val);
            if(!mark.contains(neighbor.val)) dfs(neighbor, neighborClone);

            clone.neighbors.add(neighborClone);

        }
    }
}
