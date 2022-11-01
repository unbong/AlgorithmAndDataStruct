package chapter6.SuffixArrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 在找出文中关键字的向下文
 */
public class KWIC {

    public static void main(String[] args) {

        In in = new In(args[0]);
        int context = Integer.parseInt(args[1]);

        String text = in.readAll().replaceAll("\\s+", " ");
        SuffixArrays sa = new SuffixArrays(text);
        int length = text.length();

        while(StdIn.hasNextLine())
        {
            String q = StdIn.readLine();
            for (int i = sa.rank(q); i < length && sa.select(i).startsWith(q); i++) {
                int from = Math.max(0, sa.index(i) - context);
                int to = Math.min(length-1, from + q.length()+2*context);

                StdOut.println(text.substring(from, to));
            }
        }

        StdOut.println();
    }
}
