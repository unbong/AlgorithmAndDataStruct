package chapter5.section3;

import edu.princeton.cs.algs4.KMP;
import edu.princeton.cs.algs4.StdOut;

/**
 * 暴力查找 从右向左
 */
public class Ex05_BruteForceRL {

    private int M;
    private String pattern;

    public Ex05_BruteForceRL(String pattern){
        M = pattern.length();
        this.pattern = pattern;
    }

    public int search(String txt){
        int N = txt.length();

        for (int i = N-1; i >= M-1 ; i--) {
            int j = M-1;
            for (; j >=0 ; j--) {
                if(txt.charAt( i - M + 1 + j) != pattern.charAt(j))
                    break;
            }
            if(j < 0) return i - M  +1 ;
        }

        return N;
    }

    public static void main(String[] args) {
        Ex05_BruteForceRL ex = new Ex05_BruteForceRL("iamman");

        int i = ex.search("public class BruteForceSubstringSearch implements SubstringSearchiamman");
        int j = ex.search("public class BruteiammanForceSubstringSearch implements SubstringSearch");
        int s = ex.search("public class BruteiammaForceSubstringSearch implements SubstringSearch");

        StdOut.println("exp: 65, index: "+ i);
        StdOut.println("exp: 18, index: "+ j);
        StdOut.println("exp: 70, index: "+ s);


    }
}
