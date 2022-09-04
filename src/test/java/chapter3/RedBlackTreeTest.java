package chapter3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;
import utils.IntRandom;

import static org.junit.jupiter.api.Assertions.*;

class RedBlackTreeTest {

    @Test
    void put() {

        RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
        RedBlackBST<Integer, Integer> bst1 = new  RedBlackBST<>();
                Integer a[] = IntRandom.getIntRandom(16);

        for (int i = 0; i < a.length; i++) {
            rbt.put(a[i], a[i]);
            bst.put(a[i], a[i]);
            bst1.put(a[i], a[i]);
        }

        StdOut.println(rbt.height());
        StdOut.println(bst1.height());

        rbt.levelShowKey();
        bst.levelShowKey();

        rbt = new RedBlackTree<>();
        bst = new BinarySearchTree<>();
        bst1 = new  RedBlackBST<>();
        StdRandom.shuffle(a);



        for (int i = 0; i < a.length; i++) {
            rbt.put(a[i], a[i]);
            bst.put(a[i], a[i]);
            bst1.put(a[i], a[i]);
        }

        StdOut.println(rbt.height());
        StdOut.println(bst1.height());

        rbt.levelShowKey();
        bst.levelShowKey();



    }
}