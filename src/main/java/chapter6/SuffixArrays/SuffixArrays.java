package chapter6.SuffixArrays;

import chapter2.Quick3way;
import edu.princeton.cs.algs4.StdOut;

public class SuffixArrays {

    private int length ;
    private String[] suffixes;        // sub strings


    public SuffixArrays(String text){

        length = text.length();
        suffixes = new String[length];

        for (int i = 0; i < length; i++) {
            suffixes[i] = text.substring(i);
        }

        Quick3way.sort(suffixes);
    }

    /**
     * 文本text长度
     * @return
     */
    public int length(){
        return length;
    }


    /**
     * 后缀数组中的第i个元素
     * @param i
     * @return
     */
    public String select(int i){
        if (i <0 || i > length-1) throw new IllegalArgumentException("i is not in range.");
        return suffixes[i];
    }


    /**
     * select(i)的索引
     *  每个子字符串的长度与子字符串的索引的和为 文本总长度length
     * @param i
     * @return
     */
    public int index(int i){
        if (i <0 || i > length-1) throw new IllegalArgumentException("i is not in range.");
        return  length - suffixes[i].length();
    }


    /**
     * select(i) 和select（i-1）的最长公共前缀的长度 i在1到N-1之间
     * @param i
     * @return
     */
    public int lcp(int i){
        if (i <1 || i > length-1) throw new IllegalArgumentException("i is not in range.");

        return lcp(suffixes[i], suffixes[i-1]);
    }

    /**
     * 取得两个字符串的最长公共前缀的长度
     * @param x
     * @param y
     * @return
     */
    public static int lcp(String x, String y){
        int N = Math.min(x.length(), y.length());

        for (int i = 0; i < N; i++)
            if(x.charAt(i)!=y.charAt(i))
                return i;

        return N;
    }

    /**
     * 小于键key的后缀数量
     * @param key
     * @return
     */
    public int rank(String key){

        int lo = 0;
        int hi = length-1;
        int mid = 0;

        while(lo <= hi){
            mid = (hi-lo)/2;
            int comp =  key.compareTo(suffixes[mid]);
            if(comp > 0)
                lo = mid+1;
            else if(comp < 0)
                hi = mid-1;
            else
                return mid;
        }

        return lo;
    }


    /**
     * 最长共同子字符串
     * @param s
     * @param t
     * @return
     */
    public static String LongestCommonSubstringConcatenate(String s, String t)
    {
        String text = s + '\1' + t;
        int text1Length = s.length();
        int text2Length = t.length();

        SuffixArrays sa = new SuffixArrays(text);
        int length = text.length();
        String lcs = "";
        for (int i = 1; i < length; i++) {
            int lcp = sa.lcp(i);

            if(sa.index(i-1) > text1Length && sa.index(i) > text1Length)
                continue;

            if(sa.index(i-1) < text1Length && sa.index(i) < text1Length)
                continue;
            if(lcp> lcs.length()  )
                lcs = sa.select(i).substring(0, lcp);

        }

        return lcs;
    }

    public static void main(String[] args) {
        String x = "it was the best of times it was the";

        SuffixArrays sa = new SuffixArrays(x);

        StdOut.println(String.format("select 9 exp: as thr best, select: %s ", sa.select(9)));

        StdOut.println(String.format("index 9 exp 4, index:%d", sa.index(9)));

        StdOut.println(String.format("lcp20 exp:10, lcp %d", sa.lcp(20)));

        StdOut.println(String.format("rank th exp 30, rank:%d", sa.rank("th")));

    }

}
