package neetcode150.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArray_33Test {

    @Test
    void search() {

        int[] nums =  {4,5,6,7,0,1,2};
        SearchInRotatedSortedArray_33 f = new SearchInRotatedSortedArray_33();
        int res = f.search(nums, 0);
        assertEquals(4, res);

        res = f.search(nums, 3);
        assertEquals(-1, res);

        int [] nums2 ={1};
        res = f.search(nums2, 0);
        assertEquals(-1, res);
    }
}