package chapter6.SuffixArrays;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 *　找出文本中最长子字符串
 */
public class LRS {
    public static void main(String[] args) {

        String text = StdIn.readAll();
        int length = text.length();
        SuffixArrays sa = new SuffixArrays(text);

        String lrs = "";
        for (int i = 1; i < length; i++) {
            int lcp = sa.lcp(i);
            if(lcp > lrs.length()) lrs = sa.select(i).substring(i, lcp);
        }

        StdOut.println(lrs);
    }
}
