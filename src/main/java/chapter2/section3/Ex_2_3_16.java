package chapter2.section3;

import chapter2.Merge;

public class Ex_2_3_16 {

    public static Comparable[] madeData(int N)
    {
        Comparable a[] = new Comparable[N];
        for (int i = 0; i < a.length; i++) {
            a[i] = i+1;

        }
        madeData(a,0 ,N-1,true);

        return a;
    }

    private static Comparable[] madeData(Comparable a[], int lo, int hi, boolean isLeft)
    {
        if (lo>=hi) return a;
        int loc = 0;
        Comparable b[] = new Comparable[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];

        }
        int mid = lo + (hi-lo)/2;

        Comparable v = a[mid];

        if (isLeft)
        {a[lo] = v; loc++;}
        else a[hi] = v;


        int leftCount = mid-lo;
        int rightCount = hi-mid;
        Comparable tmpA[] = new Comparable[leftCount];
        Comparable tmpB[] = new Comparable[rightCount];

        for (int i = 0; i < leftCount; i++) {
            tmpA[i] = b[lo+i];
        }

        for (int i = 0; i < rightCount; i++) {
            tmpB[i] = b[mid+1+i];
        }


        Comparable resLeft[] = madeData(tmpA, 0, leftCount-1 , true);

        Comparable resRight[] = madeData(tmpB,  0, rightCount-1, false);


        for (int i = 0; i < rightCount; i++) {
            a[loc+i] = resRight[i];
            loc++;
        }

        for (int i = 0; i < leftCount; i++) {
            a[loc+i] = resLeft[i];
            loc++;
        }

        return a;
       }

    public static void main(String[] args) {

        Comparable a[] =madeData(9);
        Merge.show(a);


    }
}
