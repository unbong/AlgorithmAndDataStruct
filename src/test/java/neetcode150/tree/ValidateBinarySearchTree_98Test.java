package neetcode150.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateBinarySearchTree_98Test {

    @Test
    void isValidBST() {

        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t1, t3);

        TreeNode t6 = new TreeNode(6);
        TreeNode t9 = new TreeNode(9);
        TreeNode t7 = new TreeNode(7, t6, t9);

        TreeNode t4 = new TreeNode(4, t2, t7);


        ValidateBinarySearchTree_98 v = new ValidateBinarySearchTree_98();
        boolean res = v.isValidBST(t4);
        assertEquals(true, res);


        t7.val = 2;

        res = v.isValidBST(t4);
        assertEquals(false, res);
    }
}