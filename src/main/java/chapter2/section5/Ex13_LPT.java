package chapter2.section5;

import chapter2.HeapSort;
import org.jetbrains.annotations.NotNull;

public class Ex13_LPT {
    public class Job implements Comparable<Ex13_LPT.Job>{
        private  String taskName;
        private double time;

        public Job(String name, double t)
        {
            time = t;
            taskName = name;
        }

        @Override
        public String toString() {

            return String.format("name: %s, time: %.1f", taskName, time);
        }

        @Override
        public int compareTo(@NotNull Ex13_LPT.Job o) {
            if(this.time>o.time) return 1;
            else if (time < o.time) return -1;
            return 0;
        }


        public void spot()
        {

        }

    }


    public void spot()
    {


    }


}
