package neetcode150.tree;

public class InvertBinaryTree_226 {


    /**
     * 使用输的后续遍历法，对树进行遍历的同时，互换左右子节点
     * @param root
     * @return
     */

    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode tmp = left;
        root.left = root.right;
        root.right = tmp;
        return  root;
    }
}
