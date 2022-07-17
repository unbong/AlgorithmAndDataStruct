package chapter1.section5.abst;

public abstract class UF {

    public int[] id;
    public int count;
    public UF(int n)
    {
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int count(){return count;}

    public boolean connected(int p , int q){return find(p)== find(q);}

    public abstract int find(int p);

    public abstract void union(int p, int q);
}


