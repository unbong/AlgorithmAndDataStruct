package chapter5.section3;

import edu.princeton.cs.algs4.StdOut;

public class Ex04 {


    public static void main(String[] args) {
        Ex04 exercise4 = new Ex04();

        String text = " abacada  abr   braca  brabrabracad";

        int index1 = exercise4.findSpace(text, 1);
        StdOut.println("Index 1: " + index1 + " Expected: 0");

        int index2 = exercise4.findSpace(text, 2);
        StdOut.println("Index 2: " + index2 + " Expected: 8");

        int index3 = exercise4.findSpace(text, 3);
        StdOut.println("Index 3: " + index3 + " Expected: 13");

        int index4 = exercise4.findSpace(text, 4);
        StdOut.println("Index 4: " + index4 + " Expected: 35");
    }

    public int findSpace(String txt, int spaceSize){

        int N = txt.length();
        int R = 256;
        char SPACE = ' ';
        int[][] DFA = new int[R][spaceSize];
        int X = 0;

        DFA[SPACE][0] = 1;
        // 构建DFA
        for (int j = 1; j < spaceSize; j++) {
            for (int i = 0; i < R; i++) {
                DFA[i][j] = DFA[i][X];
            }

            DFA[SPACE][j] = j+1;

            X = DFA[SPACE][X];
        }

        // 根据文本与模式进行跳转
        int i = 0, j = 0;
        for ( ;i <= N-spaceSize && j < spaceSize; i++) {
            j = DFA[txt.charAt(i)][j];
        }

        if( j == spaceSize )
            return i -spaceSize; ;

        return N;
    }



}
