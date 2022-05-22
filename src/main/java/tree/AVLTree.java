package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class AVLTree<T extends Comparable> {

    private AVLTreeNode<T> root = null;


    /**
     * 左转
     * @param root
     * @return
     */
    public AVLTreeNode<T> singleRotateLeft(AVLTreeNode<T> root)
    {
        AVLTreeNode<T> child = root.getLeft();
        root.setLeft(child.getRight());
        child.setRight(root);
        root.updateHeight();
        child.updateHeight();
        return child;
    }

    /**
     * 右转
     * @param root
     * @return
     */
    public AVLTreeNode<T> singleRotateRight(AVLTreeNode<T> root)
    {
        AVLTreeNode<T> child = root.getRight();
        root.setRight(child.getLeft());
        child.setLeft(root);
        root.updateHeight();
        child.updateHeight();

        return child;
    }

    /**
     * 先左转 再右转
     * @param root
     * @return
     */
    public AVLTreeNode<T> doubleRotateLeft(AVLTreeNode<T> root)
    {
        root.setLeft( singleRotateLeft(root.getLeft()));
        return singleRotateRight(root);
    }

    /**
     * 先右转，再左转
     * 适用于 子右节点的子左节点上追加
     * @param root
     * @return
     */
    public AVLTreeNode<T> doubleRotateRight(AVLTreeNode<T> root)
    {
        root.setRight(singleRotateRight(root.getRight()));
        return singleRotateLeft(root);
    }

    /**
     *
     * @param val
     */
    public void addNode(T val)
    {
        addNode(val, root, root);

    }


    public void print()
    {
        if(this.root == null)
        {
            System.out.println("empty tree");
            return;
        }

        Queue<AVLTreeNode<T>> queue = new ArrayDeque<>();
        AVLTreeNode<T> levelEndPoint = new AVLTreeNode<>(this.root.getValue());
        queue.add(this.root);
        queue.add(levelEndPoint);
        while(true)
        {
            AVLTreeNode<T> node = queue.poll();
            if(queue.isEmpty() )
            {
//                if(node == levelEndPoint)
//                {
//
//                }
                return ;
            }
            else {


            }

        }

    }

    private void print(AVLTreeNode<T> root, int level)
    {



        level ++;
        print();
    }

    private void addNode(T val, AVLTreeNode<T> root, AVLTreeNode<T> parent)
    {
        if(root == null)
        {
            root = new AVLTreeNode<>(val);
        }
        else {
            // 加到左节点
            if(root.getValue().compareTo(val) > 0)
            {
                addNode(val, root.getLeft(), root);
                // 有两个问题， 高度比较是比较 当前 还是父节点？ -> 当前节点
                int diff  = 0;
                if(root.getRight() == null)
                {
                    diff = root.getLeft().getHeight() ;
                }
                else {
                    diff = root.getLeft().getHeight() - root.getRight().getHeight();
                }
                if(Math.abs(diff) == 2)
                {
                    // 怎么知道是单转 还是 双转？ -》 与子节点判断大小
                    // 左左的parten
                    if( root.getLeft().getValue().compareTo(val) > 0 )
                    {
                        root = singleRotateLeft(root);
                    }
                    else{
                        root = doubleRotateLeft(root);
                    }
                }

            }else if(root.getValue().compareTo(val) < 0)
            {
                addNode(val, root.getRight(),root);
                int diff = 0;

                if(root.getLeft() == null)
                {
                    diff = root.getRight().getHeight();
                }else {
                    diff = Math.abs(root.getRight().getHeight() -root.getLeft().getHeight());
                }

                if(diff == 2)
                {
                    // 右左的parten
                    if(root.getRight().getValue().compareTo(val) > 0)
                    {
                        root = doubleRotateRight(root);
                    }
                    else {
                        root = singleRotateRight(root);
                    }
                }
            }
        }
        // 更新高度
        root.setHeight(Math.max(root.getRight().getHeight() , root.getLeft().getHeight()) +1);
    }

    public void remove(T val)
    {

    }
}
