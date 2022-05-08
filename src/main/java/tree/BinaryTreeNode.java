package tree;

public class BinaryTreeNode<T>{


    public BinaryTreeNode(T val)
    {
        value = val;
        left = null;
        right = null;
    }

    private T value;

    public T getValue() {
        return value;
    }
    private BinaryTreeNode left = null;
    private BinaryTreeNode right = null;

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }



    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }
}
