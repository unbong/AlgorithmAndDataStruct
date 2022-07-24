package chapter2;

import edu.princeton.cs.algs4.StdOut;

public class Shell {

    static long count = 0;
    public static void sort(Comparable a[])
    {
        count = 0;
        int N = a.length;
        int h = 0;
        while(h < N/3) h = 3 * h+1;
        while(h>0)
        {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]) ; j-=h) {
                    exch(a, j, j-h);
                }
            }

            h = h/3;
        }

    }

    public static boolean less(Comparable v, Comparable w)
    {
        count++;
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable a[], int i , int k)
    {
        Comparable tmp = a[i];
        a[i] = a[k];
        a[k] = tmp;
    }

    public static boolean isSorted(Comparable a[])
    {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i-1], a[i]) ) return false;
        }

        return true;
    }

    public static void show(Comparable a[]){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i].toString()+ " ");
        }
    }




    public static void main(String[] args) {

//        Double a[] = new Double[20];
//        for (int i = 0; i < 20; i++) {
//           a[i] = StdRandom.uniform();
//        }
//        show(a);
//        sort(a);
//        StdOut.println("");
//        show(a);

//        double time =SortCompare.timeRandomInput(Insertion.class, 10000, 100);
//        double time2 = SortCompare.timeRandomInput(Shell.class, 10000, 100);
//
//        StdOut.println(String.format("insertion : %.5f, shell: %.5f", time, time2));
        int N = 100;
        for (int i = 0; i < 6; i++) {
            SortCompare.timeRandomInput(Shell.class, N ,1);
            StdOut.println(String.format("count/ N = %d", count/N));
            N = N *10;
        }
    }

}
