package neetcode150.twopoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWater_42Test {

    @Test
    void trap() {

        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater_42 t = new TrappingRainWater_42();
        int res = t.trap(height);
        assertEquals(6, res);

        int[] he ={4,2,3};

        res = t.trap(he);
        assertEquals(1, res);

        int[] h2 = {5,4,1,2};
        res = t.trap(h2);
        assertEquals(1, res);

        int [] h3 = {0,7,1,4,6};
        res = t.trap(h3);
        assertEquals(7, res);
    }
}