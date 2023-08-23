package neetcode150.twopoint;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSum2_167Test {

    @Test
    void twoSum() {

        int[] num = {2,7,11,15};
        int target = 9;
        TwoSum2_167 t = new TwoSum2_167();
        int[] res = {1,2};
        int[] result = t.twoSum(num, target);
        assertEquals(true, Arrays.equals(res, result));


        int[] num2 = {2,3,4};
        target = 6;

        int[] res2 = {1,3};
        int[] result2 = t.twoSum(num2, target);
        assertEquals(true, Arrays.equals(res2, result2));
    }
}