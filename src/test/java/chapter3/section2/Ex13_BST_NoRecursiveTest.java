package chapter3.section2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex13_BST_NoRecursiveTest {

    @Test
    void put() {
        Ex13_BST_NoRecursive<Integer, Integer> bst = new Ex13_BST_NoRecursive<>();
        bst.put(5,5);
        bst.put(3,5);
        bst.put(1,5);
        bst.put(2,5);
        bst.put(8,5);
        bst.put(7,5);
        bst.show();
    }

    @Test
    void get() {
        Ex13_BST_NoRecursive<Integer, Integer> bst = new Ex13_BST_NoRecursive<>();
        bst.put(5,5);
        bst.put(3,3);
        bst.put(1,1);
        bst.put(2,2);
        bst.put(8,8);
        bst.put(7,7);
        bst.put(2,9);
        assertEquals(5, bst.get(5));
        assertEquals(3, bst.get(3));
        assertEquals(1, bst.get(1));
        assertEquals(9, bst.get(2));
        assertEquals(null, bst.get(4));
    }

    @Test
    void min() {
        Ex13_BST_NoRecursive<Integer, Integer> bst = new Ex13_BST_NoRecursive<>();
        bst.put(5,5);
        bst.put(3,3);
        bst.put(1,1);
        bst.put(2,2);
        bst.put(8,8);
        bst.put(7,7);
        bst.put(2,9);
        assertEquals(1, bst.min());
    }

    @Test
    void max() {
        Ex13_BST_NoRecursive<Integer, Integer> bst = new Ex13_BST_NoRecursive<>();
        bst.put(5,5);
        bst.put(3,3);
        bst.put(1,1);
        bst.put(2,2);
        bst.put(8,8);
        bst.put(7,7);
        bst.put(2,9);
        assertEquals(8, bst.max());
    }

    @Test
    void floor() {
        Ex13_BST_NoRecursive<Integer, Integer> bst = new Ex13_BST_NoRecursive<>();
        bst.put(5,5);
        bst.put(3,3);
        bst.put(1,1);
        bst.put(2,2);
        bst.put(8,8);
        bst.put(7,7);
        bst.put(2,9);

        assertEquals(5, bst.floor(6));
        assertEquals(null, bst.floor(0));
        assertEquals(8, bst.floor(9));
    }

    @Test
    void ceiling() {

        Ex13_BST_NoRecursive<Integer, Integer> bst = new Ex13_BST_NoRecursive<>();
        bst.put(5,5);
        bst.put(3,3);
        bst.put(1,1);
        bst.put(2,2);
        bst.put(8,8);
        bst.put(7,7);
        bst.put(2,9);

        assertEquals(1,bst.ceiling(0));
        assertEquals(2,bst.ceiling(2));
        assertEquals(7,bst.ceiling(6));
        assertEquals(null,bst.ceiling(9));

    }

    @Test
    void rank() {

        Ex13_BST_NoRecursive<Integer, Integer> bst = new Ex13_BST_NoRecursive<>();
        bst.put(5,5);
        bst.put(3,3);
        bst.put(1,1);
        bst.put(2,2);
        bst.put(8,8);
        bst.put(7,7);
        bst.put(2,9);

        assertEquals(0, bst.rank(1));
        assertEquals(2, bst.rank(3));
        assertEquals(3, bst.rank(4));

        assertEquals(5, bst.rank(8));
        assertEquals(6, bst.rank(9));
    }

    @Test
    void select() {

        Ex13_BST_NoRecursive<Integer, Integer> bst = new Ex13_BST_NoRecursive<>();
        bst.put(5,5);
        bst.put(3,3);
        bst.put(1,1);
        bst.put(2,2);
        bst.put(8,8);
        bst.put(7,7);
        bst.put(2,9);

        assertEquals(1, bst.select(0));
        assertEquals(2, bst.select(1));

        assertEquals(8, bst.select(5));

    }
}