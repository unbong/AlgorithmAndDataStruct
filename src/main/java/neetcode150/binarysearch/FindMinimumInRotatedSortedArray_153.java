package neetcode150.binarysearch;

public class FindMinimumInRotatedSortedArray_153 {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length-1;
        int mid;
        int res = nums[0];
        while(left<=right)
        {
            if(nums[left]<nums[right])
            {
                res = Math.min(nums[left],res);
                break;
            }
            mid = (left+right) /2;
            res = Math.min(res, nums[mid]);
            int midSubLeft = nums[mid]-nums[left];
            if(midSubLeft>=0)
            {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }

        return res;
    }
}
