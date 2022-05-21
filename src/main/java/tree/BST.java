package tree;

import LinkedList.DoubleLinkedList;
import LinkedList.ListNode;
import stack.ListStack;
import stack.Stack;

import java.util.ArrayList;
import java.util.LinkedList;

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


    /**
     * 6-56 思路没问题，因为双链表实现有问题，无法得到正确答案
     * @param start
     * @param end
     * @param first
     * @return
     */
    private ListNode<T> madeTreeNode(int start , int end, ListNode<T> first)
    {
        if(start > end) return null;
        int mid = (end-start)/2;
        int index =start;

        ListNode<T> root =  getMiddle( mid, first);

        ListNode<T> left = madeTreeNode(start , start +mid-1, first);
        ListNode<T> right = madeTreeNode(start + mid+1 , end, root.getNext());


        root.setNext(right);
        root.setPrev(left);

        return root;

    }
    /**
     * 6-56 思路没问题，因为双链表实现有问题，无法得到正确答案
      * @param first
     * @return
     */
    private ListNode<T> getMiddle(int mid, ListNode<T> first) {

        int j = 0;
        ListNode<T> node = first;
        for(; j< mid; j++);
        {
            node = node.getNext();
        }
        return  node;
    }
    /**
     * 6-56 思路没问题，因为双链表实现有问题，无法得到正确答案


     * @return
     */
    public void  convertToBstFromDDL(DoubleLinkedList<T> ddl)
    {
        int size = ddl.size();
        ListNode<T> root = madeTreeNode(1, size,ddl.getFirst());


        System.out.println("done");
    }


    /**
     * 6-59 自顶向下 方式生成BST
     * @param arrayList
     * @return
     */
    public BinaryTreeNode<T> madeBstFromSortedArray(ArrayList<T> arrayList)
    {
        int start = 0;
        int end = arrayList.size()-1;

        BinaryTreeNode<T> root =  getMiddle(start, end, arrayList);

        return root;
    }

    private BinaryTreeNode<T> getMiddle(int start , int end , ArrayList<T> arrayList)
    {
        if(start>end) return null;
        int mid = (end-start) /2;

        T val = arrayList.get(start+mid);

        BinaryTreeNode<T> root = new BinaryTreeNode<>(val);
        BinaryTreeNode<T> left = getMiddle(start, start + mid-1, arrayList);
        BinaryTreeNode<T> right = getMiddle(start + mid +1 , end, arrayList);
        root.setLeft(left);
        root.setRight(right);
        return root;

    }

    public BinaryTreeNode<T> madeBstFromSortedArrayBottomUp(LinkedList<T> list)
    {
        int start = 0;
        int end = list.size()-1;

        BinaryTreeNode<T> root =  getMiddleBottomUp(start, end, list);

        return root;
    }

    private BinaryTreeNode<T> getMiddleBottomUp(int start, int end, LinkedList<T> list) {

        if(start > end) return null;
        int mid = (end- start)/2;
        BinaryTreeNode<T> left = getMiddleBottomUp(start, start + mid-1 , list);



    }


}
