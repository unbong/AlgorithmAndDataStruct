package chapter2.section1.exercise;


import chapter2.Merge;
import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

/**
 *  详细参考了 https://www.geeksforgeeks.org/counting-inversions/
 */
public class Exercise_2_1_19 {

    /**
     * 左半边和右半边的倒转个数与，合并是计算出的个数
     */
    private  int count = 0;

    public int getCount(){return count;}
    public void count(Comparable a[])
    {
        Comparable aux[] = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }

        count(a, aux, 0, a.length-1);
    }

    private void count(Comparable a[], Comparable aux[] , int lo,  int hi)
    {
        if (lo >= hi) return;

        int mi = lo+(hi-lo) /2;
        count(a, aux, lo, mi);
        count(a, aux, mi+1, hi);

        merge(a, aux, lo, mi, hi);
    }

    private boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }

    private void merge(Comparable a[], Comparable aux[], int lo, int mi, int hi)
    {
        int i = lo;
        int j = mi+1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <=hi; k++) {
            if(i>mi)
            {
                a[k] = aux[j++];
            } else if (j>hi) {
                a[k] = aux[i++];
            }
            else if(less(aux[j], aux[i]))
            {
                count++;
                count += mi-i;
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }

    }

    public static void main(String[] args) {
        Integer a[] = IntRandom.getIntRandom(7);

        Merge.show(a);
        StdOut.println("--------------");
        Exercise_2_1_19 counter = new Exercise_2_1_19();
        counter.count(a);

        StdOut.println(counter.getCount());
        StdOut.println("--------------");
        Merge.show(a);
    }
}
