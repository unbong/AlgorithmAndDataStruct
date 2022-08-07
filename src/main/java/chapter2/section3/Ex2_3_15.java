package chapter2.section3;

import chapter2.Merge;
import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

import java.lang.reflect.Method;

public class Ex2_3_15 {

    public static void sort(Comparable a[], Comparable b[])
    {
        sort(a, b,0, a.length);
    }

    private static void sort(Comparable a[], Comparable b[], int lo, int hi )
    {
            if(lo >= hi) return;

            int j = partition(a, b, 0, a.length-1);

            sort(a, b, lo, j-1);
            sort(a, b, j+1, hi);

    }

    private  static int partition(Comparable a[], Comparable b[], int lo, int hi )
    {
        int i = lo;
        int j = hi+1;
        Comparable v = b[lo];
        int nextPivot = -1;
        while(true)
        {

            while (less(a[++i],v)){
                if(i == hi) break;
            }
            while(less(v, a[--j])) {
                if(j == lo) break;
            }
            if(i>=j)
            {
                break;
            }
            exch(a, i,j);
        }
        exch(a,  lo, j);

        //v = a[nextPivot];
        i = lo-1;
        j = hi+1;
        while(true)
        {
            while (less(b[++i], v)){
                if(v.compareTo(b[i]) == 0 )
                {
                    nextPivot = i;
                }

                if(i == hi) break;
            }
            while (less(v, b[--j]))
            {
                if(v.compareTo(b[j]) == 0)
                {
                    nextPivot = j;
                }
                if( j == lo)  break;
            }



            if(i>=j)
            {
                break;
            }
            exch(b, i, j);
        }
        exch(b,  nextPivot, j);

        StdOut.print("a ");
        Merge.show(a);
        StdOut.print("b ");
        Merge.show(b);

        return  j;

    }

    private static boolean isSorted(Comparable arr[])
    {
        for (int i = 1; i < arr.length; i++) {
            if(less(arr[i] , arr[i-1]))
            {
                return false;
            }
        }
        return  true;
    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }
    private  static void exch(Comparable a[], int i, int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        Integer a[] = IntRandom.getIntRandom(10);
        Integer b[] = IntRandom.getIntRandom(10);

        StdOut.print("a ");
        Merge.show(a);
        StdOut.print("b ");
        Merge.show(b);

        sort(a, b);

        StdOut.print("a ");
        Merge.show(a);
        StdOut.print("b ");
        Merge.show(b);
    }
}
