package neetcode150.array;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

public class ContainsDuplicates_217 {

//    public boolean containsDuplicate(int [] nums){
//
//        if(nums.length <= 1) return false;
//
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length; i++) {
//            if(nums[i-1] == nums[i])
//            {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean containsDuplicate(int [] nums){

        if(nums.length <= 1) return  false;

        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            if(hash.contains(nums[i])) return true;
            hash.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int [] n1 ={1};

        ContainsDuplicates_217 c = new ContainsDuplicates_217();
        assert(false==c.containsDuplicate(n1));

        int [] n2 = {1,2};

        assert (false == c.containsDuplicate(n2));

        int [] n3 ={1,10, 2,1};
        assert (true == c.containsDuplicate(n3));


    }
}
