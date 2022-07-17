package chapter1.section3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void dequeue() {
        Queue<String> queue = new Queue<>();
        queue.enqueue("aa");
        queue.enqueue("bb");
        String aa = queue.dequeue();
        assertEquals("aa",aa);
        String bb = queue.dequeue();
        assertEquals("bb",bb);
    }

    @Test
    void enqueue() {
    }
}