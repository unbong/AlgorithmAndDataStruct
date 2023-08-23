package neetcode150.tree;

public class KthSmallestElementInBST_230 {

    class Int{
        int k ;
    }

    private int find(TreeNode root, int k, Int n){

        if(root == null ) return -1;
        int res = find(root.left, k , n);
        if( -1 != res) return res;
        if(n.k == k) return root.val;
        else {
            int tmp = n.k;
            tmp++;
            n.k = tmp;
        }
        res = find(root.right, k ,n);
        if(-1!=res) return res;
        return -1;

    }

    public int kthSmallest(TreeNode root, int k) {
        Int n = new Int();
        n.k = 1;
        return find(root, k, n);
    }
}
