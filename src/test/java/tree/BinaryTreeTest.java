package tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedSourceVersion;

import java.util.ArrayList;

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

    @Test
    void getTreeHeight() {
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

        int level =  tree.getTreeHeight();
        System.out.println(level);
    }

    @Test
    void areSameTrees() {

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

        BinaryTreeNode<Integer> node11 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node12 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node13 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node14 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node15 = new BinaryTreeNode<>(5);

        BinaryTreeNode<Integer> node16 = new BinaryTreeNode<>(6);

        BinaryTreeNode<Integer> node17 = new BinaryTreeNode<>(7);

        node12.setLeft(node14);
        node12.setRight(node15);

        node13.setLeft(node16);
        node13.setRight(node17);

        node11.setLeft(node12);
        node11.setRight(node13);

        BinaryTree<Integer> tree1 = new BinaryTree<>();

        tree1.setRoot(node11);

        boolean same =  tree.areSameTrees(tree1,tree);

        System.out.println("s");
    }

    @Test
    void getTreeWidth() {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);

        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);

        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);

        BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> node9 = new BinaryTreeNode<>(9);

        BinaryTreeNode<Integer> node11 = new BinaryTreeNode<>(11);
        BinaryTreeNode<Integer> node12 = new BinaryTreeNode<>(12);
        BinaryTreeNode<Integer> node13 = new BinaryTreeNode<>(13);

        BinaryTreeNode<Integer> node14 = new BinaryTreeNode<>(13);
        node9.setRight(node14);
        node11.setRight(node12);
        node12.setRight(node13);
        node6.setRight(node11);

        node8.setRight(node9);
        node7.setRight(node8);


        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node1.setLeft(node2);
        node1.setRight(node3);

        BinaryTree<Integer> tree = new BinaryTree<>();

        tree.setRoot(node1);

        int widh = tree.getTreeWidth();

        Assertions.assertEquals(8, widh);
    }

    @Test
    void getMaxmumLevelSum() {

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);

        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);

        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);

        BinaryTree<Integer> tree = new BinaryTree<>();
        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        //node3.setRight(node7);

        node1.setLeft(node2);
        node1.setRight(node3);

        tree.setRoot(node1);

        int widh = tree.getMaxmumLevelSum();

        Assertions.assertEquals(22, widh);

    }

    @Test
    void printPath() {

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);

        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);

        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);

        BinaryTree<Integer> tree = new BinaryTree<>();
        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        //node3.setRight(node7);

        node1.setLeft(node2);
        node1.setRight(node3);

        tree.setRoot(node1);

        tree.printPath();
    }

    @Test
    void lowestCommonAncestor() {

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);

        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);

        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);

        BinaryTree<Integer> tree = new BinaryTree<>();
        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node5.setRight(node7);

        node1.setLeft(node2);
        node1.setRight(node3);

        tree.setRoot(node1);

        ArrayList<BinaryTreeNode<Integer>> array = tree.lowestCommonAncestor(node4, node7);
        array.forEach(item->System.out.println(item.getValue()));
    }

    @Test
    void zPrint() {

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);

        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);

        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);

        BinaryTree<Integer> tree = new BinaryTree<>();
        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node1.setLeft(node2);
        node1.setRight(node3);

        tree.setRoot(node1);

        tree.zPrint();
    }
}