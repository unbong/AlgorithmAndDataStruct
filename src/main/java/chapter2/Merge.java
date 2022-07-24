package chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Merge {
    public static Comparable aux[];
    public static void merge(Comparable a[], int lo, int mid, int hi )
    {
        int i = lo;
        int j = mid +1;

        //Comparable aux[] = new Comparable[a.length];
        for (int k = i; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if(i>mid) { a[k] = aux[j++]; }
            else if (j > hi) {  a[k] = aux[i++] ;}
            else if (less(aux[j], aux[i])) { a[k] = aux[j++] ;}
            else {a[k] = aux[i++];}

        }
    }

    public static void sort(Comparable a[])
    {
        aux = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }

        sort(a, 0, a.length-1);

    }

    private static void sort(Comparable a[], int lo, int hi)
    {
        if(hi<=lo) return;

        int mid = lo+ (hi-lo)/2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);

        merge(a, lo, mid, hi);
    }

    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }

    public static void show(Comparable a[])
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
