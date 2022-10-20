package chapter5.section3;


import chapter1.section3.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * KMP 子字符串查找算法
 */
public class KMP {

    private final int[][] DFA ;
    private final int M ;

    public KMP(String pattern){
        int R = 256;            // 字符表大小
        M = pattern.length();   // 模式长度
        DFA = new int[R][M];    // 有限确定状态自动机
        DFA[pattern.charAt(0)][0] = 1;     // 初始值
        int X = 0;              // 影子状态初始索引

        for(int j = 1; j<M; j++){
            // X 的信息复制到j中
            for (int i = 0; i < R; i++) {
                DFA[i][j] = DFA[i][X];
            }
            // 对于匹配的情况设为j+1
            DFA[pattern.charAt(j)][j] = j+1;
            // 更新X 执行的结果为pattern.charAt 与 X索引的字符一致则表明出现了重复将X更新为X的下一个索引，
            // 其他则是将X设定为原来的值
            X = DFA[pattern.charAt(j)][X];
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

    private int searchFromIndex(String txt, int index){
        int N = txt.length();
        int i = index, j = 0;
        for ( ;i < N &&  j < M ; i++) {
            j = DFA[txt.charAt(i)][j];
        }
        if(j == M) return i-M;
        return N;
    }

    public int search(String txt)
    {
        return searchFromIndex(txt, 0);
//        int N = txt.length();   // 文本长度
//        int i = 0, j = 0;       // i 文本指针， j 模式指针
//        for ( ;i < N && j < M ; i++) {
//            // 根据文本字符与模式字符在DFA中的值来确定j
//            // 如果 两个字符匹配则 j向右移动
//            // 如果 两个字符不匹配 j向左移动
//            j = DFA[txt.charAt(i)][j];
//        }
//
//        if(j == M) return i-M;
//        return N;
    }

    public static void main(String[] args) {
        KMP s = new KMP("Substr");
        Iterable<Integer> i = s.searchAll("public class BruteForceSubstringSearch implements SubstringSearch");
        for(Integer it: i){
            StdOut.println(it);
        }

        KMP s1 = new KMP("ch");
        Iterable<Integer> i2 = s1.searchAll("public class BruteForceSubstringSearchch implements SubstringSearch");
        for(Integer it: i2){
            StdOut.println(it);
        }
    }
}
