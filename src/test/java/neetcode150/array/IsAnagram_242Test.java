package neetcode150.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IsAnagram_242Test {

    @Test
    void isAnagram() {
        IsAnagram_242 i = new IsAnagram_242();
        assertEquals (true , i.isAnagram("anagram", "nagaram") );

        assertEquals (false , i.isAnagram("abcd", "c"));

        assertEquals (false , i.isAnagram("abcd", "cg"));

        assertEquals (false , i.isAnagram("aacc", "ccca"));
    }
}