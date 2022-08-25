package chapter2.section5;

import org.jetbrains.annotations.NotNull;
import utils.ArrayUtils;

import java.util.Arrays;

public class Ex12_SPT  {

    private class Job implements Comparable<Job>{
        private  String taskName;
        private double time;

        public Job(String name, double t)
        {
            time = t;
            taskName = name;
        }

        @Override
        public int compareTo(@NotNull Ex12_SPT.Job o) {
            if(this.time>o.time) return 1;
            else if (time < o.time) return -1;
            return 0;
        }

        @Override
        public String toString() {

            return String.format("name: %s, time: %.1f", taskName, time);
        }
    }


    public void print()
    {
        String allLine[] = {"JobA 100",
                "JobB 1",
                "JobC 999",
                "JobD 50",
                "JobE 0",
                "JobF 999999999"};
        Job job[] = new Job[allLine.length];
        for (int i = 0; i < allLine.length; i++) {
            String lineVal = allLine[i];
            String name = lineVal.split(" ")[0];
            double time = Double.parseDouble(lineVal.split(" ")[1]);
            job[i] = new Job(name, time);
        }

        Arrays.sort(job);
        ArrayUtils.show(job);
    }

    public static void main(String[] args) {

        Ex12_SPT spt = new Ex12_SPT();
        spt.print();
    }
}

