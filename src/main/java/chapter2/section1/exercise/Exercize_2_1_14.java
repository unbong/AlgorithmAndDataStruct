package chapter2.section1.exercise;

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
}
