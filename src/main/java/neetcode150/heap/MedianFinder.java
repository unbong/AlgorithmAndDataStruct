package neetcode150.heap;

import java.util.PriorityQueue;


/**
 *  使用两个优先队列来存储与管理数据 升序优先队列 降序优先队列
 *    两个优先队列之间需要满足
 *       彼此之间的大小之差需要小于2
 *       升序优先队列中的最小值要大于降序优先队列中的最大值
 *
 *
 */
public class MedianFinder {

    private  PriorityQueue<Integer> _maxHeap ;

    private PriorityQueue<Integer> _minHeap;
    public MedianFinder() {
       _maxHeap = new PriorityQueue<>((first, second)->{return second.intValue()-first.intValue();});

       _minHeap = new PriorityQueue<>( (first, second)->{return first.intValue() - second.intValue();});
    }

    public void addNum(int num) {

        _maxHeap.add(num);
        if(_maxHeap.size() - _minHeap.size() >1){
            _minHeap.add(_maxHeap.poll());
        }

        if(_maxHeap.peek() !=null &&  _minHeap.peek() !=null
                && _maxHeap.peek() > _minHeap.peek())
        {
            _minHeap.add(_maxHeap.poll());
        }

        if(_minHeap.size() - _maxHeap.size() >1){
            _maxHeap.add(_minHeap.poll());
        }

    }

    /**
     * 奇数时返回两个队列中较大一侧的最大值或最小值
     * 偶数时，返回两个队列中的最大值与最小值相加后除以2
     *
     * @return
     */
    public double findMedian() {

        if((_maxHeap.size() + _minHeap.size())%2 ==0){
            return (_maxHeap.peek() +_minHeap.peek())/2.0;
        }

        if(_maxHeap.size()>_minHeap.size())
            return _maxHeap.peek();
        else
            return _minHeap.peek();
    }
}
