package chapter5.section1;

import edu.princeton.cs.algs4.StdOut;

/**
 * 3向切分快速排序
 */
public class Quick3String {


    private static final int CUTOFF_FOR_SMALLARRAYS =15;

    public static void sort(String[] strings){
        //StdRandom.shuffle(strings);
        sort(strings, 0, strings.length-1, 0);
    }

    private static void sort(String[] strings, int lo, int hi, int d){

        if(hi <= lo+CUTOFF_FOR_SMALLARRAYS) {
            insertion(strings, lo, hi, d);
            return;
        }

        int lt = lo;
        int gt = hi;
        int i = lo+1;

        int v = charAt(strings[lo],d);  // 当前基准数据

        while(i <= gt)
        {

            if(charAt(strings[i], d) > v) exch(strings, i, gt--);
            else if(charAt(strings[i],d) < v) exch(strings , i++,lt++);
            else i++;
        }

        sort(strings, lo, lt-1, d);
        if(v > 0) sort(strings, lt, gt, d+1);
        sort(strings, gt+1, hi, d);

    }

    private static void insertion(String[] strings, int lo, int hi, int d){

        for (int i = lo; i <=hi ; i++) {
            for (int j = i; j >lo && less(strings[j], strings[j-1], d) ; j--) {
                exch(strings, j ,j-1);
            }
        }
    }

    private static boolean less(String  v, String w, int d){
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private static void exch(String[] strings, int v, int w){
        String tmp = strings[v];
        strings[v] = strings[w];
        strings[w] = tmp;
    }

    private static int charAt(String string, int d)
    {
        if(d<string.length()) return string.charAt(d);
        return -1;
    }

    public static void main(String[] args) {

       String[] strings = {"void","read","we","found","goverment","wa","switch","waq","pwd",
                "aws","azure", "meme", "mema", "memb"};

        Quick3String.sort(strings);

        for (String s: strings){
            StdOut.println(s);
        }
    }
}
