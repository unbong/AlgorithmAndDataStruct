package chapter2.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_2_2_10 {

    private static Comparable aux[] = null;

    public static void merge(Comparable a[],int lo, int mi, int hi)
    {
        int l = lo;
        int m = hi;

        for (int i = lo; i <= mi; i++) {
            aux[i] = a[i];
        }

        for (int i = mi+1; i <=hi ; i++) {
            aux[i] = a[hi-i + mi+1];
        }

        for (int i = lo; i <= hi; i++) {
            if(less(aux[m], aux[l])){
                a[i] = aux[m--];
            }
            else {
                a[i] = aux[l++];
            }
        }
    }

    public static  void sort(Comparable a[])
    {
        aux = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }

        sort(a, 0,a.length-1 );
    }

    private static void sort(Comparable a[], int lo, int hi)
    {
        if (lo>= hi) return;
        int mi = lo +(hi-lo)/2;

        sort(a, lo, mi);
        sort(a, mi+1, hi);

        merge(a, lo, mi , hi);
    }

    public static  void show(Comparable a[])
    {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(" " + a[i]);
        }
    }
    public static boolean less(Comparable v, Comparable w )
    {
        return v.compareTo(w)< 0;
    }

    public static void main(String[] args) {

        Integer a[]={5,3, 2,1, 4};

        sort(a);

        show(a);

    }
}
