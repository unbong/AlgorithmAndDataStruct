package chapter2.section1.exercise;

import chapter2.Insertion;
import chapter2.SortCompare;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_2_1_24 {





    public static void sort(Comparable arr[])
    {
        int N = arr.length;
        int min = 0;
        for (int i = 0; i < N; i++) {
            if (less(arr[i], arr[min])) min = i;
        }

        exch(arr,0, min);

        for (int i = 1; i <N ; i++) {

            for (int j = i; less(arr[j], arr[j-1]) ; j--) {
                exch(arr,j, j-1);
            }
        }

    }

    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)< 0;
    }

    public static void exch(Comparable arr[], int i, int j)
    {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] =  tmp;
    }

    public static void show(Comparable a[])
    {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(" "+ a[i]);
        }
    }

    public static void main(String[] args) {


//        Integer a[] =IntRandom.getIntRandom(5);
//        show(a);
//        Exercise_2_1_24.sort(a);
//        StdOut.println();
//        show(a);
        double time1=SortCompare.timeRandomInput(Insertion.class, 10000, 10);
        double time2=SortCompare.timeRandomInput(Exercise_2_1_24.class, 10000, 10);
        StdOut.println(String.format("time1: %.4f, time2: %.4f", time1, time2));
    }
}
