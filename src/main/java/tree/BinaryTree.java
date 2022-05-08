package tree;

import stack.ArrayStack;
import stack.ListStack;

import java.util.ArrayDeque;
import java.util.Comparator;

public class BinaryTree<T extends Comparable<T>> {
    BinaryTreeNode<T> root;

    void setRoot(BinaryTreeNode<T> r)
    {
        root = r;
    }
    public void preOrderRecursive(BinaryTreeNode<T> root)
    {

        if(root == null)
        {
            return ;
        }
        System.out.println(root.getValue().toString());
        preOrderRecursive(root.getLeft());
        preOrderRecursive(root.getRight());
    }
    public void preOrderRecursive()
    {
        preOrderRecursive(this.root);

    }

    public void preOrderNoRecursive()
    {
        ListStack<BinaryTreeNode<T>> stack = new ListStack<>();
        BinaryTreeNode<T> tmpRoot = root;

        while(true)
        {

            while(tmpRoot != null)
            {
                System.out.println(tmpRoot.getValue().toString());
                stack.push(tmpRoot);
                tmpRoot = tmpRoot.getLeft();
            }

            if(stack.isEmpty() )
            {
                tmpRoot = root;
                break;
            }
            tmpRoot = stack.pop();
            tmpRoot = tmpRoot.getRight();
        }
    }

    public void inOrder(BinaryTreeNode<T> root)
    {
        if(root == null)
        {
            return ;
        }
        inOrder(root.getLeft());
        System.out.println(root.getValue().toString());
        inOrder(root.getRight());

    }

    public void inOrder()
    {
        inOrder(this.root);

    }

    public void inOrderNoRecursive(){

        ListStack<BinaryTreeNode<T>> stack = new ListStack<>();
        BinaryTreeNode<T> tmpRoot = root;

        while(true)
        {
            // 将节点放入栈中，为了给处理做准备
            while(tmpRoot != null)
            {
                stack.push(tmpRoot);
                tmpRoot = tmpRoot.getLeft();
            }

            if(stack.isEmpty())
            {
                tmpRoot = root;
                break;
            }
            tmpRoot = stack.pop();
            System.out.println(tmpRoot.getValue().toString());
            tmpRoot = tmpRoot.getRight();
        }
    }

    public void postOrder()
    {
        postOrder(this.root);
    }
    void postOrder(BinaryTreeNode<T> root)
    {
        if(root == null)
        {
            return;
        }
        postOrder(root.getRight());
        postOrder(root.getLeft());
        System.out.println(root.getValue().toString());
    }


    /**
     * @deprecated  不会写 改天再弄
     *
     */
    public void postOrderNoRecursive()
    {
        ListStack<BinaryTreeNode<T>> stack = new ListStack<>();
        BinaryTreeNode<T> tmpRoot = root;

        if(tmpRoot != null)
        {
            stack.push(tmpRoot);
            tmpRoot = tmpRoot.getRight();
        }

        while(true)
        {

            if(stack.isEmpty())
            {
                break;
            }
            tmpRoot = stack.pop();

            if(tmpRoot == stack.top().getLeft())
            {

                System.out.println(tmpRoot.getValue().toString());
                tmpRoot = stack.pop();
            }else{
                if(tmpRoot.getLeft() == null)
                {
                    System.out.println(tmpRoot.getValue().toString());
                }
                else {
                    {
                        //stack.pop();
                        stack.push(tmpRoot);
                    }
                }
                tmpRoot = tmpRoot.getLeft();
            }

        }
    }


    public void levelOrder()
    {
        ArrayDeque<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        BinaryTreeNode<T> tmpRoot = root;

        queue.add(tmpRoot);

        while(true)
        {
            if(queue.isEmpty())
            {
                break;
            }
            BinaryTreeNode<T> node = queue.pop();
            System.out.println(node.getValue().toString());
            if(node.getLeft()!= null)
            {
                queue.add(node.getLeft());
            }

            if(node.getRight() != null)
            {
                queue.add(node.getRight());
            }

        }


    }

    public T findMax()
    {
        T max ;

        max.compareTo()
    }

    public static void main(String[] args) {


        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);

        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);

        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node1.setLeft(node2);
        node1.setRight(node3);


        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(node1);


        tree.postOrderNoRecursive();
//        tree.inOrder();
//        tree.inOrderNoRecursive();
        System.out.println("s");

    }


}
