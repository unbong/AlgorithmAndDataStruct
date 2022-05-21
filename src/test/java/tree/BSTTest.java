package tree;

import LinkedList.DoubleLinkedList;
import LinkedList.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    @Test
    void convertToBstFromDDL() {

        DoubleLinkedList<Integer> ddl = new DoubleLinkedList<>();
        ddl.addNode(1,0);
        ddl.addNode(2, 1);
        ddl.addNode(3, 2);
        ddl.addNode(4, 3);
        ddl.addNode(5, 4);
        ddl.addNode(6, 5);
        ddl.addNode(7, 6);
        ddl.addNode(8, 7);
        ddl.addNode(9, 8);
        BST<Integer> bst = new BST<>();
        bst.convertToBstFromDDL(ddl);
    }

    @Test
    void madeBstFromSortedArray() {

        ArrayList<Integer> s = new ArrayList<>();
        for (int i = 1; i <=10 ; i++) {
            s.add(i);
        }

        BST<Integer> tree = new BST<>();
        BinaryTreeNode<Integer> newTree=  tree.madeBstFromSortedArray(s);

        System.out.println("done");
    }
}