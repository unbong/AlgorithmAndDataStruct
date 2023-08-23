package neetcode150.tree;

/**
 * 最小共同祖先
 *
 */
public class LSA_235 {


    private TreeNode findElement(TreeNode root, TreeNode node)
    {
        if(root == null) return null;
        if(root.val == node.val) return root;
        else if(root.val > node.val) return findElement(root.left, node);
        else return findElement(root.right, node);
    }

    /**
     * 最小共同祖先
     * todo
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        if(root.val == p.val ){
            // 在已经找到p时，去找q是否在树中如果存在，则说明最小共同祖先为p
            TreeNode res = root;
            TreeNode node = findElement(root, q);
            if(node == null)
                return null;
            else
                return res;

        }

        if(root.val == q.val){
            // q已经找到，p还没找到
            TreeNode res = root;
            TreeNode node = findElement(root, p);
            if(node == null)
                return null;
            else
                return res;
        }

        if( root.val > p.val && root.val > q.val )
        {
            // 两者在都比当前比较的节点小，转移到左侧进行比较
            return lowestCommonAncestor(root.left, p,q);

        }

        if(root.val < p.val && root.val < q.val)
        {
            // 两者在都比当前比较的节点大，转移到右侧进行比较
            return lowestCommonAncestor(root.right, p,q);
        }

        if( (root.val < p.val && root.val > q.val) || (root.val < q.val && root.val > p.val) )
        {
            TreeNode res = root;
            TreeNode p_;
            TreeNode q_;
            if(p.val > q.val)
            {
                p_ = findElement(root.right, p);
                q_ = findElement(root.left, q);


            }
            else{
                p_ = findElement(root.left, p);
                q_ = findElement(root.right, q);
            }
            if(p_ == null || q_ == null) return null;
            return res;

        }

        return  null;
    }
}
