package chapter2.section3;

import chapter2.Insertion;
import chapter2.Quick;
import chapter2.SortCompare;
import edu.princeton.cs.algs4.StdOut;
import utils.ArrayUtils;

public class Ex25_Quick_Insertion {

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
            while (ArrayUtils.less(a[++i],v)){ if(i == hi) break;}
            while(ArrayUtils.less(v, a[--j])) { if(j == lo) break;}
            if(i>=j)
            {
                break;
            }
            ArrayUtils.exch(a, i,j);
        }

        ArrayUtils.exch(a,lo, j);

        return j;

    }


    public static void main(String[] args) {

//        int N = ;
//        for (int i = 0; i < 4; i++) {
//            double quick_insertion = SortCompare.timeRandomInput(Ex25_Quick_Insertion.class, N, 1);
//            double quick = SortCompare.timeRandomInput(Quick.class, N, 1);
//
//            StdOut.println(String.format("N %d, quick_insertion : %.2f, quick : %.2f ",N, quick_insertion, quick));
//            N = N*2;
//        }
    }
}
