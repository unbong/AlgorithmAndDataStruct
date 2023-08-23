package neetcode150.tree;

public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {

        if(root ==null ) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if(leftDepth> rightDepth) return leftDepth+1;
        else return rightDepth+1;
    }
}
