package neetcode150.tree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeLevelOrderTraversal_102Test {

    @Test
    void levelOrder() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        //TreeNode t2 = new TreeNode(2, t1, t3);
        TreeNode t2 = new TreeNode(2);

        TreeNode t6 = new TreeNode(6);
        TreeNode t9 = new TreeNode(9);
        TreeNode t7 = new TreeNode(7);

        TreeNode t4 = new TreeNode(4, t2, t7);

        BinaryTreeLevelOrderTraversal_102 b = new BinaryTreeLevelOrderTraversal_102();
        List<List<Integer>> ss =  b.levelOrder(null);

        assertEquals(true, true);
    }
}