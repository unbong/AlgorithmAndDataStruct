package neetcode150.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumDepthOfBinaryTree_104Test {

    @Test
    void maxDepth() {

        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        //TreeNode t2 = new TreeNode(2, t1, t3);
        TreeNode t2 = new TreeNode(2);

        TreeNode t6 = new TreeNode(6);
        TreeNode t9 = new TreeNode(9);
        TreeNode t7 = new TreeNode(7, t6, t9);

        TreeNode t4 = new TreeNode(4, t2, t7);

        MaximumDepthOfBinaryTree_104 m = new MaximumDepthOfBinaryTree_104();
        int l = m.maxDepth(t4);
        assertEquals(3, l);
    }
}