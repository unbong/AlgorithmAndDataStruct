package chapter5.section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * 暴力查询
 */
public class BruteSearch {

    private int M ;
    private String pattern;
    public BruteSearch(String pattern){
        M = pattern.length();
        this.pattern = pattern;
    }

    public int count(String txt){
        return searchAll(txt).size();
    }

    public Queue<Integer> searchAll(String txt){
        Queue<Integer> queue  = new Queue<>();
        int N = txt.length();
        for (int i = 0; i <= N-M; i++) {
            int j = 0;
            for (; j < M; j++) {
                if(this.pattern.charAt(j)!= txt.charAt(i+j))
                    break;
            }
            if(j == M) {
                queue.enqueue(i);
            }
        }
        return queue;
    }

    public int search(String txt){

        int N = txt.length();
        for (int i = 0; i <= N-M; i++) {
            int j = 0;
            for (; j < M; j++) {
                if(this.pattern.charAt(j)!= txt.charAt(i+j))
                    break;
            }
            if(j == M) return i;
        }
        return N;
    }

    public static int search(String pattern, String txt){

        int N = txt.length();
        int M = pattern.length();
        for(int i = 0;  i <= N-M ; i++){
            int j = 0;
            for(; j < M ; j++){
                if(pattern.charAt(j) != txt.charAt(i+j)){
                    break;
                }
            }

            if(j == M) return i;

        }
        return N;
    }

    public static int search2(String pattern , String txt){
        int N = txt.length();
        int M = pattern.length();
        int i;
        int j;
        for(i = 0, j = 0; j < M &&i<N; i++){

            if(txt.charAt(i) != pattern.charAt(j))
            {
                i -= j;
                j= 0;
            }else {
                j++;
            }

        }

        if(j ==M) return i-M;

        return N;
    }

    public static void main(String[] args) {
        BruteSearch s = new BruteSearch("Substr");
        Queue<Integer> i = s.searchAll("public class BruteForceSubstringSearch implements SubstringSearch");
        for(Integer it: i){
            StdOut.println(it);
        }

    }

}
