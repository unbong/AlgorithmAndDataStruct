package chapter2.section4;

import chapter2.PriorityQueue;
import utils.IntRandom;

public class Ex18 {

    public static void main(String[] args) {

        Integer a[] = IntRandom.getIntRandom(9);

        PriorityQueue<Integer> pq = new PriorityQueue<>(a, PriorityQueue.Orientation.MAX);


    }

}
