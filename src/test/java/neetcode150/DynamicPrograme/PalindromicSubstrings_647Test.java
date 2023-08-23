package neetcode150.DynamicPrograme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicSubstrings_647Test {

    @Test
    void countSubstrings() {

        PalindromicSubstrings_647 p = new PalindromicSubstrings_647();
        int res = p.countSubstrings("aaa");
        assertEquals(6, res);

        res = p.countSubstrings("abc");
        assertEquals(3, res);
    }
}