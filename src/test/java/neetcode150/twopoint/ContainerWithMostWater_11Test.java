package neetcode150.twopoint;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWater_11Test {

    @Test
    void maxArea() {

        ContainerWithMostWater_11 c = new ContainerWithMostWater_11();
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int res = 49;
        int result = c.maxArea(heights);
        assertEquals(res, result);

        int[] he = {1,1};
        res  = 1;
        result = c.maxArea(he);
        assertEquals(res, result);


        int he2[] = {1,0,0,0,0,0,0,2,2};
        res = 8;
        result = c.maxArea(he2);
        assertEquals(res, result);

    }
}