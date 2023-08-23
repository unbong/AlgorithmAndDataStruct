package neetcode150.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRCR_424Test {

    @Test
    void characterReplacement() {

        LRCR_424 n = new LRCR_424();

        String s="ABAB";
        int k = 2;

        int res = n.characterReplacement(s, k);
        assertEquals(4, res);

        s="AABABBA";
        k = 1;
        res = n.characterReplacement(s, k);
        assertEquals(4, res);



        s="ABBB";
        k = 2;
        res = n.characterReplacement(s, k);
        assertEquals(4, res);
    }
}