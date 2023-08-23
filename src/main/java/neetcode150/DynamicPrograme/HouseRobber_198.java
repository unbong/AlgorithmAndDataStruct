package neetcode150.DynamicPrograme;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class HouseRobber_198 {


    /**
     *  用递归的写法，因为没有做临时结果的保存
     * @param nums
     * @return
     */

    public int rob(int[] nums){

        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robRc(nums, 0, memo);
    }

    private int robRc(int[] nums, int i, int[] memo) {

        if(i == nums.length-1){
            memo[i] = nums[i];
            return nums[i];
        }
        if(i ==nums.length-2 ) {
            memo[i] = Math.max(nums[i], nums[i+1]);
            return memo[i];
        }

        if(memo[i] != -1) return memo[i];
        memo[i] =  Math.max((robRc(nums, i+2, memo ) + nums[i]), robRc(nums, i+1, memo));
        return memo[i];
    }

    /**
     * 下面的解法是对我对动态规划的认识有错误的结果
     * 动态规划最好依据动态表达式子进行
     *
     * 下述的代码的逻辑是，执行所有的可能性，只是在每一种可能性结果算出来后进行了保存。
     * 并在下次使用时直接返回保存了的结果
     */
//    public int rob(int[] nums) {
//        int[] memo =new int[nums.length];
//        Arrays.fill(memo, -1);
//        int first = find(nums, 0,memo);
//        int second = find(nums, 1, memo);
//        return Math.max(first, second);
//    }
//
//    private int find(int[] nums, int i, int [] memo) {
//
//        if(i>= nums.length) return 0;
//
//        if(memo[i] != -1) return memo[i];
//
//        int max = 0;
//        for (int j = i+2; j < nums.length ; j++) {
//            max =Math.max(max, find(nums, j, memo));
//        }
//        memo[i] = nums[i]+ max;
//        return  memo[i];
//    }

}
