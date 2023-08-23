package neetcode150.DynamicPrograme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairs_70Test {

    @Test
    void climbStairs() {

        ClimbingStairs_70 c = new ClimbingStairs_70();
        int res = c.climbStairs(2);
        assertEquals(2, res);

        res = c.climbStairs(3);
        assertEquals(3, res);

        res = c.climbStairs(4);
        assertEquals(5, res);

        res = c.climbStairs(5);
        assertEquals(8, res);
    }
}