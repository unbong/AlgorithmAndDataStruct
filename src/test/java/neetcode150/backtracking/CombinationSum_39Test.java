package neetcode150.backtracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSum_39Test {

    @Test
    void combinationSum() {

        int[] candidate ={2,3,6,7};
        int target = 7;
        CombinationSum_39 c = new CombinationSum_39();
        List<List<Integer>> s = c.combinationSum(candidate, target);

        for(List<Integer> l:s){
            System.out.println(l.toString());
        }

        s = c.combinationSum(candidate,8);
        s.stream().forEach(item->System.out.println(item));

        int [] c2 = {8,7,4,3};

        s = c.combinationSum(c2, 11);
        s.stream().forEach(item->System.out.println(item));

    }
}