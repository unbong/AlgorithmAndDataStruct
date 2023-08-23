package neetcode150.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianFinderTest {

    @Test
    void addNum() {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        assertEquals(1.0 , m.findMedian());
        m.addNum(2);
        assertEquals(1.5, m.findMedian());
        m.addNum(3);
        assertEquals(2.0, m.findMedian());
        m.addNum(5);
        assertEquals(2.5, m.findMedian());
        m.addNum(0);
        assertEquals(2.0, m.findMedian());


    }

    @Test
    void findMedian() {

        MedianFinder m = new MedianFinder();
        m.addNum(0);

        m.addNum(0);

        assertEquals(0.0 , m.findMedian());
    }
}