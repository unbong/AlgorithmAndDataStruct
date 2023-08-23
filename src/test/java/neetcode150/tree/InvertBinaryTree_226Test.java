package neetcode150.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTree_226Test {

    private void midTraverse(TreeNode root){

        if(root== null) return ;
        System.out.print(root.val);
        System.out.print(" ");
        midTraverse(root.left);
        midTraverse(root.right);
        return ;
    }

    @Test
    void invertTree() {

        TreeNode t1 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2, t1, t3);

        TreeNode t6 = new TreeNode(6);
        TreeNode t9 = new TreeNode(9);
        TreeNode t7 = new TreeNode(7, t6, t9);

        TreeNode t4 = new TreeNode(4, t2, t7);

        midTraverse(t4);
        System.out.println();
        InvertBinaryTree_226 i = new InvertBinaryTree_226();
        TreeNode root =  i.invertTree(t4);

        midTraverse(root);
    }
}