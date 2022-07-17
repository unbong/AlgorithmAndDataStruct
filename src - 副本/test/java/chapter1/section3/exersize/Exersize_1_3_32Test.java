package chapter1.section3.exersize;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Exersize_1_3_32Test {

    @Test
    void push() {
        STEQUE_Exersize_1_3_32<String> stq = new STEQUE_Exersize_1_3_32<>();
        stq.push("1");
        stq.push("2");
        stq.push("3");

        String s3 = stq.pop();

        Assertions.assertEquals("3", s3);
        s3 = stq.pop();
        Assertions.assertEquals("2", s3);
    }

    @Test
    void pop() {
    }

    @Test
    void enqueue() {
        STEQUE_Exersize_1_3_32<String> stq = new STEQUE_Exersize_1_3_32<>();
        stq.push("1");
        stq.push("2");
        stq.push("3");

        String s3 = stq.pop();

        Assertions.assertEquals("3", s3);
        s3 = stq.pop();
        Assertions.assertEquals("2", s3);

        stq.enqueue("1");
        stq.enqueue("2");
        stq.enqueue("3");

        s3 = stq.pop();
        Assertions.assertEquals("1", s3);
        s3 = stq.pop();
        Assertions.assertEquals("1", s3);

        s3 = stq.pop();
        Assertions.assertEquals("2", s3);

        s3 = stq.pop();
        Assertions.assertEquals("3", s3);


    }
}