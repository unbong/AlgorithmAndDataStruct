package chapter1.section5;

import chapter1.section5.abst.UF;

/**
 * 路径压缩QuickUnion
 */
public class QuickUnionUFPathCompression extends UF {


    public QuickUnionUFPathCompression(int n) {
        super(n);
    }

    @Override
    public int find(int p) {
        int pRoot  = p ;
        while (pRoot != id[pRoot]) pRoot = id[pRoot];

        while (p != id[p])
        {
            int tmp = id[p];
            id[p] = pRoot;
            p = tmp;
        }

        return pRoot;
    }

    @Override
    public void union(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }
}
