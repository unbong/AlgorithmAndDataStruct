package chapter2.section3;

import chapter2.Merge;
import com.sun.org.apache.bcel.internal.generic.MethodGen;
import edu.princeton.cs.algs4.StdOut;

public class Ex_2_3_16 {

    public static Comparable[] madeData(int N)
    {
        Comparable a[] = new Comparable[N];
        Comparable b[] = new Comparable[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;

        }
        madeData(a,b,0 ,N-1,true);



        return a;
    }

    private static void madeData(Comparable a[], Comparable b[], int lo, int hi, boolean isLeft)
    {
        if (lo>=hi) return;
        for (int i = lo; i < hi; i++) {
            b[i] = a[i];
        }

        int mid = lo + (hi-lo)/2;

        Comparable v = b[mid];

        if (isLeft) a[lo] = v;
        else a[hi] = v;

        madeData(a, b, lo, mid-1 , isLeft);

        StdOut.print("first ");
        Merge.show(a);

        madeData(a, b, mid+1, hi, !isLeft);
        StdOut.print("second ");
        Merge.show(a);
    }

    public static void main(String[] args) {

        Comparable a[] =madeData(10);
        Merge.show(a);


    }
}
