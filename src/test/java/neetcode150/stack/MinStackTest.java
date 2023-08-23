package neetcode150.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void push() {
        MinStack m = new MinStack();
        m.push(-2);
        m.push(0);
        m.push(-3);
        assertEquals(-3 , m.getMin());
        m.pop();
        assertEquals(0, m.top());
        assertEquals(-2, m.getMin());
        m.pop();
        assertEquals(-2, m.top());
        assertEquals(-2, m.getMin());

        m.pop();
//        assertThrows(IllegalStateException.class, m.top());

    }

    @Test
    void pop() {
    }

    @Test
    void top() {
    }

    @Test
    void getMin() {
    }
}