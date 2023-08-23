package neetcode150.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelf_238Test {

    @Test
    void productExceptSelf() {
        int[] nums = {1,2,3,4};
        int[] res  ={24,12,8,6};
        ProductOfArrayExceptSelf_238 p = new ProductOfArrayExceptSelf_238();
        int[] result = p.productExceptSelf(nums);
        assertEquals(true, Arrays.equals(res, result));


        int[] nums2={-1,1,0,-3,3};
        int[] res2 = {0,0, 9,0,0};
        result = p.productExceptSelf(nums2);
        assertEquals(true, Arrays.equals(result, res2));
    }
}