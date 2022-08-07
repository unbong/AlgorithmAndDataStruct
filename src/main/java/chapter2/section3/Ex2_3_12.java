package chapter2.section3;

import chapter2.Merge;
import edu.princeton.cs.algs4.StdOut;

public class Ex2_3_12 {

    public static void sort(Comparable a[], int lo, int hi, int pivot)
    {
        int i = lo+1;
        int lt = lo;
        int gt = hi;
        Comparable v = a[pivot];

        while(i<gt)
        {
            int comp = a[i].compareTo(v);
            // less
            if (comp < 0){
                exch(a, i++, lt++);
            }
            else if(comp > 0){
                exch(a,gt--, i);
            }
            else {
                i++;
            }
        }

        Merge.show(a);
        StdOut.println(lt);
        return ;

    }

    private  static void exch(Comparable a[], int i, int j)
    {


        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {

        Character a[] ={'B','A','B','A','B','A','B','A','C','A','D','A', 'B','R','A'};

        sort(a, 0, a.length-1, 0);
    }

}
