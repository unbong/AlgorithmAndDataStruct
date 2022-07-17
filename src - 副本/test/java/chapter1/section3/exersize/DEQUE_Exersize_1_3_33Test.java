package chapter1.section3.exersize;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DEQUE_Exersize_1_3_33Test {

    @Test
    void pushLeft() {
        DEQUE_Exersize_1_3_33<String> deque = new DEQUE_Exersize_1_3_33();
        deque.pushLeft("pushleft1");
        deque.pushLeft("pushleft2");
        deque.pushLeft("pushleft3");

        String s1 = deque.popLeft();
        Assertions.assertEquals("pushleft3", s1);
        s1 = deque.popLeft();
        Assertions.assertEquals("pushleft2", s1);
        s1 = deque.popLeft();
        Assertions.assertEquals("pushleft1", s1);

    }

    @Test
    void popLeft() {
    }

    @Test
    void pushRight() {

        DEQUE_Exersize_1_3_33<String> deque = new DEQUE_Exersize_1_3_33();
        deque.pushRight("pushleft1");
        deque.pushRight("pushleft2");
        deque.pushRight("pushleft3");

        String s1 = deque.popRight();
        Assertions.assertEquals("pushleft3", s1);
        s1 = deque.popRight();
        Assertions.assertEquals("pushleft2", s1);
        s1 = deque.popRight();
        Assertions.assertEquals("pushleft1", s1);
    }

    @Test
    void popRight() {

        DEQUE_Exersize_1_3_33<String> deque = new DEQUE_Exersize_1_3_33();
        deque.pushLeft("pushleft1");
        deque.pushLeft("pushleft2");
        deque.pushLeft("pushleft3");

        String s1 = deque.popRight();
        Assertions.assertEquals("pushleft1", s1);
        s1 = deque.popRight();
        Assertions.assertEquals("pushleft2", s1);
        s1 = deque.popRight();
        Assertions.assertEquals("pushleft3", s1);

    }
}