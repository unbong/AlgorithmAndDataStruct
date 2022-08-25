package chapter2.section5;

import edu.princeton.cs.algs4.StdOut;
import utils.ArrayUtils;
import utils.IntRandom;

public class Ex6_SelectWithRecursive {

    public static Comparable select(Comparable a[], int k){

       return  select(a, k, 0, a.length-1);
    }

    private static Comparable select(Comparable a[], int k , int lo, int hi)
    {
        if(lo>= hi) return lo;

        int j = partition(a, lo, hi);
        if (j == k) return a[j];
        else if(j>k) return select(a, k, lo, j-1);
        else  return select(a, k , j+1, hi);

    }


    private static int partition(Comparable a[], int lo, int hi)
    {
        int i = lo;
        int j = hi+1;
        Comparable au = a[lo];
        while(i<j)
        {
            while(ArrayUtils.less(a[++i], au)) {if(i>=hi) break;}
            while(ArrayUtils.less(au,a[--j])){ if(j<=lo) break;}

            if(i>j) break;
            ArrayUtils.exch(a, i, j);
        }

        ArrayUtils.exch(a,lo, j);

        return j;
    }
    public static void main(String[] args) {
        Integer a[] = IntRandom.getIntRandom(9);
        ArrayUtils.show(a);
        Comparable ss = Ex6_SelectWithRecursive.select(a, 1);
        StdOut.println(ss);
    }




}
