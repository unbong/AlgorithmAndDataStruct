package chapter2.section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 递归深度
 *  最好的情况下的
 */
public class Ex_2_3_13 {

    public static int count ;
    public static int maxStack = 0;
    public static int stackCount = 0;

    public static void sort(Comparable a[])
    {
        int sc = 0;
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1, sc);
    }

    private  static void sort(Comparable a[], int lo, int hi, int sc)
    {
        sc++;
        if(maxStack < sc) maxStack = sc;
        stackCount++;
        if(lo>=hi) return;

        int j = partition(a, lo, hi);
        sort(a, lo, j-1, sc);
        sort(a, j+1, hi, sc );
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

        /**
         * 顺序 C_n 5148, stackCount 199
         * 倒序 C_n 5098, stackCount 199
         * 乱序  C_n 719, stackCount 131
         */

        int N = 100;

        Integer a[] = new Integer[N];

        for (int i = 0; i < 20; i++) {
            for (int k = 0; k < N; k++) {
                a[k] = N-k;
            }
            sort(a);
            StdOut.println(String.format("%d, C_n %d, stackCount %d, maxSc %d", N, count, stackCount, maxStack));

            count = 0;
            stackCount = 0;
            maxStack = 0;
        }



    }
}
