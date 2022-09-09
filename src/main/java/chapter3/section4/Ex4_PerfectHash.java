package chapter3.section4;


import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;
import java.util.Set;

public class Ex4_PerfectHash{

    public static void main(String[] args) {
        Ex4_PerfectHash ex = new Ex4_PerfectHash();
        int[] values = ex.perfectHash();

        if (values != null) {
            StdOut.println("a = " + values[0]);
            StdOut.println("m = " + values[1]);
        }
    }

    public int[] perfectHash(){
        int[] values = new int[2];

        int[] letterValues = {19, 5, 1, 18, 3, 8, 24, 13, 16, 12};

        for (int m = letterValues.length; m <= 26; m++) {
            for (int a = 1; a < m; a++) {
                Set<Integer> hashes = new HashSet<>();

                for (int letterValue : letterValues) {
                    int hash = hashFunction(a, letterValue, m);
                    hashes.add(hash);
                }

                if (hashes.size() == 10) {
                    //Perfect hash function found
                    values[0] = a;
                    values[1] = m;
                    return values;
                }
            }
        }
        return null;
    }

    private int hashFunction(int j, int letterValue, int i) {
        return (j*letterValue) %i;
    }
}
