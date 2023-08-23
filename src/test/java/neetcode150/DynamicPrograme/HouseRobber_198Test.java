package neetcode150.DynamicPrograme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobber_198Test {

    @Test
    void rob() {

        int[] nums= {1,2,3,1};
        HouseRobber_198 h = new HouseRobber_198();
        int res = h.rob(nums);

        assertEquals(4, res);


        int[] nums2 = {2,7,9,3,1};
        res = h.rob(nums2);
        assertEquals(12, res);

//        int[] nums3 = {2,1,1,2,2};
//        res = h.rob(nums3);
//        assertEquals(5, res);

        int[] nums4 = {1,3,6,7,10,7,1,8,5,9,1,4,4,3};
        res = h.rob(nums4);
        assertEquals(5, res);


    }
}