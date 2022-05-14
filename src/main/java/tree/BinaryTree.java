package tree;

import stack.ListStack;
import stack.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;

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

    /**
     * lesson 6-2 找到最大值的节点
     * @return
     */
    public T findMax()
    {
        BinaryTreeNode<T> tmpRoot= root;
        ListStack<BinaryTreeNode<T>> stack = new ListStack<>();
        T max = tmpRoot.getValue()  ;

        while(true)
        {
            while(tmpRoot != null)
            {
                stack.push(tmpRoot);
                if(max.compareTo(tmpRoot.getValue())<0){
                    max = tmpRoot.getValue();
                }
                tmpRoot= tmpRoot.getLeft();
            }

            if( stack.isEmpty() )
            {
                break;
            }

            tmpRoot = stack.pop();
            tmpRoot = tmpRoot.getRight();
        }

        return max;
    }

    /**
     * 6-5 追加节点
     * @param value
     */
    public void addNode(T value)
    {
        BinaryTreeNode<T> newNode =  new BinaryTreeNode<T>(value);
        ArrayDeque<BinaryTreeNode<T>> queue = new ArrayDeque<>();

        if(root == null)
        {
            setRoot(newNode);
            return;
        }
        BinaryTreeNode<T> tmpRoot = root;
        queue.add(tmpRoot);


        while(true)
        {
           if(queue.isEmpty())
           {
              break;
           }
            tmpRoot = queue.pop();
           if(tmpRoot.getLeft() == null)
           {

               tmpRoot.setLeft(newNode);
               break;
           }else
           {
               queue.add(tmpRoot.getLeft());
           }

           if(tmpRoot.getRight() == null)
           {
               tmpRoot.setRight(newNode);
               break;
           }
           else{
               queue.add(tmpRoot.getRight());
           }
        }
    }

    /**
     * 6-9 删除树
     */
    public void deleteTree()
    {
        deleteTree(this.root);
    }

    private void deleteTree(BinaryTreeNode<T> root)
    {
        if(root == null)
        {
            return;
        }
        deleteTree(root.getLeft());
        deleteTree(root.getRight());
        root.setRight(null);
        root.setLeft(null);

    }

    /**
     * lesson 6-10 求树的高度
     *
     * @return
     */
    public int getTreeHeight()
    {
        ArrayDeque<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        BinaryTreeNode<T> tmpRoot  = root;
        int level = 0;
        if(this.root ==  null)
            return level;

        queue.add(root);
        level++;
        queue.add(null);
        while(true){
            boolean isAdded = false;
            if(queue.isEmpty() ==true)
            {
                break;
            }
            tmpRoot = queue.pop();

            if(tmpRoot == null)
            {
                if(queue.isEmpty() == false)
                {
                    queue.add(null);
                }
                level++;
            }
            else{
                if( tmpRoot.getLeft() != null )
                {
                    queue.push(tmpRoot.getLeft());


                }

                if(tmpRoot.getRight() != null)
                {
                    queue.push(tmpRoot.getRight());
                }
            }

        }
        return level;
    }

    /**
     * 6-12
     * 利用顺序访问的方式得到最后一个的节点
     */
    public void getDeepestNode()
    {

    }


    public void deleteNode()
    {

    }

    /**
     * 6-17
     * @return
     */
    public int getSingleNode()
    {
        ArrayDeque<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        int count = 0;
        if(root == null)
        {
            return 0;
        }

        queue.add(root);

        while(queue.isEmpty() == false)
        {
            BinaryTreeNode<T> tmp = queue.pop();
            if( (tmp.getRight() == null && tmp.getLeft()!= null ) ||
                 (tmp.getRight() != null && tmp.getLeft() == null ))
            {
                count++;
            }


            if(tmp.getLeft() != null)
            {
                queue.add(tmp.getLeft());
            }
            if(tmp.getRight()!=null)
            {
                queue.add(tmp.getLeft());
            }
        }

        return count;
    }

    public boolean areSameTrees(BinaryTree<T> leftTree, BinaryTree<T> rightTree)
    {
        ArrayDeque<BinaryTreeNode<T>> leftQueue = new ArrayDeque<>();
        ArrayDeque<BinaryTreeNode<T>> rightQueue = new ArrayDeque<>();
        BinaryTreeNode<T> left = leftTree.root;
        BinaryTreeNode<T> right = rightTree.root;

        if(left == null && left == null)
        {
            return true;
        }

        if(left != null )
        {
            leftQueue.add(left);
        }

        if(right != null)
        {
            rightQueue.add(right);
        }

        if(rightQueue.size() != leftQueue.size())
        {
            return false;
        }

        while( leftQueue.isEmpty() == false &&
                rightQueue.isEmpty() == false)
        {
            left = leftQueue.pop();
            right = rightQueue.pop();

            if(left.getRight() != null && right.getRight() != null)
            {
                leftQueue.add(left.getRight());
                rightQueue.add(right.getRight());
            }
            else if(left.getRight() == null && right.getRight() == null){

            }else {
                return false;
            }


            if(left.getLeft() != null && right.getLeft() != null)
            {
                leftQueue.add(left.getLeft());
                rightQueue.add(right.getLeft());
            }
            else if(left.getLeft() == null && right.getLeft() == null)
            {

            }
            else {
                return false;
            }

        }

        return true;

    }


    /**
     * 6-18 求树的宽度， 宽度为两节点的最长距离
     *  先求左节点 宽度
     *  求右节点 宽度
     *  求左节点高度，右节点高度 + 1
     *
     * @param node
     * @return
     */
    private int getNodeHeight(BinaryTreeNode<T> node) {
        ArrayDeque<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        BinaryTreeNode<T> tmpRoot = node;
        BinaryTreeNode<T> endFlag = new BinaryTreeNode<T>(node.getValue());

        int level = 0;
        if (node == null)
            return level;

        queue.add(tmpRoot);

        queue.add(endFlag);  // 此处为关键，在每一层结束时的指示器一样的东西
        while (true) {
            boolean isAdded = false;
            if (queue.isEmpty() == true) {
                break;
            }
            tmpRoot = queue.pop();

            if (tmpRoot == endFlag) {
                if (queue.isEmpty() == false) {
                    queue.add(endFlag);
                }
                level++;
            } else {
                if (tmpRoot.getLeft() != null) {
                    queue.add(tmpRoot.getLeft());
                }

                if (tmpRoot.getRight() != null) {
                    queue.add(tmpRoot.getRight());
                }
            }

        }
        return level;
    }

    public int getTreeWidth()
    {
        int maxWidth = -1;
        ArrayDeque<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        if(this.root == null)
        {
            return 0;
        }
        queue.add(this.root);
        while(queue.isEmpty()== false)
        {
            BinaryTreeNode<T> node = queue.pop();
            int leftHeight = 0;
            int rightHeight = 0;
            if(node.getRight() != null){
                queue.add(node.getRight());
                leftHeight = getNodeHeight(node.getRight());
            }
            if(node.getLeft() != null) {
                queue.add(node.getLeft());
                rightHeight = getNodeHeight(node.getLeft());
            }
            int width = leftHeight + rightHeight + 1;

            if(width > maxWidth)
            {
                maxWidth = width;
            }

        }
        return maxWidth;
    }


    public int  getMaxmumLevelSum()
    {
        ArrayDeque<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        BinaryTreeNode<T> endLevelPoint = new BinaryTreeNode<>(this.root.getValue());


        if(this.root == null)
        {
            return 0;
        }
        queue.add(this.root);
        queue.add(endLevelPoint);
        int maxSum = -1;

        int tmpSum = 0;
        while(queue.isEmpty()== false)
        {
            BinaryTreeNode<T> tmpNode = queue.pop();
            if(tmpNode == endLevelPoint)
            {
                if( queue.isEmpty() == false )
                {
                    queue.add(endLevelPoint);
                }
                if(maxSum < tmpSum)
                {
                    maxSum = tmpSum;

                }
                tmpSum = 0;
            }
            else {
                if( tmpNode.getValue() instanceof  Integer){
                    int s =  ((Integer) tmpNode.getValue()).intValue();
                    tmpSum += s;
                }
                else {
                    throw new RuntimeException("泛型类型须为Integer");
                }

                if(tmpNode.getRight() != null)
                {
                    queue.add(tmpNode.getRight());
                }
                if(tmpNode.getLeft() != null)
                {
                    queue.add(tmpNode.getLeft());
                }

            }

        }
        return maxSum;
    }

    /**
     * 6-20
     */
    public void printPath()
    {
        ArrayList<T> array = new ArrayList<>();
        int path = 0;
        pringPath(this.root, array, path);

    }


    private void pringPath(BinaryTreeNode<T> root , ArrayList<T> array, int path)
    {

        if(root == null)
        {
            return;
        }

        if(array.size()-1< path)
        {
            array.add(root.getValue());
        }
        else {
            array.set(path , root.getValue());
        }
        path++;
        if(root.getLeft() == null&& root.getRight() == null)
        {
            array.forEach(item-> System.out.print(item+ ", "));
            System.out.println("");

        }

        pringPath(root.getLeft(), array, path);
        pringPath(root.getRight(), array, path);

    }

    public void mirrorTree()
    {
        mirrorTree(this.root);

    }

    private void mirrorTree(BinaryTreeNode<T> root)
    {
        if(root ==  null)
        {
            return;
        }
        mirrorTree(root.getLeft());
        mirrorTree(root.getRight());
        BinaryTreeNode<T> tmpNode = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmpNode);

    }

    /**
     *  6-26 最小共同祖先
     *  1 获取跟打叶的路径信息， 存到集合当中
     *  2 从头到尾的集合，不同时停止。
     * @param node1
     * @param node2
     * @return
     */
    public ArrayList<BinaryTreeNode<T>> lowestCommonAncestor(BinaryTreeNode<T> node1, BinaryTreeNode<T> node2)
    {
        ArrayList<BinaryTreeNode<T>> list1 = new ArrayList<>();
        ArrayList<BinaryTreeNode<T>> list2 = new ArrayList<>();
        ArrayList<BinaryTreeNode<T>> result = new ArrayList<>();
        ArrayList<BinaryTreeNode<T>> tmpList = new ArrayList<>();
        int path = 0;
        getPath(this.root, list1, path, node1, tmpList);
        getPath(this.root, list2, path, node2, tmpList);

        int index = 0;
        if(list1.size()> list2.size())
        {
            index = list2.size();
        }
        else{
            index = list1.size();
        }
        for (int i = 0; i < index; i++) {

            if(list1.get(i) != list2.get(i))
            {
                break;
            }else {
                result.add(list1.get(i));
            }

        }
        return result;
    }

    private void getPath(BinaryTreeNode<T> root, ArrayList<BinaryTreeNode<T>> pathList,
                         int path, BinaryTreeNode<T> endNode,ArrayList<BinaryTreeNode<T>> tmpList) {

        if(root == null)
        {
            return;
        }

        if(tmpList.size()-1 < path)
        {
            tmpList.add(root);
        }
        else{
            tmpList.set(path , root);
        }
        path++;

        if(root == endNode)
        {

            for (int i = 0; i < path; i++) {
                pathList.add(tmpList.get(i));
            }
            return;
        }

        getPath(root.getRight(), pathList, path, endNode,tmpList);
        getPath(root.getLeft(), pathList, path, endNode, tmpList);
    }

    public static void main(String[] args) {


        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);

        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);

        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);

        BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(7);


        node7.setRight(node8);
        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        node1.setLeft(node2);
        node1.setRight(node3);


        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(node1);


        int level = tree.getTreeHeight();
