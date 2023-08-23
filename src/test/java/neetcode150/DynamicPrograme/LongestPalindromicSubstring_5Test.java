package neetcode150.DynamicPrograme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstring_5Test {

    @Test
    void longestPalindrome() {

        LongestPalindromicSubstring_5 s = new LongestPalindromicSubstring_5();
        String res = s.longestPalindrome("babad");
        assertEquals("bab", res);

        res = s.longestPalindrome("cbbd");
        assertEquals("bb", res);

        res = s.longestPalindrome("babab");
        assertEquals("babab", res);

        res = s.longestPalindrome("ac");
        assertEquals("a", res);
    }
}