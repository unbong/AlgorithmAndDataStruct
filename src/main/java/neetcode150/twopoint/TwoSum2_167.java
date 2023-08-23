package neetcode150.twopoint;

public class TwoSum2_167 {


    public int[] twoSum(int[] numbers, int target) {

        int [] res = new int[2];
        int key ;
        for (int i = 0; i < numbers.length; i++) {
            key = target - numbers[i];
            int index = binarySearch(numbers, key);

            if(index > i)
            {
                res[0] = i+1;
                res[1] = index+1;
                return res;
            }
            else if(index == i)
            {
                if(index != numbers.length-1 && numbers[i] == numbers[i+1])
                {
                    res[0] = i+1;
                    res[1] = i+2;
                    return res;
                }
            }
        }

        return res;
    }

    private int binarySearch(int[] numbers, int key) {

        int left = 0;
        int right = numbers.length-1;
        int mid ;

        while(left <=right)
        {
            mid = left + (right-left)/2;
            if(numbers[mid] > key)
            {
                right = mid-1;
            }
            else if(numbers[mid] < key)
            {
                left = mid+1;
            }
            else
                return mid;

        }

        return -1;
    }
}
