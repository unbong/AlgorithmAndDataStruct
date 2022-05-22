package tree;

public class AVLTreeNode<T> {

    private T value;
    private AVLTreeNode<T> left = null;
    private AVLTreeNode<T> right = null;
    private int height = 0;


    public AVLTreeNode(T val)
    {
        this.value = val;
    }
    public AVLTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLTreeNode<T> left) {
        this.left = left;
    }

    public AVLTreeNode<T> getRight() {
        return right;
    }

    public void setRight(AVLTreeNode<T> right) {
        this.right = right;
    }

    public int getHeight() {
        int h = 0;
        if(left == null && right == null)
        {
            h = 0;
        }
        else if(left == null && right != null)
        {
            h =  right.getHeight() +1;
        }
        else if(left != null && right == null)
        {
            h = left.getHeight()+1;
        }
        else {
            h = Math.max(right.getHeight(), left.getHeight()) +1;
        }

        return h;
    }

    public void updateHeight()
    {
        if(left == null && right == null)
        {
            height= 0;
        }
        else if(left == null && right != null)
        {
            height =  right.getHeight() +1;
        }
        else if(left != null && right == null)
        {
            height= left.getHeight()+1;
        }
        else {
            height = Math.max(right.getHeight(), left.getHeight()) +1;
        }
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
