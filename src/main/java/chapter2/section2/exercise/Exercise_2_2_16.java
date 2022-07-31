package chapter2.section2.exercise;

import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

public class Exercise_2_2_16 {


    public static void sort(Comparable a[])
    {

        Comparable aux[] = new Comparable[a.length];

        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }
        int lo = 0;
        int mi = 0;
        int hi = 0;
        while(true)
        {
            boolean isBreak = false;
            mi = lo;
            // 第一个递增
            for (int i = lo; i < a.length-1; i++) {
                mi = i;
                if( ! less(a[i], a[i+1]))
                {
                    break;
                }
            }

            if (isBreak)  break;

            hi = mi;
            for (int i = mi+1; i < a.length-1; i++) {
                hi = i;
                if( ! less(a[i], a[i+1]))
                {
                    break;
                }else if(i == a.length-2)
                {
                    hi = a.length-1;
                }
            }

            if (mi == hi && hi == a.length-2) hi = a.length-1;

            merge(a, aux, lo, mi, hi);
            show(a);
            if(hi-lo == a.length-1) break;

            if(hi >= a.length -1)
            {
                lo =0;
                mi = 0;
                hi= 0;
            }else {
                lo = hi+1;
            }


        }

    }

    public static void show(Comparable a[])
    {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(" " + a[i]);
        }
        StdOut.println("");
    }


    public static void merge(Comparable a[], Comparable aux[], int lo, int mi, int hi)
    {
        int i = lo;
        int j = mi +1;

        //Comparable aux[] = new Comparable[a.length];
        for (int k = i; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if(i>mi) { a[k] = aux[j++]; }
            else if (j > hi) {  a[k] = aux[i++] ;}
            else if (less(aux[j], aux[i])) { a[k] = aux[j++] ;}
            else {a[k] = aux[i++];}

        }
    }

    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)< 0;
    }

    public static void main(String[] args) {

        //Integer a[] =IntRandom.getIntRandom(7);
        Integer a[] ={6, 3, 2 ,1 ,5, 7 ,4};
        show(a);
        StdOut.println("------------");
        sort(a);

        StdOut.println("------------");
        show(a);
    }

}
