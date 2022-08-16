package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;
import utils.ArrayUtils;

public class Ex16 {
    private static int count = 0;
    public static void sort(Comparable a[])
    {
        count = 0;
        int N = a.length-1;
        //
        for (int i = N/2; i >=0 ; i--) {
            sink(a, i,N);
        }

        while(N>=0)
        {
            ArrayUtils.exch(a, 0, N--);
            sink(a, 0, N);
        }

        //

    }

    public static void sink(Comparable a[], int i, int N)
    {
        while(2*i+1 <= N)
        {
            int c = 2*i+1;
            if( 2*i+1 < N &&  ArrayUtils.less(a[c], a[c+1])){
                c++;
            }

            if(ArrayUtils.less(a[i], a[c])) exch(a,c,i);
            else break;
            i = c;
        }
    }

    public static void exch(Comparable a[], int i, int j){
        count++;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    public static void main(String[] args) {
        int N = 32;
        Integer a[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = i+1;
        }

        ArrayUtils.show(a);
        sort(a);
        ArrayUtils.show(a);
        StdOut.println(count);

        for (int i = 0; i < N; i++) {
            a[i] = N-i;
        }

        ArrayUtils.show(a);
        sort(a);
        ArrayUtils.show(a);
        StdOut.println(count);
    }

}
