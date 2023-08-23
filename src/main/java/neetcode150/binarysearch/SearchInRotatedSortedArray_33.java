package neetcode150.binarysearch;

public class SearchInRotatedSortedArray_33 {



    private int binarySearch(int[] nums, int left, int right, int target)
    {

        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid] < target )
            {
                left = mid+1;
            }
            else if(nums[mid] > target){
                right = mid-1;
            }
            else{
                return mid;
            }
        }

        return -1;
    }

    /**
     * 因为中间某一处发上了翻转，因此除了翻转处以外都是排好序的状态
     *  假设左边与中间是出于上升的顺序，则可以在左边于中间之间执行二分搜索，如果找到则返回该位置，否则在中间的右侧处进行搜索
     *  如果左边于中间不是上升的顺序，则说明在中间与右侧是排好序的状态，因此可以在中间与右侧执行二分搜索。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid ;
        int res =-1;

        while(left<=right){
            if(nums[left] < nums[right]){
                int idx = binarySearch(nums, left,right,target);
                if(idx != -1) return idx;
            }
            mid = (left+right) /2;

            if(nums[left] <= nums[mid])
            {
                int idx = binarySearch(nums, left,mid, target);
                if(idx == -1){
                    left = mid+1;
                }
                else{
                    return idx;
                }
            }
            else
            {
                int idx = binarySearch(nums, mid, right, target);
                if(idx == -1){
                    right = mid-1;
                }
                else {
                    return idx;
                }
            }
        }

        return res;
    }
}
