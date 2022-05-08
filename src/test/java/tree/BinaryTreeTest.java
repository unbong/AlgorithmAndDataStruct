package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    @Test
    void levelOrder() {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);

        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);

        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node1.setLeft(node2);
        node1.setRight(node3);


        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(node1);

        tree.levelOrder();

    }

    @Test
    void findMax() {

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);

        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);

        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node1.setLeft(node2);
        node1.setRight(node3);


        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(node1);

        System.out.println(tree.findMax());
    }

    @Test
    void addNode() {

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);

        tree.preOrderRecursive();
        System.out.println();

    }
}