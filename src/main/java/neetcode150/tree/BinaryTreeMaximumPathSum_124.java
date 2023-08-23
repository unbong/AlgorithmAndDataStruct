package neetcode150.tree;

public class BinaryTreeMaximumPathSum_124 {


    private int max(TreeNode root, int[] res)
    {
        if(root == null) return 0;

        int leftSum = max(root.left,res);
        int rightSum = max(root.right,res);

        if(leftSum >=0 && rightSum >= 0)
            res[0] = Math.max(res[0], (rightSum+leftSum+root.val));
        else if (leftSum <=0 && rightSum >= 0)
            res[0] = Math.max(res[0], (rightSum+root.val));
        else if(leftSum >=0 && rightSum <= 0)
            res[0] = Math.max(res[0], (leftSum+root.val));
        else
            res[0] = Math.max(res[0], (root.val));

        if(leftSum>rightSum && leftSum>=0){
            return leftSum+root.val;
        }
        else if(leftSum < rightSum && rightSum>=0) {
            return rightSum+root.val;
        }
        else
            return root.val;
    }

    public int maxPathSum(TreeNode root) {

        int[] res ={Integer.MIN_VALUE};
        max(root, res);
        return res[0];
    }

}
