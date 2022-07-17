package chapter1.section5;

import chapter1.section5.abst.UF;
import utils.StopWatch;

import java.io.*;
import java.util.ArrayList;

public class QuickFind extends UF {

    public int ac = 0;
    public QuickFind(int n)
    {
        super(n);
    }

    @Override
    public int find(int p) {
        ac++;
        return id[p] ;
    }

    @Override
    public void union(int p, int q) {
        int pVal = find(p);
        int qVal = find(q);

        if (pVal == qVal ) return;
        for (int i = 0; i < id.length; i++) {
            ac++;
            if(pVal == id[i])
            {
                ac++;
                id[i]= qVal;
            }
        }
        count--;
    }
    


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader( new FileReader("src/main/resources/mediumUF.txt"));

        String line = reader.readLine().trim();

        QuickFind qf = new QuickFind(Integer.valueOf(line).intValue());
        StopWatch watch = new StopWatch();
        ArrayList<Integer> c1 = new ArrayList<>();
        ArrayList<Integer> c2 = new ArrayList<>();
        int count1 =0;
        while((line = reader.readLine()) != null)
        {
            String[] pair = line.trim().split(" ");
            qf.union(Integer.valueOf(pair[0]).intValue(), Integer.valueOf(pair[1]).intValue());
            count1++;
        }

        String time = watch.elapsedTime();

        System.out.println("debug : time "+ time);
    }
}
