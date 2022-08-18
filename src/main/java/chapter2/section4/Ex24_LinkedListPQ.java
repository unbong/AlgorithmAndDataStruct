package chapter2.section4;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import utils.IntRandom;

import java.util.regex.Pattern;

/**
 *  160000, time: 16.00
 *  320000, time: 31.00
 *  640000, time: 62.00
 * @param <key>
 */
public class Ex24_LinkedListPQ <key extends Comparable<key>>{

    // 链表的节点
    private class Node {
        public Node(key it)
        {
            item = it;
        }
        key item;
        Node first;
        Node second;
        Node parent;

    }

    private  Node root = null;
    private Node lastNode = null;

    public void insert(key val)
    {
        Node newNode = new Node(val);
        if(isEmpty()){
            root = newNode;
            lastNode = root;
            return;
        }

        Node tmpLastNode = lastNode;
        if(tmpLastNode == root)
        {
            if(tmpLastNode.first == null)
            {
                tmpLastNode.first = newNode;

            }
            else {
                tmpLastNode.second = newNode;
            }
            newNode.parent = tmpLastNode;

        }
        else {
            while(tmpLastNode != null)
            {
                Node parent = tmpLastNode.parent;

                //
                if(parent.second == null)
                {
                    parent.second = newNode;
                    newNode.parent = parent;
                    lastNode = newNode;
                    break;
                }
                //
                else if(parent.second == tmpLastNode && parent != root)
                {
                    //parent = parent.parent;
                    tmpLastNode = parent;
                }
                /**
                 *      4
                 *    3    2
                 *  1   0
                 *        ↑ 要添加到这里时
                 *
                 *  从父的父节点的右边节点开始找找，左子节点为空的节点后插入到左子节点。
                 */
                else if(parent.first == tmpLastNode  ) {
                    parent = parent.second;
                    while(parent.first != null)
                        parent = parent.first;
                    parent.first = newNode;
                    newNode.parent = parent;
                    break;

                }
                // 当节点为root时找到最左边的节点 并插入
                else if (parent == root) {
                    //
                    while(parent.first != null)
                        parent = parent.first;
                    parent.first = newNode;
                    newNode.parent = parent;
                    break;
                }
            }
        }

        lastNode = newNode;

        swim(lastNode);
    }

    public key top()
    {
        if(isEmpty()) throw new IllegalStateException("queue is empty");
        key res = root.item;

        root.item = lastNode.item;

        // 只有root节点时
        if(root == lastNode)
        {
            root = null;
            lastNode = null;
            return res;
        }
        Node tmpLastNode = lastNode;
        while(tmpLastNode != null)
        {
            Node parent = tmpLastNode.parent;
            // 删除右子节点时
            if(parent.second == tmpLastNode)
            {
                parent.second = null;
                lastNode = parent.first;
                break;

                // 删除左子节点时
            } else if (parent.first == tmpLastNode) {
                Node tmpParent = parent.parent;

                if(tmpParent != null){
                    /**
                     *
                     *            4
                     *        3       2
                     *      1   0  -1  <- delete
                     *          ↑ 指定这里为最后节点
                     */
                    if (tmpParent.second == parent){
                        tmpParent  = tmpParent.first;
                        while(tmpParent.second != null)
                        {
                            tmpParent= tmpParent.second  ;
                        }
                        //parent.first = null;
                        lastNode = tmpParent;
                        break;
                    }
                    /**
                     *              8
                     *           4      7
                     *        3    2  6   5
                     *      1
                     *      ↑ 要删除到这里时
                     *      当临时的最后节点变量，指向root时，将最后节点的指针指向最右子节点。即 5 的位置
                     */
                    else if(tmpParent == root)
                    {
                        while(tmpParent.second != null)
                            tmpParent = tmpParent.second;
                        lastNode = tmpParent;
                        break;
                    }

                    /**
                     *              8
                     *           4      7
                     *        3    2  6   5
                     *      1   0 -1 -2
                     *                ↑ 要删除到这里时
                     *       把最后的节点删除后，将临时的最后节点变量，指示到父节点，使其能够执行上面的处理
                     */

                    else if(tmpParent.first == parent  ) {

                        if(parent.first == lastNode)
                        {
                            parent.first = null;
                        }

                        tmpLastNode = parent;
                    }

                }
                else if(tmpParent == null)
                {
                    parent.first =null;
                    lastNode = parent;
                    break;
                }
            }
        }
        sink(root);
        return res;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    private void sink(Node node)
    {
        Node tmpNode = root;
        while(tmpNode != null)
        {
            if(tmpNode.second != null)
            {
                Node exchNode = tmpNode.first;
                if(less(tmpNode.first.item, tmpNode.second.item))
                {
                    exchNode = tmpNode.second;
                }

                if(less(tmpNode.item, exchNode.item)){
                    key tmp = tmpNode.item;
                    tmpNode.item = exchNode.item;
                    exchNode.item = tmp;
                }else
                    break;

                tmpNode = exchNode;
            }
            else if(tmpNode.first != null) {
                if(less(tmpNode.item, tmpNode.first.item ))
                {
                    key tmp = tmpNode.first.item;
                    tmpNode.first.item = tmpNode.item;
                    tmpNode.item = tmp;
                }
                else break;
                tmpNode = tmpNode.first;
            }else
                tmpNode = tmpNode.first;
        }
    }

    private boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

//    private void exch(Comparable v, Comparable w)
//    {
//        Comparable tmp = v;
//        v. = w;
//        w = v;
//    }


    private void swim(Node node)
    {
        while(node.parent != null)
        {
            if(less(node.parent.item, node.item))
            {
                key tmp = node.item;
                node.item = node.parent.item;
                node.parent.item = tmp;
            }else break;
            node = node.parent;
        }

    }


    public static void main(String[] args) {

        Ex24_LinkedListPQ<Integer> pq = new Ex24_LinkedListPQ<>();

        int N = 160000;
        for (int i = 0; i <3; i++) {
            Integer a[] = IntRandom.getIntRandom(N);
            Stopwatch w = new Stopwatch();
            for (int j = 0; j < a.length; j++) {
                pq.insert(a[j]);
            }
            StdOut.println(String.format(" %d, time: %.2f ", N, w.elapsedTime() * 1000 ));
            N = N*2;
        }

        StdOut.println();




    }
}
