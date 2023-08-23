package neetcode150.DynamicPrograme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobber2_213Test {

    @Test
    void rob() {
        //{1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};

        // int a[] = {1,1,3,6,7,10,7};
        //int a[] = {7,10,7};     //10
        // int a[] = {3,6,7,10,7};  // 16
        int a[] = {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};

        HouseRobber2_213 c= new HouseRobber2_213();
        int s =c.rob(a);
        assertEquals(41, s);
    }
}