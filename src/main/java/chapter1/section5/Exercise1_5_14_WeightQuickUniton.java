package chapter1.section5;

import utils.StopWatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise1_5_14_WeightQuickUniton {
    int id[];
    int sz[];
    int count;
    public int maxHeight = 0;

    public Exercise1_5_14_WeightQuickUniton(int n)
    {
        count = n;
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {

            id[i] = i;
            sz[i] = 0;
        }
    }

    public int getCount()
    {
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p)
    {
        while ( p != id[p]) p = id[p];

        return p;
    }

    /**
     * 用高度的比较来判断哪个为父节点
     * 当只有高度相同时，要对p的高度做加 1 处理，并且q的父节点为p
     * @param p
     * @param q
     */
    public void union(int p, int q)
    {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) return;

        if(sz[pRoot] > sz[qRoot] )
        {

            id[qRoot] = id[pRoot];

        }
        else if( sz[pRoot] < sz[qRoot]) {

            id[pRoot] = id[qRoot];

        }
        else {
            id[qRoot] = id[pRoot];
            sz[pRoot] ++;

            if(maxHeight < sz[pRoot]) maxHeight = sz[pRoot];
        }
        count--;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader("src/main/resources/mediumUF.txt"));

        String line = reader.readLine().trim();

        Exercise1_5_14_WeightQuickUniton qf = new Exercise1_5_14_WeightQuickUniton(Integer.valueOf(line).intValue());
        StopWatch watch = new StopWatch();
        while((line = reader.readLine()) != null)
        {
            String[] pair = line.trim().split(" ");
            qf.union(Integer.valueOf(pair[0]).intValue(), Integer.valueOf(pair[1]).intValue());
        }

        String time = watch.elapsedTime();
        System.out.println("debug : height " + qf.maxHeight);
        System.out.println("debug : time "+ time);
    }


}
