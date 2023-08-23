package neetcode150.DynamicPrograme;

import java.util.Arrays;

public class HouseRobber2_213 {

    /**
     * 动态规划的变形
     *  动态规划的式子中需要添加一些新的规定
     *       如果选中了第一个项目，则需要添加要不要添加最后一个项目的判断。
     *       保存中间结果的数据中需要两个，保存选中了第一个和没选中第一个的数据。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] memo = new int[nums.length];
        int[] memo2 = new int[nums.length];
        Arrays.fill(memo,-1);
        Arrays.fill(memo2, -1);

        return Math.max(robRc(nums, 2, memo, memo2,true )+ nums[0],
                robRc(nums, 1, memo ,  memo2, false));

    }

    private int robRc(int[] nums, int i, int[] memo, int[] memo2, boolean isFirstSelected
    ) {

        if(i == nums.length-1){
            if(isFirstSelected)
            {
                memo[i] = 0;
                return 0;
            }
            else{
                memo2[i] = nums[i];
                return nums[i];
            }
        }

       if ( i == nums.length -2){
           if(isFirstSelected){
               memo[i] = nums[i];
               return nums[i];
           }
           else{
               memo2[i] = Math.max(nums[i], nums[i+1]);
               return memo2[i];
           }
       }

       if(isFirstSelected && memo[i] !=-1)
           return memo[i];
       else if(!isFirstSelected && memo2[i] !=-1)
           return memo2[i];


       int res =  Math.max(robRc(nums, i+2, memo, memo2 ,isFirstSelected)+ nums[i], robRc(nums, i+1, memo,  memo2,isFirstSelected));
       if(isFirstSelected){
           memo[i] = res;
       }
       else {
           memo2[i] = res;
       }
       return res;

    }

}
