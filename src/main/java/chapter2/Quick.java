package chapter2;

import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

public class Quick {

    private static final int M = 10;
    public static void sort(Comparable a[])
    {
        sort(a,0, a.length-1);
    }

    private static void sort(Comparable a[], int lo, int hi){

        // 改进1 对于小数组 使用插入排序
        if(lo + M>=hi) {
            Insertion.sort(a, lo, hi);
            return ;
        }
        int j = partition(a, lo,hi);

        sort(a, lo, j-1);
        sort(a, j+1,hi);

    }

    private static int partition (Comparable a[], int lo, int hi)
    {
        int i = lo;
        int j = hi+1;


        Comparable v = a[lo];

        while (true)
        {
            while (less(a[++i],v)){ if(i == hi) break;}
            while(less(v, a[--j])) { if(j == lo) break;}
            if(i>=j)
            {
                break;
            }
            exch(a, i,j);
        }

        exch(a,lo, j);

        return j;

    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable a[], int i, int j)
    {
        Comparable tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }


    public static void main(String[] args) {
        Integer a[] = IntRandom.getIntRandom(9);

        Merge.show(a);
        StdOut.println("");
        sort(a);
        StdOut.println("");
        Merge.show(a);

    }
}
