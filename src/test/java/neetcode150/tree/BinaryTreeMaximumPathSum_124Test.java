package neetcode150.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeMaximumPathSum_124Test {

    @Test
    void maxPathSum() {

        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t1, t3);

        TreeNode t6 = new TreeNode(6);
        TreeNode t9 = new TreeNode(9);
        TreeNode t7 = new TreeNode(7, t6, t9);

        TreeNode t4 = new TreeNode(4, t2, t7);

        BinaryTreeMaximumPathSum_124 b = new BinaryTreeMaximumPathSum_124();
        int res = b.maxPathSum(t2);
        assertEquals(6, res);



        TreeNode t13 = new TreeNode(1);
        TreeNode t10 = new TreeNode(2,t13,null);
        res = b.maxPathSum(t10);
        assertEquals(3, res);


        TreeNode t21 = new TreeNode(1);
        TreeNode t23 = new TreeNode(3);
        TreeNode t22 = new TreeNode(2, t1, t3);

        TreeNode t26 = new TreeNode(6);
        TreeNode t29 = new TreeNode(9);
        TreeNode t27 = new TreeNode(7, t6, t9);

        TreeNode t24 = new TreeNode(4, t2, t7);

    }
}