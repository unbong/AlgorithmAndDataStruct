package neetcode150.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequence_128Test {

    @Test
    void longestConsecutive() {
        LongestConsecutiveSequence_128 l = new LongestConsecutiveSequence_128();
        int[] nums ={100,4,200,1,3,2};
        int res = 4;
        int result = l.longestConsecutive(nums);
        assertEquals(res, result);

        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        res = 9;
        result = l.longestConsecutive(nums2);
        assertEquals(res, result);


        int[] nums3 = {100,4,99,200,1,199,3,2,101};
        res = 4;
        result = l.longestConsecutive(nums3);
        assertEquals(res, result);
    }
}