package neetcode150.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubStringTest {

    @Test
    void minWindow() {


        String s = "ADOBECODEBANC", t = "ABC";
        MinimumWindowSubString m = new MinimumWindowSubString();
        String res = m.minWindow(s, t);
        assertEquals("BANC", res);

        s = "a";
        t = "a";
        res = m.minWindow(s, t);
        assertEquals("a", res);

        s = "a";
        t = "aa";
        res = m.minWindow(s, t);
        assertEquals("", res);

        s = "aa";
        t = "aa";
        res = m.minWindow(s,t);
        assertEquals("aa", res);

        s= "bbaa";
        t="aba";
        res = m.minWindow(s,t);
        assertEquals("baa", res);



        s= "bbaac";
        t="aba";
        res = m.minWindow(s,t);
        assertEquals("baa", res);
    }
}