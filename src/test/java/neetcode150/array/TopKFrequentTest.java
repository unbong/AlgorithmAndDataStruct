package neetcode150.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TopKFrequentTest {

    @Test
    void topKFrequent() {
        TopKFrequent t = new TopKFrequent();
        int [] nums = {1,1,1,2,2,3};
        int [] res = t.topKFrequent(nums, 2);
        int [] result = {1,2};
        assertEquals(true, Arrays.equals(result, res));

        int [] nums2 = {1};
        res = t.topKFrequent(nums2,1);
        int[] result1 = {1};
        assertEquals(true, Arrays.equals(result1, res));


        int [] nums3 = {-1,-1};
        res = t.topKFrequent(nums3,1);
        int[] result3 = {-1};
        assertEquals(true, Arrays.equals(result3, res));

    }
}