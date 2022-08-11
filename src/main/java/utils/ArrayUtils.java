package utils;

import edu.princeton.cs.algs4.StdOut;

public class ArrayUtils {

    public static void show(Comparable a[])
    {
        for (int i = 0; i < a.length; i++) {
            StdOut.print( a[i] +", " );
        }
        StdOut.println("");
    }

    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }

    public  static void exch(Comparable a[], int i, int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
