package chapter2.section3;

import chapter2.Merge;
import chapter2.SortCompare;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import utils.IntRandom;

public class Ex_2_3_5 {

    public static int count ;

    public static void sort(Comparable a[])
    {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private  static void sort(Comparable a[], int lo, int hi)
    {
        if(lo>=hi) return;

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi );
    }


    private static int partition(Comparable a[], int lo, int hi)
    {
        int i = lo;
        int j = hi+1;
        Comparable v = a[lo];

        while(true)
        {

            while(less(a[++i], v)) {

                if(i == hi) break;
            }
            while(less(v, a[--j])){
                if(j == lo) break;
            }
            if(i>=j)
            {
                break;
            }
            exch(a, i, j);
        }

        exch(a, lo, j);

        return  j;
    }

    private static boolean isSorted(Comparable a[])
    {
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1]))
            {
                return false;
            }
        }
        return true;
    }
    private static boolean less(Comparable v, Comparable w)
    {
        count++;
        return v.compareTo(w) < 0;
    }

    private  static void exch(Comparable a[], int i, int j)
    {

        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        int N = 100;
        for (int k = 0; k < 3; k++) {

            Double[] a = new Double[N];
            for (int j = 0; j < N; j++) {
                for (int i = 0; i < N; i++) {
                    a[i] = StdRandom.uniform();
                }
            }

            double lgN = Math.log(N);
            lgN = 2*N*lgN;
            sort(a);
            StdOut.println(String.format("%d, C_n %d, %.2f", N, count, lgN));
            N = N *10;
            count = 0;
        }


    }
}
