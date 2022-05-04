package stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListStackTest {

    @Test
    void reverStack() {

        ListStack<Integer> listStack = new ListStack<>();
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        listStack.push(4);
        listStack.reverStack();


        System.out.println("");
    }
}