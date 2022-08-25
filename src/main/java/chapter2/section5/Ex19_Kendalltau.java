package chapter2.section5;

import edu.princeton.cs.algs4.Inversions;
import edu.princeton.cs.algs4.StdOut;


/**
 * 思路为 结合2.5.16 与归并排序时计算逆序的方法结合
 * 这里排序的顺序不是自然排序，而是以另一个数组为基准
 *
 */
public class Ex19_Kendalltau {

    public static int kendaltaulDistance(int a[], int b[])
    {
        int[] k = new int[a.length];

        for (int i = 0; i < k.length; i++) {
            k[b[i]] = i;
        }

        int count = count(a ,k);

        return count;

    }

    private static int count(int a[], int k[])
    {
        int aux[] = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            aux[i] = a[i];
        }

        return count(a, aux, k, 0, a.length-1);
    }

    private static int count(int a[] ,int aux[], int k[], int lo, int hi)
    {
        if(lo>=hi) return 0;
        int mid = lo + (hi-lo)/2;
        int count = count(a,aux,k, lo, mid);
        count += count(a,aux,k, mid+1, hi);
        count += merge(a, aux, k, lo,mid, hi);

        return count;
    }

    private static int merge(int a[], int aux[], int k[], int lo,int mid, int hi){

        int count = 0;
        int i = lo;
        int j = mid +1;
        for (int l = lo; l <=hi; l++) {
            aux[l] = a[l];
        }

        for (int l = lo; l <=hi; l++) {
            if(i > mid) a[l] = aux[j++];
            else if(j > hi) a[l] = aux[i++];
            else if(k[aux[j]]<k[aux[i]]) { a[l] = aux[j++]; count = mid-i+1; }
            else a[l] = aux[i++];
        }
        return count;
    }



    public static void main(String[] args) {
        int[] array1 = {0, 3, 1, 6, 2, 5, 4};
        int[] array2 = {1, 0, 3, 6, 4, 2, 5};

        int kendallTauDistance = new Ex19_Kendalltau().kendaltaulDistance(array1, array2);

        StdOut.println("Kendall tau Distance: " + kendallTauDistance + " Expected: 4");
    }
}
