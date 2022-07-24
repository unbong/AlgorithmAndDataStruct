package chapter2.section1.exercise;

import chapter2.section1.Insertion;
import chapter2.section1.Shell;
import chapter2.section1.SortCompare;
import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

public class Exercise_2_1_27 {


//    public static void sort(int a[])
//    {
//
//        int N =a.length;
//        for (int i = 1; i < N; i++) {
//
//            int tmp = a[i];
//            int j = i;
//            for (; j >0 && less(tmp, a[j-1]) ; j--) {
//                a[j] = a[j-1];
//            }
//
//            a[j] = tmp;
//        }
//    }
//
//    public static boolean less(int  v, int w)
//    {
//        return v < w;
//    }
//
//    public static void show(int a[])
//    {
//        for (int i = 0; i < a.length; i++) {
//            StdOut.print(" "+ a[i]);
//        }
//    }


    public static void main(String[] args) {


        int N =40000;
        for (int i = 1; i <= 5; i++) {

            double time1= SortCompare.timeRandomInput(Shell.class, N, 1);
            N = N * 2;
            StdOut.println(String.format("time%d: %.4f, ", i , time1));
        }

    }


}

