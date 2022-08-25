package chapter2.section1.exercise;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 出列排序
 */
public class Exercize_2_1_14 {

    Comparable a[];
    public Exercize_2_1_14(Comparable arr[])
    {
        a = arr;
    }

    public void sort()
    {
        boolean isFirst = true;
        Comparable mark = a[0];
        boolean isChanged = false;
        while (true){
            show();

            if(mark.compareTo(a[1]) ==0)
            {
                isFirst = true;
                if(isChanged)
                {
                    isChanged = false;
                }
                else {
                    Comparable tmp = a[0];
                    for (int j = 0; j < a.length-1; j++) {
                        a[j] = a[j+1];
                    }
                    a[a.length-1] = tmp;
                    break;
                }
            }else {
                //
                if(less(a[1], a[0]))
                {
                    exch(0, 1);
                    if (isFirst) mark = a[0];
                    isChanged = true;
                }else{
                    if (isFirst) mark = a[0];
                }

                isFirst = false;
            }

            Comparable tmp = a[0];
            for (int j = 0; j < a.length-1; j++) {
                a[j] = a[j+1];
            }
            a[a.length-1] = tmp;




        }
    }
    public boolean less(Comparable v , Comparable w)
    {
        return v.compareTo(w) < 0;
    }

    public void exch(int i, int j)
    {
        Comparable tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }

    public void show()
    {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(" "+ a[i]);
        }
        StdOut.println("");
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Integer a[] = new Integer[5];

        for (int i = 0; i < 5; i++) {
            list.add(i+1);
        }
        Collections.shuffle(list);

        for (int i = 0; i < 5; i++) {
            a[i] = list.get(i);
        }
        Exercize_2_1_14 exe = new Exercize_2_1_14(a);
        exe.show();
        exe.sort();
        exe.show();
    }
}
