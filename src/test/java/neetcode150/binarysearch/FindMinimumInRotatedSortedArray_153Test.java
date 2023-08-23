package neetcode150.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimumInRotatedSortedArray_153Test {

    @Test
    void findMin() {
       int[] nums =  {4,5,6,7,0,1,2};
       FindMinimumInRotatedSortedArray_153 f = new FindMinimumInRotatedSortedArray_153();
       int res = f.findMin(nums);
       assertEquals(0, res);


        int [] nusm2={3,4,5,1,2};
        res = f.findMin(nusm2);
        assertEquals(1,res);

        int[] nums3 = {11,13,15,17};
        res = f.findMin(nums3);
        assertEquals(11, f.findMin(nums3));


        int [] nusm4= {3,1,2};
        res = f.findMin(nusm4);
        assertEquals(1,res);


        int [] nusm5= {2,3,1};
        res = f.findMin(nusm5);
        assertEquals(1,res);
    }
}