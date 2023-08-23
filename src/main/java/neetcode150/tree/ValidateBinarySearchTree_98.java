package neetcode150.tree;

public class ValidateBinarySearchTree_98 {

    private TreeNode min(TreeNode root){
        if(root.left == null) return root;
        return min(root.left);
    }

    private TreeNode max(TreeNode root){
        if(root.right == null) return root;
        return max(root.right);
    }

    /**
     * 如果当前节点的值，如果比左节点的最大值大，且比右节点的最小值小，则说明该节点是没问题，用这种方法对所有节点进行检查
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if(root== null) return true;

        if(!isValidBST(root.left)) return false;
        if(!isValidBST(root.right)) return false;

        if(root.left == null  && root.right != null)
        {
            TreeNode rightMin = min(root.right);
            if(  root.val < rightMin.val) return true;
            else return false;
        }
        else if(root.left != null  && root.right == null)
        {
            TreeNode leftMax = max(root.left);
            if(  root.val > leftMax.val) return true;
            else return false;
        }
        else if(root.left != null  && root.right != null){
            TreeNode rightMin = min(root.right);
            TreeNode leftMax = max(root.left);
            if( root.val > leftMax.val && root.val < rightMin.val) return true;
            else return false;
        }

        return true;
    }
}
