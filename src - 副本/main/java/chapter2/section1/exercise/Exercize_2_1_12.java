package chapter2.section1.exercise;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

public class Exercize_2_1_12 {


    Comparable a[] = null;

    public List<Double> data = new ArrayList<>();
    public int count = 0;

    public Exercize_2_1_12(Comparable arr[])
    {
        a = arr;
    }

    public void sort()
    {
        int h = 1;
        int N = a.length;
        while(h<N) h = 3*h+1;
        data.clear();
        while(h> 0)
        {

            count = 0;
            for (int i = h; i < N; i++)
            {
                for (int j = i; j >= h && less(a[j], a[j-h]) ; j-=h) {
                    exch(j, j-h);
                }
            }
            double ds =  (double)count /N;
            data.add(ds);
            h= h/3;
        }

    }

    public boolean less(Comparable v, Comparable w)
    {
        count++;
        return v.compareTo(w) <0;
    }

    public void exch(int j , int i)
    {
        Comparable tmp  = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    public void show()
    {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(" " +a[i]);
        }
    }

    public static void main(String[] args) {

        int N = 100;

        for (int i = 0; i < 4; i++) {
            Double a[]  = new Double[N];
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            Exercize_2_1_12 exe = new Exercize_2_1_12(a);
            exe.sort();

            for (int j = 0; j < exe.data.size(); j++) {
                StdOut.println(exe.data.get(j));
            }
        }




    }

}
