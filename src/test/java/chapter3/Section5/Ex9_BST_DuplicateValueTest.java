package chapter3.Section5;

import chapter3.BinarySearchTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex9_BST_DuplicateValueTest {

    @Test
    void size() {
        Ex9_BST_DuplicateValue<String , Integer> bst = new Ex9_BST_DuplicateValue<>();
        bst.put("F", 1);
        bst.put("C", 1);
        bst.put("H", 1);
        bst.put("M", 1);
        bst.put("A", 2);

        bst.put("V", 2);
        bst.put("K", 2);
        bst.put("A", 21);
        bst.put("C", 21);

        assertEquals(9, bst.size());
        bst.delete("A");
        assertEquals(7, bst.size());


    }

    @Test
    void contains() {

        Ex9_BST_DuplicateValue<String , Integer> bst = new Ex9_BST_DuplicateValue<>();
        bst.put("F", 1);
        bst.put("C", 1);
        bst.put("H", 1);
        bst.put("M", 1);
        bst.put("A", 2);

        bst.put("V", 2);
        bst.put("K", 2);
        bst.put("A", 21);
        bst.put("C", 21);

        assertEquals(true, bst.contains("A"));
        assertEquals(true, bst.contains("C"));
        assertEquals(false, bst.contains("L"));

    }

    @Test
    void isEmpty() {
    }

    @Test
    void put() {
        Ex9_BST_DuplicateValue<String , Integer> bst = new Ex9_BST_DuplicateValue<>();
        bst.put("F", 1);
        bst.put("C", 1);
        bst.put("H", 1);
        bst.put("M", 1);
        bst.put("A", 2);

        bst.put("V", 2);
        bst.put("K", 2);
        bst.put("A", 21);
        bst.put("C", 21);

        bst.levelShow();
    }

    @Test
    void get() {

        Ex9_BST_DuplicateValue<String , Integer> bst = new Ex9_BST_DuplicateValue<>();
        bst.put("F", 11);
        bst.put("C", 12);
        bst.put("H", 13);
        bst.put("M", 14);
        bst.put("A", 25);

        bst.put("V", 23);
        bst.put("K", 24);
        bst.put("A", 21);
        bst.put("C", 22);

        assertEquals(12,bst.get("C"));
        assertEquals(25, bst.get("A"));
        assertEquals(13, bst.get("H"));


    }

    @Test
    void delete() {
        Ex9_BST_DuplicateValue<String , Integer> bst = new Ex9_BST_DuplicateValue<>();
        bst.put("F", 1);
        bst.put("C", 1);
        bst.put("H", 1);
        bst.put("M", 1);
        bst.put("A", 2);

        bst.put("V", 2);
        bst.put("K", 2);
        bst.put("A", 21);
        bst.put("C", 21);
        bst.put("F", 111);

        bst.levelShow();

        bst.delete("F");
        bst.levelShow();

        bst.delete("C");
        bst.levelShow();

        bst.delete("H");
        bst.levelShow();

    }


    @Test
    void min() {
    }
}