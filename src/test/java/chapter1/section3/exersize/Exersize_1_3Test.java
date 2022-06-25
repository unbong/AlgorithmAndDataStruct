package chapter1.section3.exersize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exersize_1_3Test {

    /**
     * 练习11
     */
    @Test
    void evalueate() {

        Exersize_1_3 ex= new Exersize_1_3();
        int val = ex.evalueate("21+34+*");
        assertEquals(21, val);
    }
}