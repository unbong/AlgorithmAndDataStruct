package heap;

import java.util.Arrays;

public class MinHeap <E extends Comparable<E>>{

    private Node<E>[] array = null;
    private int size = 0;
    private int lastIndex = -1;

    public MinHeap(int size)
    {
        array = new Node[size];
        this.size = size;
    }

    @Override
    public String toString() {
        String arrays = "";

        for(int i= 0; i<= lastIndex; i++)
        {
            arrays = arrays + array[i].getVal() +", " ;
        }
        return "MaxHeap{" +
                "array=" + arrays +
                ", size=" + size +
                ", lastIndex=" + lastIndex +
                '}';
    }

    /**
     * 追加数据
     * @param value
     */
    public void add(E value)
    {
        // 判断空间是否足够
        if(lastIndex + 1 == size)
        {
            resize(2*size);
        }
        // 将新的值放入到最后的位置中

        lastIndex++;

        array[lastIndex] = new Node<>(value);

        // 向上进行处理，使其满足堆的性质
        shiftUp(lastIndex);
    }

    /**
     *
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

    private void shiftDown(int index) {

        int leftIndex = left(index);
        int rightIndex = right(index);
        int min =index;
        while(( leftIndex != -1 && array[index].getVal().compareTo(array[leftIndex].getVal()) > 0 ) ||
                (rightIndex != -1 && array[index].getVal().compareTo(array[rightIndex].getVal() ) > 0 ))
        {

            if(leftIndex != -1 && array[index].getVal().compareTo(array[leftIndex].getVal()) > 0)
            {
                min = leftIndex;
            }

            if(rightIndex != -1 && array[min].getVal().compareTo(array[rightIndex].getVal()) > 0)
            {
                min = rightIndex;
            }

            E tmp = array[index].getVal();
            array[index].setVal(array[min].getVal());
            array[min].setVal(tmp);
            index = min;
            leftIndex = left(index);
            rightIndex = right(index);

        }
    }

    private int left(int index) {
        int left = 2*index+1;
        if(index < 0 || left > lastIndex)
        {
            return -1;
        }
        return left;
    }

    private int right(int index) {
        int right = 2* index+2;
        if(index<0 || right > lastIndex)
        {
            return -1;
        }
        return right;
    }

    /**
     * 向上进行比较, 与父节点进行交换。
     * @param index
     */
    private void shiftUp(int index) {

        int parentIndex = parent(index);
        while(parentIndex != -1 && array[index].getVal().compareTo(array[parentIndex].getVal())< 0 )
        {
            E tmp = array[index].getVal();
            array[index].setVal(array[parentIndex].getVal());
            array[parentIndex].setVal(tmp);
            index = parentIndex ;
            parentIndex = parent(index);
        }
    }

    /**
     * 获取父节点索引
     * @param index
     * @return
     */
    private int parent(int index) {
        int parentIndex = (index-1)/2;
        if(index > lastIndex || parentIndex < 0 || index == 0)
        {
            return -1;
        }
        return parentIndex;
    }

    /**
     * 扩大数组大小
     * @param newSize
     */
    private void resize(int newSize) {
        Node<E>[] tmp = new Node[newSize];

        for (int i = 0; i < lastIndex; i++) {
            tmp[i] = new Node<>(array[i].getVal());
        }
        array = tmp;
        this.size = newSize;
    }


}
