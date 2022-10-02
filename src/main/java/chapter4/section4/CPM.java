package chapter4.section4;


import edu.princeton.cs.algs4.AcyclicLP;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 关键路径
 * todo
 * < /Users/unbong/IdeaProjects/AlgorithmLearn/src/test/resources/jobsPC.txt
 */
public class CPM {

    public static void main(String[] args) throws FileNotFoundException {
        // number of jobs

        //Scanner scanner = new Scanner("/Users/unbong/IdeaProjects/AlgorithmLearn/src/test/resources/jobsPC.txt");
        System.setIn(new FileInputStream("/Users/unbong/IdeaProjects/AlgorithmLearn/src/test/resources/jobsPC.txt"));
        int n = StdIn.readInt();

        // source and sink
        int source = 2*n;
        int sink   = 2*n + 1;

        // build network
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(2*n + 2);
        for (int i = 0; i < n; i++) {

            double duration = StdIn.readDouble();
            G.addEdge(new DirectedEdge(source, i, 0.0));
            G.addEdge(new DirectedEdge(i+n, sink, 0.0));
            G.addEdge(new DirectedEdge(i, i+n,    duration));

            // precedence constraints
            int m = StdIn.readInt();
            for (int j = 0; j < m; j++) {
                int precedent = StdIn.readInt();
                G.addEdge(new DirectedEdge(n+i, precedent, 0.0));
            }
        }

        // compute longest path
        AcyclicLongestPath lp = new AcyclicLongestPath(G, source);

        // print results
        StdOut.println(" job   start  finish");
        StdOut.println("--------------------");
        for (int i = 0; i < n; i++) {
            StdOut.printf("%4d %7.1f %7.1f\n", i, lp.distTo(i), lp.distTo(i+n));
        }
        StdOut.printf("Finish time: %7.1f\n", lp.distTo(sink));
    }
}