//        tree.inOrder();
//        tree.inOrderNoRecursive();
        System.out.println("s");

    }

    /**
     * 6-30
     * Z型 输出
     */
    public void zPrint( )
    {
        if(this.root == null)
        {
            throw new RuntimeException("tree is empty");
        }
        boolean lRprint = true ;
        Stack<BinaryTreeNode<T>> leftStack = new ListStack<>();
        Stack<BinaryTreeNode<T>> rightStack = new ListStack<>();
        leftStack.push(this.root);
//
//        BinaryTreeNode<T> levelEnd = new BinaryTreeNode<>(this.root.getValue());
//        leftStack.push(levelEnd);
        while(rightStack.isEmpty() == false || leftStack.isEmpty() == false)
        {
            BinaryTreeNode<T> tmpRoot = null;

            if(lRprint)
            {
                while(leftStack.isEmpty() == false)
                {
                    tmpRoot = leftStack.pop();
                    System.out.print(tmpRoot.getValue().toString() + ",");
                    if(tmpRoot.getLeft() != null)
                    {
                        rightStack.push(tmpRoot.getLeft());

                    }
                    if(tmpRoot.getRight()!= null)
                    {
                        rightStack.push(tmpRoot.getRight());
                    }
                }

                lRprint = ! lRprint;

            }
            else {
                while(rightStack.isEmpty() == false)
                {
                    tmpRoot = rightStack.pop();
                    System.out.print(tmpRoot.getValue().toString() + ",");
                    if(tmpRoot.getRight()!= null) {
                        leftStack.push(tmpRoot.getRight());
                    }

                    if(tmpRoot.getLeft() != null)
                    {
                        leftStack.push(tmpRoot.getLeft());
                    }
                }
//                System.out.println("");
                lRprint = ! lRprint;
            }


//            // print level data
//            if(leftStack.isEmpty() || rightStack.isEmpty())
//            {
//                if(lRprint)
//                {
////                    if(leftStack.isEmpty() == false)
////                    {
////                        leftStack.push(levelEnd);
////                    }
//
//
//
//                }else {
////                    if(rightStack.isEmpty() == false)
////                    {
////                        rightStack.push(levelEnd);
////                    }
//
//
//                }
//                lRprint = !lRprint;
//            }
//            else{
//                if(lRprint)
//                {
//                    tmpRoot = leftStack.pop();
//
//
//                }
//                else {
//
//                    tmpRoot = rightStack.pop();
//
//
//                }
//            }
        }

    }

}
