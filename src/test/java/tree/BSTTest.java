package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void addNode() {

        BST tree = new BST<>();
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(5);
        tree.addNode(6);
        tree.addNode(7);
        tree.addNode(8);

        tree.inOrder();
    }

    @Test
    void inOrder() {
    }

    @Test
    void deleteNode() {

        BST tree = new BST<>();
        tree.addNode(7);
        tree.addNode(4);
        tree.addNode(5);
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(6);
        tree.addNode(8);
        tree.addNode(9);

        tree.deleteNode(8);

        System.out.println("ss");

    }
}