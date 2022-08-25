package chapter2.section5;

import chapter2.Insertion;
import edu.princeton.cs.algs4.StdOut;
import utils.ArrayUtils;
import utils.IntRandom;

public class Ex27_ParallelSorting {

    public static void main(String[] args) {

        Integer a[] = IntRandom.getIntRandom(9);
        ArrayUtils.show(a);
        int va[] = Insertion.indirectSort(a);

        for (int i = 0; i < va.length; i++) {
            StdOut.print(va[i] + " ");
        }
        StdOut.println();
        for (int i = 0; i < va.length; i++) {

            StdOut.print(a[va[i]] + " ");
        }
    }
}
