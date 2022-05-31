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
        root.setLeft( singleRotateRight(root.getLeft()));
        return singleRotateLeft(root);
    }

    /**
     * 先右转，再左转
     * 适用于 子右节点的子左节点上追加
     * @param root
     * @return
     */
    public AVLTreeNode<T> doubleRotateRight(AVLTreeNode<T> root)
    {
        root.setRight(singleRotateLeft(root.getRight()));
        return singleRotateRight(root);
    }


    public void print()
    {
        print(this.root, 0, true);

    }

    private void print(AVLTreeNode<T> root, int level, boolean isHaveLeft )
    {


        if(root == null)
        {
            return ;
        }
        if(root.getLeft() == null)
        {
            isHaveLeft = false;
        }else
        {
            isHaveLeft = true;
        }
        if(level ==0)
        {
            System.out.println(root.getValue());
        }
        else
        {
           // if(isHaveLeft)
            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }
            if(isHaveLeft){
                System.out.print("├──");
            }

            else{
                System.out.print("└──");
            }


            System.out.print(root.getValue());
            System.out.print('\n');

        }

        level ++;
        print(root.getLeft(), level, isHaveLeft);
        print(root.getRight(), level, !isHaveLeft);
    }


    /**
     *
     * @param val
     */
    public void addNode(T val)
    {
        this.root =  addNode(val, root, root);
    }

    private AVLTreeNode<T> addNode(T val, AVLTreeNode<T> root, AVLTreeNode<T> parent)
    {
        if(root == null)
        {
            root = new AVLTreeNode<>(val);

        }
        else {
            // 加到左节点
            if(root.getValue().compareTo(val) > 0)
            {
                root.setLeft(addNode(val, root.getLeft(), root));
                // 有两个问题， 高度比较是比较 当前 还是父节点？ -> 当前节点
                int diff  = 0;
                if(root.getRight() == null)
                {
                    diff = root.getLeft().getHeight() +1;
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
                root.setRight( addNode(val, root.getRight(),root));
                int diff = 0;

                if(root.getLeft() == null)
                {
                    diff = root.getRight().getHeight() +1 ;
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
        root.updateHeight();

        return root;
    }

    public AVLTreeNode<T> findMax()
    {
       return findMax(this.root);
    }

    private AVLTreeNode<T> findMax(AVLTreeNode<T> root)
    {
        if (root == null) return null;
        AVLTreeNode<T> tmpRoot = root;

        while(tmpRoot.getRight() != null)
        {
            tmpRoot = tmpRoot.getRight();
        }
        return tmpRoot;
    }

    public AVLTreeNode<T> findMin()
    {
        return findMin(this.root);
    }
    private AVLTreeNode<T> findMin(AVLTreeNode<T> root)
    {
        if (root == null) return null;

        AVLTreeNode tmpRoot = root;
        while(tmpRoot.getLeft() != null)
        {
            tmpRoot = tmpRoot.getLeft();
        }
        return tmpRoot;
    }

    public void removeNode(T val)
    {
        this.root = removeNode(val, this.root, this.root);
    }

    private AVLTreeNode<T> removeNode(T val, AVLTreeNode<T> root, AVLTreeNode<T> parent)
    {
        if (root ==  null)
        {
            return null;
        }
        else
        {
            // 找到了
            if(root.getValue().compareTo(val) == 0)
            {
                if(root.getLeft() == null && root.getRight() == null)
                {
                    if(parent.getRight() == root)
                    {
                        parent.setRight( null);
                    }
                    else {
                        parent.setLeft( null);
                    }
                    
                }
                else if( root.getRight() == null && root.getLeft() != null)
                {
                    if(parent.getLeft() == root)
                    {
                        parent.setLeft(root.getLeft());
                    }
                    else if(parent.getRight() == root) {
                        parent.setRight(root.getLeft());
                    }
                }
                else if(root.getRight() != null && root.getLeft() == null)
                {
                    if(parent.getLeft() == root)
                    {
                        parent.setLeft(root.getRight());
                    }
                    else if(parent.getRight() == root) {
                        parent.setRight(root.getRight());
                    }
                }
                else {
                    AVLTreeNode<T> childMax = findMax(root);
                    if(parent.getLeft() == root )
                    {
                        parent.setLeft(childMax);
                    }
                    else if(parent.getRight() == root)
                    {
                        parent.setRight(childMax);
                    }
                    removeNode(childMax.getValue(), root.getLeft(), root);
                }
            }
            else if(root.getValue().compareTo(val) > 0)
            {
                removeNode(val, root.getLeft(), root);
            }else {
                removeNode(val, root.getRight(), root);
            }

            boolean leftOrRight = false; // 查看子节点是中哪个的高度更长
            int diff = 0;
            if(root.getLeft() != null && root.getRight() == null)
            {
                diff = root.getLeft().getHeight() +1;
                leftOrRight = true;
            }
            else if(root.getLeft() == null && root.getRight() != null)
            {
                diff = root.getRight().getHeight() +1;
                leftOrRight = false;
            }
            else if (root.getLeft() != null && root.getRight() != null){
                diff = root.getRight().getHeight()-root.getLeft().getHeight();
                if(diff>0)
                {
                    leftOrRight = false;
                }
                else {
                    leftOrRight = true;
                }
            }

            if( Math.abs(diff) == 2)
            {

                // 左边子节点的高度更长。
                if(leftOrRight == true )
                {
                    boolean isLeft = false;
                    AVLTreeNode<T> node = root.getLeft();
                    while(node != null)
                    {
                        if(node.getLeft() == null && node.getRight() == null)
                        {
                            break;
                        }
                        else if (node.getLeft() != null && node.getRight() == null)
                        {
                            isLeft = true;
                            node = node.getLeft();
                        }
                        else if(node.getLeft() == null && node.getRight() != null)
                        {
                            isLeft = false;
                            node = node.getRight();
                        }
                        else {
                            if(node.getRight().getHeight()>= node.getLeft().getHeight())
                            {
                                isLeft = false;
                                node = node.getRight();
                            }
                            else {
                                isLeft = true;
                                node = node.getLeft();
                            }
                        }
                    }

                    if(isLeft )
                    {
                        root=singleRotateLeft(root);
                    }
                    else {
                        root =doubleRotateLeft(root);
                    }

                }
                else {
                    boolean isLeft = false;
                    AVLTreeNode<T> node = root.getRight();
                    while(node != null)
                    {
                        if(node.getLeft() == null && node.getRight() == null)
                        {
                            break;
                        }
                        else if (node.getLeft() != null && node.getRight() == null)
                        {
                            isLeft = true;
                            node = node.getLeft();
                        }
                        else if(node.getLeft() == null && node.getRight() != null)
                        {
                            isLeft = false;
                            node = node.getRight();
                        }
                        else {
                            if(node.getRight().getHeight()> node.getLeft().getHeight())
                            {
                                isLeft = false;
                                node = node.getRight();
                            }
                            else {
                                isLeft = true;
                                node = node.getLeft();
                            }
                        }
                    }

                    if(isLeft )
                    {
                        root=doubleRotateRight(root);
                    }
                    else {
                        root =singleRotateRight(root);
                    }

                }
            }
        }
        root.updateHeight();
        return root;
    }

    public int countRange(int min , int max )
    {
        int count = 0;
        return countRange(this.root, min, max, count );

    }


    /**
     * 6-78 求在AVL树中在范围A-B之内的节点个数
     * @param root
     * @param min
     * @param max
     * @param count
     * @return
     */
    private int countRange(AVLTreeNode<T> root , int min, int max, int count)
    {

        if(root == null) return count;

        //
        if(root.getValue().compareTo(min)<0 && root.getValue().compareTo(max) < 0)
        {
            if(root.getRight() != null)
            {
                count = countRange( root.getRight() ,min, max, count) ;
            }
        }
        else if(root.getValue().compareTo(min)>0 && root.getValue().compareTo(max) > 0)
        {
            if(root.getLeft() != null)
            {
                count =countRange(root.getLeft(), min, max, count);
            }
        }
        else if(root.getValue().compareTo(min)>=0 && root.getValue().compareTo(max) <= 0)
        {
            count++;
            if(root.getRight() != null)
            {
                count = countRange(root.getRight(), min, max, count);
            }

            if(root.getLeft() != null)
            {
                count =   countRange(root.getLeft(), min, max, count);
            }

        }

        return count;
    }

    public void remove(T val)
    {

    }
}
