package chapter2.section1.exercise;

import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

public class Exercise_2_1_26 {


    public static void sort(int a[])
    {

        int N =a.length;
        for (int i = 1; i < N; i++) {

            int tmp = a[i];
            int j = i;
            for (; j >0 && less(tmp, a[j-1]) ; j--) {
                a[j] = a[j-1];
            }

            a[j] = tmp;
        }
    }

    public static boolean less(int  v, int w)
    {
        return v < w;
    }

    public static void show(int a[])
    {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(" "+ a[i]);
        }
    }


    public static void main(String[] args) {
        Integer a[] = IntRandom.getIntRandom(5);
        int b[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        show(b);
        Exercise_2_1_26.sort(b);
        StdOut.println();
        show(b);
//        double time1= SortCompare.timeRandomInput(Insertion.class, 20000, 20);
//        double time2=SortCompare.timeRandomInput(Exercise_2_1_26.class, 20000, 20);
//        StdOut.println(String.format("time1: %.4f, time2: %.4f", time1, time2));
    }


}

