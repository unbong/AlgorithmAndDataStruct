package chapter3;

import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;
import utils.IntRandom;

import static org.junit.jupiter.api.Assertions.*;

class SequentialSearchStTest {

    @Test
    void delete() {

        SequentialSearchSt<Integer, Integer> sd = new SequentialSearchSt<>();
        for (int i = 0; i < 5; i++) {
            sd.put(i,i);
        }

        String s = "bsh";

        sd.delete(0);

        StdOut.println("");

        sd.delete(3);

        sd.delete(4);
        StdOut.println("");
    }
}