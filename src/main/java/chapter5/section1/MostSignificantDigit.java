package chapter5.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 高位优先排序
 */
public class MostSignificantDigit {
    private static final int R = 256;
    private static final int CUTOFF_FOR_SMALLARRAYS =15;

    private MostSignificantDigit(){}
    public static void msdSort(String[] strings){
        if (strings == null ) throw new IllegalArgumentException("string is null.");

        int N = strings.length;
        String[] aux = new String[N];
        msdSort(strings, 0, N, 0, aux);
    }

    private static void msdSort(String[] strings, int lo, int hi, int d, String[] aux){
        int N = strings.length;
        if(hi<lo + CUTOFF_FOR_SMALLARRAYS){
            insertion(strings,lo, hi, d);
            return;
        }

        // 字符串末尾值返回-1的约定，因此需要增加一个末尾值
        int[] count = new int[R+2];

        //统计频率
        for (int i = lo; i < hi; i++) {
            count[charAt(strings[i],d)+2]++;
        }

        // 转化为索引
        for (int i = 0; i < R+1; i++) {
            count[i+1] += count[i];
        }

        //将元素分类
        for (int i = lo; i < hi; i++) {
            aux[count[charAt(strings[i],d)+1]++] = strings[i];
        }
        
        //回写
        for (int i = lo; i < hi ; i++) {
            strings[i] = aux[i-lo];
        }
        //　递归的以每个字符为键进行排序
        for (int i = 0; i < R; i++) {
            msdSort(strings, lo+count[i], lo+count[i+1], d+1, aux );
        };
    }

    private static void insertion(String a[], int lo, int hi, int d)
    {
        for (int i = lo; i < hi ; i++) {
            for(int j = i; j > lo && less( a[j], a[j-1], d); j-- )
            {
                exch(a, j , j-1);
            }
        }
    }

    private static boolean less(String v, String w, int d)
    {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private static void exch(String[] a, int v, int w)
    {
        String tmp = a[v];
        a[v] = a[w];
        a[w] = tmp;
    }
    private static int charAt(String string, int d){
        if(d<string.length()) return string.charAt(d);
        return -1;
    }

    public static void main(String[] args) {
        String[] strings = {"void","read","we","found","goverment","wa","switch","waq","pwd"};

        MostSignificantDigit.msdSort(strings);

        for (String s: strings){
            StdOut.println(s);
        }
    }
}
