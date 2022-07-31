package chapter2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

/**
 * 插入排序
 */
public class Insertion {

    public static void sort(Comparable a[], int lo, int hi)
    {
        for (int i = lo+1; i <= hi; i++) {
            for (int j = i; j>lo && less(a[j], a[j-1]) ; j--) {
                exch(a, i , j);
            }
        }
    }

    public static void sort(Comparable a[])
    {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j],a[j-1] ) ; j--)
            {
                exch(a, j, j-1);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)< 0;
    }

    private  static void exch(Comparable a[], int i, int j)
    {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean isSorted(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++) {
            if(less(a[i], a[i-1]) ) return false;
        }
        return  true;
    }

    private static void  draw(Comparable[]  a, int i, int j)
    {
        StdDraw.clear();

        StdDraw.setPenColor(StdDraw.RED);

        
    }

    public static void show(Comparable a[]){
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i].toString()+ " ");
        }
    }


    public static void main(String[] args) {

        Integer s[] = new Integer[10];

        for (int i = 0; i < 10; i++) {
            s[i] = new Random().nextInt(10);
        }
        Insertion.show(s);
        Insertion.sort(s);
        StdOut.println("");
        Insertion.show(s);

    }

}
