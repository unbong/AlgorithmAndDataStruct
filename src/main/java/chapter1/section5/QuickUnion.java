package chapter1.section5;

import chapter1.section5.abst.UF;
import utils.StopWatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuickUnion extends UF {

    public QuickUnion(int n)
    {
        super(n);
    }
    @Override
    public int find(int p) {

        while(p != id[p]) p = id[p];
        return id[p];
    }

    @Override
    public void union(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader("src/main/resources/mediumUF.txt"));

        String line = reader.readLine().trim();

        QuickUnion qf = new QuickUnion(Integer.valueOf(line).intValue());
        StopWatch watch = new StopWatch();
        while((line = reader.readLine()) != null)
        {
            String[] pair = line.trim().split(" ");
            qf.union(Integer.valueOf(pair[0]).intValue(), Integer.valueOf(pair[1]).intValue());
        }

        String time = watch.elapsedTime();

        System.out.println("debug : time "+ time);
    }
}
