package chapter2.section1.exercise;

import chapter2.section1.Insertion;
import chapter2.section1.SortCompare;
import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

public class Exercise_2_1_25 {


    public static void sort(Comparable a[])
    {

        int N =a.length;
        for (int i = 1; i < N; i++) {

            Comparable tmp = a[i];
            int j = i;
            for (; j >0 && less(tmp, a[j-1]) ; j--) {
                a[j] = a[j-1];
            }
            a[j] = tmp;

        }
    }

    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    public static void show(Comparable a[])
    {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(" "+ a[i].toString());
        }
    }


    public static void main(String[] args) {
//                Integer a[] = IntRandom.getIntRandom(5);
//        show(a);
//        Exercise_2_1_25.sort(a);
//        StdOut.println();
//        show(a);
        double time1= SortCompare.timeRandomInput(Insertion.class, 10000, 20);
        double time2=SortCompare.timeRandomInput(Exercise_2_1_25.class, 10000, 20);
        StdOut.println(String.format("time1: %.4f, time2: %.4f", time1, time2));
    }


}

