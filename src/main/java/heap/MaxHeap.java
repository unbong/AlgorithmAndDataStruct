package heap;


import java.util.Arrays;

/**
 * 堆
 *  一种实现优先队列的数据结构，基本的操作包括插入，不修改数据结构的前提下取得最大值或取得最小值， 修改数据结构的前提下的取得最大最小值。
 *
 *  实现方式为将数组
 *
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {

    private Node<E>[]  array;
    private int size = 0;
    private int lastIndex = -1;

    @Override
    public String toString() {

        String arrays = "";

        for(int i= 0; i<= lastIndex; i++)
        {
            arrays = arrays + array[i].getVal() +", " ;
        }
        return "MinHeap{" +
                "array=" + arrays +
                ", size=" + size +
                ", lastIndex=" + lastIndex +
                '}';
    }

    /**
     *  构造堆
     * @param size
     */
    public MaxHeap(int size)
    {
        array = new Node[size];
        this.size = size;
    }

    /**
     *  重新设置堆的大小
     */
    private void resize(int newSize)
    {
        Node<E>[] tmp = new Node[newSize];
        this.size = newSize;

        for (int i = 0 ; i < lastIndex; i++) {
            tmp[i] = new Node<>(array[i].getVal());
        }
        array = tmp;
    }

    /**
     *  获取最大值
     *
     * @return
     */
    public E getMax()
    {
        if(lastIndex == -1)
            throw  new IllegalStateException("Heap is empty");

        return array[0].getVal();
    }

    /**
     * 得到最大值，并将其删除
     * @return
     */
    public E remove()
    {

        if(lastIndex == -1)
            throw  new IllegalStateException("Heap is empty");

        E value = array[0].getVal();

        array[0].setVal(array[lastIndex].getVal());
        array[lastIndex] = null;
        lastIndex--;
        shiftDown(0);

        return value;
    }

    /**
     *  追加新的节点
     * @param val
     */
    public void add(E val)
    {
        // 扩大两倍大小的数组
        if(lastIndex + 1 == size)
        {
            resize(2 * size);
        }

        lastIndex++;
        // 加到最后面
        array[lastIndex] = new Node<>(val);
        // 向上堆化
        shiftUp(lastIndex);
    }

    /**
     * 从指定节点开始进行向下处理，使其能够满足堆的性质
     * @param index
     */
    private void shiftDown(int index)
    {
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);
        E current = array[index].getVal();
        E left = current, right = current;
        if(leftIndex != -1)
        {
            left = array[leftIndex].getVal();
        }

        if(rightIndex != -1)
        {
            right = array[rightIndex].getVal();
        }

        E max = current;
        int maxIndex = index;

        while(current.compareTo(left)<0 || current.compareTo(right)<0)
        {
            if(current.compareTo(left)< 0) {
                max = left;
                maxIndex = leftIndex;
            }

            if(max.compareTo(right) < 0)
            {
                max = right;
                maxIndex = rightIndex;
            }

            E tmp = array[index].getVal();
            array[index].setVal(array[maxIndex].getVal());
            array[maxIndex].setVal(tmp);

            leftIndex = leftChild(maxIndex);
            rightIndex = rightChild(maxIndex);
            if(leftIndex != -1)
            {
                left = array[leftIndex].getVal();
            }

            if(rightIndex != -1)
            {
                right = array[rightIndex].getVal();
            }
            current = max;
        }

    }

    /**
     * 获取右子节点
     * @param index
     * @return
     */
    private int rightChild(int index) {
        int rightChildIndex =  index * 2 +2;
        if(index < 0 || rightChildIndex > lastIndex)
        {
            // throw new IllegalArgumentException(String.format("index is availd %d", index));
            return -1;
        }

        return rightChildIndex;
    }

    /**
     * 获取左子节点
     * @param index
     * @return
     */
    private int leftChild(int index) {

        int leftChildIndex = index*2 + 1;
        if(index <0 || leftChildIndex > lastIndex)
        {
//            throw new IllegalArgumentException(String.format("index is availd. %d", index));
            return -1;
        }
        return leftChildIndex;
    }

    /**
     * 父节点
     * @param index
     * @return
     */
    private int parent(int index)
    {
        int parent = (index-1)/2;
        if(index > lastIndex || parent < 0 || index == 0)
//            throw new IllegalArgumentException(String.format("index is availd. %d", index));
            return -1;
        return parent;
    }

    /**
     * 从指定节点开始向上处理，使其能够满足堆的性质
     * @param index
     */
    private void shiftUp(int index)
    {
        int parentIndex = parent(index);
        E current = array[index].getVal();
        E parent = current;

        while( parentIndex != -1 && current.compareTo(array[parentIndex].getVal())> 0)
        {
            E tmp = array[index].getVal();;
            array[index].setVal(array[parentIndex].getVal());
            array[parentIndex].setVal(tmp);
            current =  array[parentIndex].getVal();
            index = parentIndex;
            parentIndex = parent(index);
        }

    }


}
