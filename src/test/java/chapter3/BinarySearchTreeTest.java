package chapter3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {


    @Test
    void put() {
        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("F", 1);
        bst.put("C", 1);
        bst.put("H", 1);
        bst.put("M", 1);
        bst.put("A", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        bst.show();
    }

    @Test
    void get() {
        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("F", 1);
        bst.put("C", 1);
        bst.put("H", 1);
        bst.put("M", 1);
        bst.put("A", 2);

        bst.put("V", 2);
        bst.put("K", 2);


        Assertions.assertEquals(1,bst.get("F"));

        Assertions.assertEquals(1,bst.get("C"));

        Assertions.assertEquals(null,bst.get("Z"));

        Assertions.assertEquals(2,bst.get("V"));

    }

    @Test
    void max() {

        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("F", 1);
        bst.put("C", 1);
        bst.put("H", 1);
        bst.put("M", 1);
        bst.put("A", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        Assertions.assertEquals("V", bst.max());
        bst.put("X", 2);

        Assertions.assertEquals("X", bst.max());
        bst.put("Z", 2);

        Assertions.assertEquals("Z", bst.max());

    }

    @Test
    void floor() {
        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("H", 1);
        bst.put("B", 1);
        //bst.put("C", 1);
        bst.put("D", 1);
        bst.put("F", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        Assertions.assertEquals("B", bst.floor("C"));

        Assertions.assertEquals("B", bst.floor("B"));

        Assertions.assertEquals("H", bst.floor("I"));

        Assertions.assertEquals("K", bst.floor("L"));


    }

    @Test
    void ceiling() {
        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("H", 1);
        bst.put("B", 1);
        //bst.put("C", 1);
        bst.put("D", 1);
        bst.put("F", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        Assertions.assertThrows(NoSuchElementException.class,()-> bst.ceiling("Z"));
        Assertions.assertEquals("K", bst.ceiling("J"));

    }

    @Test
    void select() {

        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("H", 1);
        bst.put("B", 1);
        //bst.put("C", 1);
        bst.put("D", 1);
        bst.put("F", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        //Assertions.assertThrows(NoSuchElementException.class, ()->bst.select(0));
        Assertions.assertEquals("B", bst.select(0));
        Assertions.assertEquals("H", bst.select(3));
        Assertions.assertEquals("V", bst.select(5));

        Assertions.assertThrows(NoSuchElementException.class, ()->bst.select(9));
    }

    @Test
    void deleteMin() {
        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("H", 1);
        bst.put("B", 1);
        //bst.put("C", 1);
        bst.put("D", 1);
        bst.put("F", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        bst.deleteMin();
        Assertions.assertEquals("D", bst.select(0));
        bst.deleteMin();
        Assertions.assertEquals("F", bst.select(0));
        bst.deleteMin();
        Assertions.assertEquals("H", bst.select(0));
        bst.deleteMin();
        Assertions.assertEquals("K", bst.select(0));
    }

    @Test
    void deleteMax() {

        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("H", 1);
        bst.put("B", 1);
        //bst.put("C", 1);
        bst.put("D", 1);
        bst.put("F", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        bst.deleteMax();
        Assertions.assertEquals("K", bst.select(4));
        bst.deleteMax();
        Assertions.assertEquals("H", bst.select(3));
        bst.deleteMax();
        Assertions.assertEquals("F", bst.select(2));

    }

    @Test
    void delete() {
        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("H", 1);
        bst.put("B", 1);
        //bst.put("C", 1);
        bst.put("D", 1);
        bst.put("F", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        bst.delete("H");
        Assertions.assertEquals("K", bst.select(3));
        bst.delete("B");
        Assertions.assertEquals("D", bst.select(0));
        bst.delete("K");
        Assertions.assertEquals("V", bst.select(2));

    }

    @Test
    void keys() {
        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("H", 1);
        bst.put("B", 1);
        //bst.put("C", 1);
        bst.put("D", 1);
        bst.put("F", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        Iterable<String> keys = bst.keys();

        for(String item: keys){
            StdOut.print(item+ ", ");
        }
    }

    @Test
    void testKeys() {
    }

    @Test
    void height() {
        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("H", 1);
        bst.put("B", 1);
        //bst.put("C", 1);
        bst.put("D", 1);
        bst.put("F", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        Assertions.assertEquals(3, bst.height());



    }

    @Test
    void isBinaryTree() {

        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("H", 1);
        bst.put("B", 1);
        //bst.put("C", 1);
        bst.put("D", 1);
        bst.put("F", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        assertEquals(true, bst.isBinaryTree());
    }

    @Test
    void isOrdered() {

        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("H", 1);
        bst.put("B", 1);
        //bst.put("C", 1);
        bst.put("D", 1);
        bst.put("F", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        assertEquals(true, bst.isOrdered());
    }

    @Test
    void hasNoDuplicate() {
        BinarySearchTree<String , Integer> bst = new BinarySearchTree<>();
        bst.put("H", 1);
        bst.put("B", 1);
        //bst.put("C", 1);
        bst.put("D", 1);
        bst.put("F", 2);

        bst.put("V", 2);
        bst.put("K", 2);

        assertEquals(true, bst.hasNoDuplicate());
    }
}