package chapter2;

import utils.ArrayUtils;
import utils.IntRandom;

public class HeapSort {

    public static void sort(Comparable a[])
    {
        int N = a.length-1;
        // 堆的构造
        for (int i = N /2; i >=1; i--) {
            sink(a, i, N);
        }

        //下沉排序
        while(N > 1)
        {
            ArrayUtils.exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static void sink(Comparable a[],int k, int N)
    {
        while(2*k <= N)
        {
            int p = 2*k;
            if(2*k+1<=N)
            {
                if(ArrayUtils.less(a[p], a[p+1])){
                    p++;
                }
            }

            if(ArrayUtils.less(a[k], a[p]))
            {
                ArrayUtils.exch(a, k, p);
            }
            else break;
            k = 2*k;
        }
    }

    public static void main(String[] args) {

        Integer a[] = IntRandom.getIntRandom(9);
        ArrayUtils.show(a);
        HeapSort.sort(a);
        ArrayUtils.show(a);
    }
}
