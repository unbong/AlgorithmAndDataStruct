package chapter5.secton1.Ex;

import chapter1.section3.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Ex07_QueueCount {

    private static final int R = 256;
    private static final int CUTOFF = 15;
    private static String[] aux;

    private static void sort(String[] strings, int d){


        int N = strings.length;
        aux = new String[N];

        for (int m = d-1; m >= 0; m--) {
            Queue<String>[] queues = new Queue[R+1];
            for (int i = 0; i <=R; i++) {
                queues[i] = new Queue<>();
            }
            // 统计频率

            for (int i = 0; i < N; i++) {
                queues[charAt(strings[i], m)+1].enqueue(strings[i]);
            }

            int insertIndex = 0;
            for (int i = 0; i <= R; i++) {
                while(!queues[i].isEmpty())
                {
                    aux[insertIndex++] = queues[i].dequeue();
                }
            }

            for (int i = 0; i < N; i++) {
                strings[i] = aux[i];
            }
        }

    }

    private static int charAt(String s, int d){
        if(d < s.length()) return s.charAt(d);
        return -1;
    }


    public static void main(String[] args) {
        String[] array = {"4PGC938",
                "2IYE230",
                "3CIO720",
                "1ICK750",
                "1OHV845",
                "4JZY524",
                "1ICK750",
                "3CIO720",
                "1OHV845",
                "1OHV845",
                "2RLA629",
                "2RLA629",
                "3ATW723"};
        Ex07_QueueCount.sort(array,7 );

        for (int i = 0; i < array.length; i++) {
            StdOut.print(array[i] + " ");
        }
        StdOut.println("Expected: \n" +
                "1ICK750 1ICK750 1OHV845 1OHV845 1OHV845 2IYE230 2RLA629 2RLA629 3ATW723 3CIO720 3CIO720 " +
                "4JZY524 4PGC938");

    }
}
