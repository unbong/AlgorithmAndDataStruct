package neetcode150.twopoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindrome_125Test {

    @Test
    void isPalindrome() {
        ValidPalindrome_125 p = new ValidPalindrome_125();
        boolean s = p.isPalindrome("A man, a plan, a canal: Panama");
        assertEquals(true, s);

        s = p.isPalindrome("race a car");
        assertEquals(false, s);

        s = p.isPalindrome("0P");
        assertEquals(false, s);

        s = p.isPalindrome("ab_a");
        assertEquals(true, s);
    }
}