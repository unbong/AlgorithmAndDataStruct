package neetcode150.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSum_1Test {


    @Test
    void twoSum() {

        int [] in = {2,7,11,15};
        int target = 9;

        TwoSum_1 t = new TwoSum_1();
        int[] res = {0,1};
        int [] result = t.twoSum(in, target);
        assertEquals( res[0],result[0]);
        assertEquals( res[1],result[1]);

        int [] in2 ={3,2,4};
        target = 6;
        res[0] = 1;
        res[1] = 2;
        result = t.twoSum(in2, target);
        assertEquals( res[0],result[0]);
        assertEquals( res[1],result[1]);

        int [] in3 ={3,3};
        target = 6;
        res[0] = 0;
        res[1] = 1;
        result = t.twoSum(in3, target);
        assertEquals( res[0],result[0]);
        assertEquals( res[1],result[1]);

        int [] in4 ={2,3};
        target = 6;
        res[0] = 0;
        res[1] = 1;
        result = t.twoSum(in4, target);
        assertEquals( true, Arrays.equals(new int[]{}, result));

    }
}