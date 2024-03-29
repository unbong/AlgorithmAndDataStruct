package neetcode150.array;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {

        int [] leftProduct = new int[nums.length];
        int [] rightProduct = new int[nums.length];
        int [] result = new int[nums.length];

        leftProduct[0] =1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i-1]* nums[i-1];
        }

        rightProduct[nums.length-1] = 1;
        for (int i = nums.length-2; i >=0; i--) {
            rightProduct[i] = nums[i+1] * rightProduct[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct[i] * rightProduct[i];
        }

        return result;
    }
}
