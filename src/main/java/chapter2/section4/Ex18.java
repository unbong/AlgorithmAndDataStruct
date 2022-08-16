package chapter2.section4;

import chapter2.PriorityQueue;
import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

public class Ex18 {

    public static void main(String[] args) {

        Integer a[] = IntRandom.getIntRandom(9);

        PriorityQueue<Integer> pq = new PriorityQueue<>(a, PriorityQueue.Orientation.MAX);

        while (!pq.isEmpty()){
            StdOut.print(pq.max()+", ");
        }

        PriorityQueue<Integer> mpq = new PriorityQueue<>(a, PriorityQueue.Orientation.MIN);

        while (!mpq.isEmpty()){
            StdOut.print(mpq.max()+", ");
        }
    }

}
