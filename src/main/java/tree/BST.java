package tree;

import stack.ListStack;
import stack.Stack;

public class BST <T extends Comparable<T>>{

    private BinaryTreeNode<T> root = null;


    public BinaryTreeNode<T> findMax(BinaryTreeNode<T> root)
    {
        BinaryTreeNode<T> tmpRoot = root;
        while(tmpRoot.getRight() != null)
        {
            tmpRoot = tmpRoot.getRight();
        }

        return tmpRoot;
    }

    public BinaryTreeNode<T> findMin(BinaryTreeNode<T> root)
    {
        BinaryTreeNode<T> tmpRoot = root;
        while(tmpRoot.getLeft() != null)
        {
            tmpRoot = tmpRoot.getLeft();
        }

        return tmpRoot;
    }

    public void addNode(T val)
    {
        BinaryTreeNode<T> tmpRoot = root;
        BinaryTreeNode<T> newNode = new BinaryTreeNode<>(val);

        if(root == null)
        {
            root = newNode;
        }
        else{
            while(true)
            {
                if(tmpRoot.getValue().compareTo(newNode.getValue())>0)
                {
                    if(tmpRoot.getLeft() == null)
                    {
                        tmpRoot.setLeft(newNode);
                        break;
                    }else
                    {
                        tmpRoot = tmpRoot.getLeft();
                    }

                }
                else
                {
                    if(tmpRoot.getRight() == null)
                    {
                        tmpRoot.setRight(newNode);
                        break;
                    }else
                    {
                        tmpRoot = tmpRoot.getRight();
                    }
                }
            }
        }
    }


    private void deleteNode(T val , BinaryTreeNode<T> root){
        BinaryTreeNode<T> tmpRoot = root;
        BinaryTreeNode<T> parentNode = root;
        while(true)
        {
            if(tmpRoot.getValue().compareTo(val)>0)
            {
                parentNode = tmpRoot;
                tmpRoot = tmpRoot.getLeft();
            }
            else if(tmpRoot.getValue().compareTo(val)< 0)
            {
                parentNode = tmpRoot;
                tmpRoot = tmpRoot.getRight();
            }
            // 找到了对应的值
            else{

                // 叶子节点
                if(tmpRoot.getLeft() == null && tmpRoot.getRight() == null)
                {
                    if(parentNode.getRight() == tmpRoot)
                    {
                        parentNode.setRight(null);
                    }

                    if(parentNode.getLeft() == tmpRoot){
                        parentNode.setLeft(null);
                    }
                }
                // 只有一个子节点
                else if( (tmpRoot.getLeft() == null && tmpRoot.getRight() != null) ||
                        (tmpRoot.getLeft() != null && tmpRoot.getRight() == null))
                {

                    if(tmpRoot.getRight() != null)
                    {
                        if(parentNode.getLeft() == tmpRoot )
                        {
                            parentNode.setLeft(tmpRoot.getRight());
                        }
                        else {
                            parentNode.setRight(tmpRoot.getRight());
                        }
                    }else if(tmpRoot.getLeft() != null)
                    {
                        if(parentNode.getLeft() == tmpRoot )
                        {
                            parentNode.setLeft(tmpRoot.getLeft());
                        }
                        else {
                            parentNode.setRight(tmpRoot.getLeft());
                        }
                    }
                }
                // 两个子节点
                else{
                    // 从子的左节点取得最大值
                    BinaryTreeNode<T> tmpMaxNode =  findMax(tmpRoot.getLeft());
                    // 删掉最大值
                    deleteNode(tmpMaxNode.getValue(), tmpRoot);

                    tmpRoot.setValue(tmpMaxNode.getValue());

                }

                break;
            }

        }

    }
    public void deleteNode(T val)
    {
        deleteNode(val,this.root);

    }

    public void inOrder()
    {
        Stack<BinaryTreeNode<T>> stack = new ListStack<>();
        BinaryTreeNode<T> tmpRoot = this.root;
        while(true)
        {
            while(tmpRoot != null)
            {
                stack.push(tmpRoot);
                tmpRoot = tmpRoot.getLeft();


            }

            if(stack.isEmpty() )
            {
                break;
            }
            tmpRoot = stack.pop();
            System.out.println(tmpRoot.getValue().toString());

            tmpRoot = tmpRoot.getRight();

        }
    }
}
