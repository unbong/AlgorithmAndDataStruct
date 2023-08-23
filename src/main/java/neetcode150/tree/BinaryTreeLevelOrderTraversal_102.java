package neetcode150.tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_102 {


    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null ) return new ArrayList<>();;
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> levelList = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty())
        {

            TreeNode node = queue.poll();
            if(node == null){
                res.add(levelList);
                levelList = new ArrayList<>();
                if(!queue.isEmpty()) queue.add(null);
                continue;
            }
            levelList.add(node.val);
            if(node.left !=null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        return res;
    }
}
