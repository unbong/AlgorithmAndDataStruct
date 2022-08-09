package chapter2.section3;

import chapter2.Merge;
import chapter2.Quick;
import chapter2.SortCompare;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

public class Ex_17_sentinel {

    public static void sort(Comparable a[])
    {

        Comparable max = Double.MIN_VALUE;
        // find max
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if(max.compareTo(a[i])< 0){
                max = a[i];
                j = i;
            }
        }
        exch(a, j, a.length-1);
        //Merge.show(a);
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable a[], int lo, int hi)
    {
        if(lo>= hi) return;
        int j = partirion(a, lo, hi);

        sort(a, lo, j-1);
        sort(a, j+1, hi);

    }

    private  static  int  partirion(Comparable a[], int lo, int hi)
    {

        int i = lo;
        int j = hi+1;
        Comparable v = a[i];

        while(true)
        {
            while(less(a[++i], v)){ }
            while(less(v, a[--j])) {  }

            if(i>=j)
            {
                break;
            }

            exch(a, i, j);
        }

        exch(a, lo , j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable a[], int i , int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        int N = 32000;
        for (int i = 0; i < 4; i++) {
            double sentinel =SortCompare.timeRandomInput(Ex_17_sentinel.class, N, 1);
            double quick = SortCompare.timeRandomInput(Quick.class, N, 1);

            StdOut.println(String.format("sentinel : %.2f, quick : %.2f ", sentinel, quick));
            N = N*2;
        }


    }
}
