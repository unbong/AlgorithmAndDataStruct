package chapter2;

import chapter2.section1.exercise.Exercise_2_1_24;
import chapter2.section1.exercise.Exercise_2_1_25;
import chapter2.section3.Ex_2_3_5;
import edu.princeton.cs.algs4.StdRandom;
import utils.StopWatch;

public class SortCompare {


    public static double time(Class alg, Comparable a[])
    {
        StopWatch timer = new StopWatch();
        if (alg == Insertion.class) Insertion.sort(a);
        if (alg == Selection.class) Selection.sort(a);
        if (alg == Shell.class) Shell.sort(a);
        if (alg == Exercise_2_1_24.class) Exercise_2_1_24.sort(a);
        if (alg == Exercise_2_1_25.class) Exercise_2_1_25.sort(a);
        if (alg == Merge.class) Merge.sort(a);
        if (alg == MergeBU.class) MergeBU.sort(a);
        if (alg == Ex_2_3_5.class) Ex_2_3_5.sort(a);
        if (alg == Quick.class) Quick.sort(a);
//        if (alg == Insertion.class) Insertion.sort(a);
//        if (alg == Insertion.class) Insertion.sort(a);


        return Double.valueOf(timer.elapsedTime()).doubleValue();
    }

    public static double timeRandomInput (Class alg, int N , int t)
    {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int j = 0; j < t; j++) {
            for (int i = 0; i < N; i++) {
                a[i] = StdRandom.uniform();

            }
            total = time(alg, a);
        }
        return total;
    }

}
