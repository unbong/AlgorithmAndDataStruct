package chapter5.section3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Boyer-Moore字符串查找算法
 */
public class BoyerMoore {

    private final int M ;
    private final int[] right;

    private String pattern;

    public BoyerMoore(String pattern){
        int R = 256;
        M = pattern.length();  // 模式字符串长度
        right = new int[R];    // 字符表大小的数组中，字符在模式字符串中出现的最右的索引
        this.pattern = pattern;

        // right数组初始化为-1
        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }

        // 记录最右索引
        for (int i = 0; i < M; i++) {
            right[pattern.charAt(i)] = i;
        }
    }


    public Iterable<Integer> searchAll(String txt){
        Queue<Integer> queue = new Queue<>();
        int index = 0;
        int N = txt.length();
        while(index < N){
            index = searchFromIndex(txt, index);
            if(index != N ) queue.enqueue(index);
            index = index+M;
        }
        return queue;
    }

    public int count(String txt){
        int count = 0;
        int index = 0;
        int N = txt.length();
        while(index < N){

            index = searchFromIndex(txt, index);
            if(index != N) count++;
            index = index + M;
        }
        return count;
    }

    private int searchFromIndex(String txt, int index){

        int N = txt.length();
        int i = index;
        int j = M-1;

        //从左向右移动
        for(; i <= N-M ; i++){
            j = M-1;
            // 从右向左移动
            for(; j>=0; j--){
                if(txt.charAt(i+j) != pattern.charAt(j))
                {
                    if(j - right[txt.charAt(i+j)] > 0)
                        i = i + j - right[txt.charAt(i+j)]-1;

                    break;
                }
            }
            if(j < 0) return i;
        }
        return N;
    }


    public int search(String txt){

        return searchFromIndex(txt, 0);
//        int N = txt.length();   // 文本长度
//
//        // 外循环 i 从左向右移动
//        for (int i = 0; i <= N-M; i++) {
//            int j = M-1;
//            // 内循环 模式指针 j 从右向左移动
//            for (; j >=0 ; j--) {
//                // 当字符不匹配时，3种情况
//                // 字符不在right数组中， j +1 其中不存在索引为-1 因此 j-right[不存在字符](-1) 刚好满足。
//                // 字符在right数组中，j-right[存在字符] 则将i向右移动 j-right[存在字符]个字符
//                // 字符在right数组中, 但是j-right[存在字符]<0 则将i 向右移动1个字符
//                if(txt.charAt(i+j) != pattern.charAt(j))
//                {
//                    if( j - right[txt.charAt(i+j)] >= 0){
//                        i = i + j-right[txt.charAt(i+j)]-1;
//                    }
//                    break;
//                }
//            }
//
//            if(j < 0) return i;
//        }
//
//        return N;
    }

    public static void main(String[] args) {
        BoyerMoore s = new BoyerMoore("Substr");
        Iterable<Integer> i = s.searchAll("public class BruteForceSubstringSearch implements SubstringSearch");
        for(Integer it: i){
            StdOut.println(it);
        }

        StdOut.println();
        BoyerMoore s1 = new BoyerMoore("ch");
        Iterable<Integer> i2 = s1.searchAll("public class BruteForceSubstringSearchch implements SubstringSearch");
        for(Integer it: i2){
            StdOut.println(it);
        }

        StdOut.println();
        BoyerMoore s2 = new BoyerMoore("cfa");
        Iterable<Integer> i3 = s2.searchAll("abcbacfab");
        for(Integer it: i3){
            StdOut.println(it);
        }

    }
}
