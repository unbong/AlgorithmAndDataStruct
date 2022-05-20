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

    public void setValue(T val) {this.value = val;}
    private BinaryTreeNode<T> left = null;
    private BinaryTreeNode<T> right = null;

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }



    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }
}
