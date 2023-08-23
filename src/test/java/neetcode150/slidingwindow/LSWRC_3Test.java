package neetcode150.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LSWRC_3Test {

    @Test
    void lengthOfLongestSubstring() {
        LSWRC_3 l = new LSWRC_3();
        String s = "abcabcbb";
        int res = l.lengthOfLongestSubstring(s);
        assertEquals(3, res);

        s = "bbbbb";
        res = l.lengthOfLongestSubstring(s);
        assertEquals(1, res);

        s = "pwwkew";
        res = l.lengthOfLongestSubstring(s);
        assertEquals(3, res);

        s="aa";
        res = l.lengthOfLongestSubstring(s);
        assertEquals(1, res);


        s= "qrsvbspk";
        res = l.lengthOfLongestSubstring(s);
        assertEquals(5, res);

    }
}