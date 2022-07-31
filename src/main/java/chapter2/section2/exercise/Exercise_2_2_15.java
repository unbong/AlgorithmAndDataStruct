package chapter2.section2.exercise;

import chapter1.section3.Queue;
import edu.princeton.cs.algs4.StdOut;
import utils.IntRandom;

import java.util.Iterator;

public class Exercise_2_2_15 {



    public static Queue<Queue<Comparable>> sort(Comparable a[])
    {
        Queue<Queue<Comparable>> queue = new Queue<>();
        for(Comparable it: a)
        {
            Queue<Comparable> q = new Queue<>();
            q.enqueue(it);
            queue.enqueue(q);
        }



        while(queue.getSize() != 1)
        {
            Queue<Comparable> v = queue.dequeue();
            Queue<Comparable> w = queue.dequeue();
            Queue<Comparable> s = merge(v,w);
            queue.enqueue(s);
        }

        return queue;

    }


    public static Queue<Comparable> merge(Queue<Comparable> v, Queue<Comparable> w)
    {

        int v_s = v.getSize();
        int w_s = w.getSize();

        Queue<Comparable> res = new Queue<>();

        for (int i = 0; i < v_s+w_s; i++) {

            if(v.isEmpty())
            {
                res.enqueue(w.dequeue());
            }
            else if(w.isEmpty())
            {
                res.enqueue(v.dequeue());
            }
            else if(less(v.top(), w.top()))
            {
                res.enqueue(v.dequeue());
            }
            else{
                res.enqueue(w.dequeue());
            }
        }

        return res;

    }

    public static  void show(Queue<Comparable> a)
    {
        for (Iterator<Comparable> it = a.iterator(); it.hasNext(); ) {
            Comparable i = it.next();
            StdOut.print(" " + i.toString());
        }

        StdOut.println("");
    }

    public static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w)<0;
    }

    public static void main(String[] args) {

//        Queue<Comparable> v = new Queue<>();
//        Queue<Comparable> w = new Queue<>();
//        for (int i = 0; i < 10; i++) {
//
//            if(i%2 ==0)
//            {
//                v.enqueue(i);
//            }
//            else {
//                w.enqueue(i);
//            }
//        }


        Comparable[] a =IntRandom.getIntRandom(5);

        Exercise_2_2_10.show(a);
        StdOut.println(" ");
        Queue<Queue<Comparable>> s = sort(a);

        for (Iterator<Queue<Comparable>> it = s.iterator(); it.hasNext(); ) {
            Queue<Comparable> ss = it.next();
            StdOut.print(ss.dequeue().toString()+" ");

        }
    }
}
