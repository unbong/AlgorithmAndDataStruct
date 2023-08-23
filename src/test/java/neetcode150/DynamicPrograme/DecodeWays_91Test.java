package neetcode150.DynamicPrograme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWays_91Test {

    @Test
    void numDecodings() {
        String s = "12";
        DecodeWays_91 d = new DecodeWays_91();
        int res = d.numDecodings(s);
        assertEquals(2, res);


        res = d.numDecodings("226");
        assertEquals(3, res);

        res = d.numDecodings("2262");
        assertEquals(3, res);

        res = d.numDecodings("1201234");
        assertEquals(3, res);
    }
}