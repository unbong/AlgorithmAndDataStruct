package chapter2.section2.exercise;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_2_2_6 {

    public static long count = 0;
    private static Comparable aux[] = null;


    public static void merge(Comparable a[], int lo, int mi, int hi)
    {
        int i = lo;
        int j = mi+1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
            count++;
            count++;
        }

        for (int k = lo; k <=hi; k++) {
            if(i>mi) { a[k] = aux[j++];
                count++;count++;
            }
            else if(j > hi) { a[k] = aux[i++]; count++;count++;}
            else if(less(aux[j], aux[i])) {  a[k] = aux[j++]; count++;count++;count++;count++;}
            else {a[k] = aux[i++]; count++;count++;}
        }
    }

    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }

    public static void sort(Comparable a[]){
        aux = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
            count++;
            count++;
        }
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable a[], int lo, int hi)
    {
        if (lo>=hi) return;

        int mid = lo+(hi-lo)/2;
        sort(a,lo, mid);
        sort(a,mid+1, hi);

        merge(a, lo, mid, hi);
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
        StdOut.println("");
        StdOut.println(count);
    }
}
