package neetcode150.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationinString_567Test {

    @Test
    void checkInclusion() {
        PermutationinString_567 p = new PermutationinString_567();
        String s1 = "ab", s2 = "eidbaooo";
        boolean res = p.checkInclusion(s1, s2);
        assertEquals(true, res);

        s1 = "ab";
        s2 = "eidboaoo";
        res = p.checkInclusion(s1,s2);
        assertEquals(false, res);


        s1="adc";
        s2 = "dcda";
        res = p.checkInclusion(s1,s2);
        assertEquals(true, res);

    }


}