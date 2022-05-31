package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AVLTreeTest {

    @Test
    void print() {

        AVLTree<Integer> tree = new AVLTree<>();
        tree.addNode(20);
        tree.addNode(3);
        tree.addNode(8);
        tree.addNode(9);
        tree.addNode(30);
        tree.addNode(15);

        tree.print();
    }

    @Test
    void remove() {

        AVLTree<Integer> tree = new AVLTree<>();
        tree.addNode(20);
        tree.addNode(3);
        tree.addNode(8);
        tree.addNode(9);
        tree.addNode(30);
        tree.addNode(15);

        tree.print();


        tree.removeNode(3);
        tree.print();
        tree.removeNode(8);
        tree.print();
    }

    @Test
    void countRange() {

        AVLTree<Integer> tree = new AVLTree<>();
        tree.addNode(20);
        tree.addNode(3);
        tree.addNode(8);
        tree.addNode(9);
        tree.addNode(30);
        tree.addNode(15);

        tree.addNode(21);

        tree.addNode(25);
        tree.print();

        int count = tree.countRange(10,25);
        System.out.println(count);
    }
}