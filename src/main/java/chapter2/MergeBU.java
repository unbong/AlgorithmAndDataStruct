package chapter2;

import edu.princeton.cs.algs4.StdOut;

public class MergeBU {

    private static Comparable aux[] = null;

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)< 0;
    }

    public static void merge(Comparable a[], int lo, int mi, int hi)
    {
        aux = new Comparable[a.length];
        int i = lo;
        int j = mi+1;
        for (int m = lo; m <= hi; m++) {
            aux[m] = a[m];
        }

        for (int k = lo; k <= hi; k++) {
            if(i>mi) { a[k] = aux[j++]; }
            else if (j > hi) { a[k] = aux[i++] ;}
            else if(less(aux[j], aux[i])) { a[k] = aux[j++]; }
            else { a[k] = aux[i++]; }
        }

    }

    public static void sort(Comparable a[])
    {

        int N = a.length;
        for (int i = 1; i < N; i = i+i ) {
            for (int j = 0; j < N-i; j+=i+i) {

                merge(a, j, j+i-1, Math.min(N-1, j+i+i-1));
            }
        }
    }

    private  static  void show(Comparable a[])
    {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(" " + a[i]);
        }
    }

    public static void main(String[] args) {

        Integer a[]={5,3, 2,1, 4};

        sort(a);

        show(a);
    }
}
