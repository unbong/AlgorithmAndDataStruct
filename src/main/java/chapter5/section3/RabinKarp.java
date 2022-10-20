package chapter5.section3;

import chapter1.section3.Queue;
import edu.princeton.cs.algs4.StdOut;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {

    private  long patHash;
    private final int M;

    private final long Q ;

    private int R = 256;

    private long RM ;

    public RabinKarp(String pattern){

        M = pattern.length();               // 模式长度
        Q = longRandomPrime();              // 2^31 左右的素数
        patHash = hash(pattern);            // 模式的哈希值
        RM = 1;
        for (int i = 0; i < M-1; i++) {
            RM = (RM * R) %Q;               // R^(M-1) 次的值
        }

    }

    public int count(String txt)
    {
        int N = txt.length();
        int index = 0;
        int count = 0;
        while(index < N ){
            index = searchFromIndex(txt, index);
            if(index != N) {
                count++;

            }
            index = index + M;
        }
        return count;
    }

    public Iterable<Integer> searchAll(String txt){
        int N = txt.length();
        int index = 0;

        Queue<Integer> queue = new Queue<>();
        while (index < N){
            index = searchFromIndex(txt, index);
            if(index != N) queue.enqueue(index);
            index = index+M;
        }
        return queue;
    }

    public int searchFromIndex(String txt, int index){
        int N = txt.length();

        // 前M个文本字符散列值
        if(N < index +M) return N;
        String s = txt.substring(index, index+M);
        long txtHash = hash(s);

        // 判断散列值是否相同
        if(txtHash == patHash) return index;

        // 文本位置index + M开始向右移动
        for (int i = index + M; i < N; i++) {
            char f = txt.charAt(i-M);
            char l = txt.charAt(i);
            txtHash = (txtHash + Q - RM * f %Q) % Q;
            txtHash = (txtHash *R + l) %Q;
            if(txtHash == patHash) return i-M+1;
        }

        return N;
    }

    public int search(String txt){
        return searchFromIndex(txt, 0);
//        int N = txt.length();
//        if(N<M) return N;
//        String s = txt.substring(0,M);      // 取得文本M个的的值用语计算哈希值
//        long txtHash= hash(s);              // 计算哈希值
//
//        if(txtHash == patHash) return 0;    // 如果相同则返回0位置
//
//        // 从M+1 开始计算哈希值 并判断是否存在值
//        for (int i = M; i < N; i++) {
//            char f = txt.charAt(i-M);       // 前一个文本中最右的字符
//            char l = txt.charAt(i);         // 新的字符
//            txtHash = (txtHash + Q -RM*f % Q)%Q;  // 去掉最左边字符的后的值，多加了一个Q 为了防止计算变成负数
//            txtHash = (txtHash * R + l) %Q;       // 往左移动之后，把新字符加到最右边后计算散列值。
//            if(txtHash == patHash ) return i - M+1;
//        }
//
//        return N;
    }

    private long hash(String s){
        int length = s.length();
        long h = 0;
        for (int i = 0; i < length; i++) {
            h = (h * R + s.charAt(i)) %Q;
        }
        return h;
    }

    private long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }


    public static void main(String[] args) {
        RabinKarp s = new RabinKarp("Substr");
        Iterable<Integer> i = s.searchAll("public class BruteForceSubstringSearch implements SubstringSearch");
        for(Integer it: i){
            StdOut.println(it);
        }

        StdOut.println();
        RabinKarp s1 = new RabinKarp("ch");
        Iterable<Integer> i2 = s1.searchAll("public class BruteForceSubstringSearchch implements SubstringSearch");
        for(Integer it: i2){
            StdOut.println(it);
        }
    }
}
