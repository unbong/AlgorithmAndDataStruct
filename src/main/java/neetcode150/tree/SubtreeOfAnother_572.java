package neetcode150.tree;

public class SubtreeOfAnother_572 {


    private boolean isSame(TreeNode p, TreeNode q)
    {
        if(p == null && q == null) return  true;
        if(p != null && q == null) return  false;
        if(p == null && q != null) return false;

        if( !isSame(p.left, q.left) ) return false;
        if(!isSame(p.right, q.right)) return false;
        if(p.val == q.val) return true;
        return  false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null && subRoot == null) return  true;
        if(root != null && subRoot == null) return  false;
        if(root == null && subRoot != null) return false;


        if(isSame(root,subRoot)) return true;
        if(isSubtree(root.left, subRoot)) return true;
        if(isSubtree(root.right, subRoot)) return true;

        return false;

    }
}
