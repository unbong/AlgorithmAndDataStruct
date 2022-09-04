package chapter3.section3;

import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex23_23TreeNoBalanceTest {

    @Test
    void put() {



            Ex23_23TreeNoBalance<Integer, Integer> twoThreeTreeNonBalanced = new Ex23_23TreeNoBalance<>();
            twoThreeTreeNonBalanced.put(5, 5);
            twoThreeTreeNonBalanced.put(1, 1);
            twoThreeTreeNonBalanced.put(9, 9);
            twoThreeTreeNonBalanced.put(2, 2);
            twoThreeTreeNonBalanced.put(0, 0);
            twoThreeTreeNonBalanced.put(99, 99);
            twoThreeTreeNonBalanced.put(-1, -1);
            twoThreeTreeNonBalanced.put(-2, -2);

        twoThreeTreeNonBalanced.levelShowKey();



        }


    @Test
    void getAVGPathLength() {
        Ex23_23TreeNoBalance<Integer, Integer> twoThreeTreeNonBalanced = new Ex23_23TreeNoBalance<>();
        twoThreeTreeNonBalanced.put(5, 5);
        twoThreeTreeNonBalanced.put(1, 1);
        twoThreeTreeNonBalanced.put(9, 9);
        twoThreeTreeNonBalanced.put(2, 2);
        twoThreeTreeNonBalanced.put(0, 0);
        twoThreeTreeNonBalanced.put(99, 99);
        twoThreeTreeNonBalanced.put(-1, -1);
        twoThreeTreeNonBalanced.put(-2, -2);

        StdOut.print(twoThreeTreeNonBalanced.getAVGPathLength());
    }
}