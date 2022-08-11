package chapter2.section3;

import chapter2.Quick;
import chapter2.SortCompare;
import edu.princeton.cs.algs4.StdOut;
import utils.ArrayUtils;
import utils.IntRandom;

import java.util.ArrayDeque;
import java.util.Queue;

public class Ex20_QuickNonRecursive {

    public static void sort(Comparable a[])
    {
        sort(a, 0, a.length-1);
    }

    public static void sort(Comparable a[], int lo, int hi)
    {
//        Queue<Integer> queue = new Queue<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(lo);
        queue.add(hi);
        while(!queue.isEmpty())
        {
            int i = queue.poll().intValue();
            int j = queue.poll().intValue();
            int k = partition(a, i,j);

            if(k-1>i)
            {
                queue.add(i);
                queue.add(k-1);
            }

            if(k+1<j)
            {
                queue.add(k+1);
                queue.add(j);
            }
        }
    }

    private static int partition(Comparable a[] , int lo, int hi)
    {
        int i= lo;
        int j = hi+1;
        Comparable v = a[lo];

        while(true){

            while(ArrayUtils.less(a[++i], v)){if(i==hi) break;}
            while(ArrayUtils.less(v, a[--j])){if(j == lo) break;}
            if(i>=j) break;
            ArrayUtils.exch(a, i,j);
        }

        ArrayUtils.exch(a, lo, j);
        return j;
    }


    public static void main(String[] args) {
//        Integer a[] = IntRandom.getIntRandom(9);
//        //Integer a[] =  {9, 1, 6, 7, 8, 3, 4, 2, 5};
//        ArrayUtils.show(a);
//        sort(a);
//        ArrayUtils.show(a);

        int N = 128000;
        for (int i = 0; i < 4; i++) {
            double nQuick = SortCompare.timeRandomInput(Ex20_QuickNonRecursive.class, N, 1);
            double quick = SortCompare.timeRandomInput(Quick.class, N, 1);

            StdOut.println(String.format("nonrecursive : %.2f, quick : %.2f ", nQuick, quick));
            N = N*2;
        }

    }
}
