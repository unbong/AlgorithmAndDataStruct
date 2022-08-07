package chapter2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import utils.ArrayGenerator;

/**
 * 快排三向分割
 *
 */
public class Quick3way {

    private static int rows;
    private static int row = 0;
    private static final int VERTICAL = 70;

    public static void sort(Comparable a[])
    {
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable a[], int lo, int hi)
    {
        if(lo >= hi) return;
        int i = lo+1;
        int lt = lo;
        int gt = hi;

        Comparable v = a[lo];

        while(i<=gt)
        {
            if(v.compareTo(a[i])>0 ){ exch(a, lt++, i++); }
            else if (v.compareTo(a[i]) < 0 ) { exch(a, i, gt--); }
            else { i++; }
        }

        sort(a, lo, lt -1);
        sort(a, lt+1, hi);

    }

    private static void exch(Comparable a[], int i , int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // draw one row of trace
    private static void show(double[] a, int lo, int lt, int gt, int hi) {
        double y = rows - row - 1;
        for (int k = 0; k < a.length; k++) {
            if      (k < lo)             StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if (k > hi)             StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            else if (k >= lt && k <= gt) StdDraw.setPenColor(StdDraw.BOOK_RED);
            else                         StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledRectangle(k, y + a[k] * 0.25, 0.25, a[k] * 0.25);
        }
        row++;
    }


    public static void main(String[] args) {
        int arrayLength = Integer.parseInt("10");
        Comparable a[] = ArrayGenerator.generateRandomArrayWith2Values(arrayLength);
        Merge.show(a);
        StdOut.println();
        sort(a);
        StdOut.println();
        Merge.show(a);
    }
}
