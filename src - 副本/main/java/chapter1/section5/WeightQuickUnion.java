package chapter1.section5;

import utils.StopWatch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class WeightQuickUnion {

    private int id[];
    private int count;
    private int sz[];

    public WeightQuickUnion(int n)
    {
        id = new int[n];
        sz = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p , int q)
    {
        return find(p) == find(q);
    }

    public int find(int p )
    {
        while (p != id[p]) p = id[p];
        return p;
    }

    public void union(int p,int q)
    {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;
        if(sz[pRoot] > sz[qRoot])
        {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }else {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        count--;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader("src/main/resources/mediumUF.txt"));

        String line = reader.readLine().trim();

        WeightQuickUnion qf = new WeightQuickUnion(Integer.valueOf(line).intValue());
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
