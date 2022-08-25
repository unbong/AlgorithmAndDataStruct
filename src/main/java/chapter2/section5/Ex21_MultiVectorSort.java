package chapter2.section5;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import utils.ArrayUtils;
import utils.IntRandom;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex21_MultiVectorSort {

    public static void sort(Comparable a[][])
    {
        int N = a.length;
        int M = a[0].length;
        List<List<Integer>> samePosition  = new ArrayList<>();

        for (int i = 0; i < M; i++) {

            if(i == 0 && samePosition.size() == 0){

                Comparable v[] = new Comparable[N];
                for (int j = 0; j < N; j++) {
                    v[j] = a[j][i];
                }
                sort(v, a, 0, v.length-1);

                int start = 0;
                int end = 0;
                int count = 0;
                for (int j = 1; j < v.length; j++) {

                    if(v[j-1].compareTo(v[j]) == 0)
                    {
                        if(start == 0) start = j-1;
                        count++;

                        if( j== v.length-1  )
                        {
                            end = start + count;
                            List<Integer> ls = new ArrayList<>();
                            ls.add(start);
                            ls.add(end);
                            samePosition.add(ls);
                        }
                    }
                    else{
                        end = start + count;

                        if(count > 0)
                        {
                            List<Integer> ls = new ArrayList<>();
                            ls.add(start);
                            ls.add(end);
                            samePosition.add(ls);
                        }
                        start = 0;
                        end = 0;
                        count = 0;
                    }
                }
    
            }
            else if(samePosition.size() > 0) {
                Comparable v[] = new Comparable[N];
                for (int j = 0; j < N; j++) {
                    v[j] = a[j][i];
                }

                for (int j = 0; j < samePosition.size(); j++) {
                    int start = samePosition.get(j).get(0);
                    int end = samePosition.get(j).get(1);
                    sort(v, a, start, end);
                }
                samePosition.clear();
            }
            //else break;

        }

    }

    private static void sort(Comparable v[] , Comparable a[][], int lo, int hi)
    {
        if(lo >= hi) return;

        int j = partition(v, a, lo, hi);

        sort(v, a, lo, j-1);
        sort(v,a, j+1, hi);
    }

    private static int partition(Comparable v[], Comparable a[][], int lo, int hi)
    {
        int i  = lo;
        int j = hi+1;
        Comparable k = v[lo];
        while(true)
        {
            while(ArrayUtils.less(v[++i],k)){ if(i==hi) break; }
            while(ArrayUtils.less(k, v[--j])) {if(j==lo) break; }
            if(i>=j) break;

            exch(v,a, i , j);

        }

        exch(v, a , lo , j);
        return j;
    }

    private static void exch(Comparable[] v, Comparable[][] a, int i, int j) {

        Comparable tmp[] = a[i];
        a[i] = a[j];
        a[j] = tmp;

        ArrayUtils.exch(v, i, j);

    }

    public static void main(String[] args) {

        Integer a[] = IntRandom.getIntRandom(9);
        Integer b[] = IntRandom.getIntRandom(9);
        Integer d[] = IntRandom.getIntRandom(9);
        Integer e[] = IntRandom.getIntRandom(9);
        Integer f[] = IntRandom.getIntRandom(9);
        Integer c[][] = {a, b,d,e,f};

        sort(c);
        for (int i = 0; i < c.length; i++) {
            ArrayUtils.show(c[i]);
        }
        StdOut.println("");
    }

}
