package neetcode150.backtracking;

import java.util.*;

public class CombinationSum_39 {


    private void search(int[] candidates, int target, int s, List<List<Integer>> res, List<Integer> list)
    {
        if(target ==0 ){
            res.add(new ArrayList<>(list));
            return;
        }


        for (int i = s; i < candidates.length; i++) {
            if(candidates[i]> target) break;
            list.add(candidates[i]);
            search(candidates, target-candidates[i], i, res, list);
            list.remove(list.size()-1);
        }
    }

    /**
     * 组合问题的一种变种，在递归中，循环中，当前点的左侧不进行考虑，只关注当前索引的右侧
     *   排列与组合问题的详细说明参考 leetcode39 的视频 https://www.youtube.com/watch?v=zIY2BWdsbFs
     * @param candidates
     * @param target
     * @return
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        search(candidates, target,0, res, new ArrayList<>() );

        return  res;

    }

//
//    private void search(int[] candidates, int target, List<List<Integer>> res, List<Integer> list){
//
//        if(target < 0) return;
//
//        if(target == 0){
//            res.add(new ArrayList<>(list));
//            return;
//        }
//
//        for(int item: candidates){
//            list.add(item);
//            search(candidates,target-item, res, list);
//            list.remove(list.size()-1);
//        }
//
//    }
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//
//        List<List<Integer>> combs = new ArrayList<>();
//        List<List<Integer>> res = new ArrayList<>();
////        for(int item: candidates)
////            set.add(item);
////
////
////        if(set.contains(target)) {
////            List<Integer> list = new ArrayList<>();
////            list.add(target);
////            combs.add(list);
////        }
//
//        for (int item :candidates) {
//            List<Integer> list = new ArrayList<>();
//            list.add(item);
//
//            search(candidates, target-item , combs, list);
//            list.remove(list.size()-1);
//
//        }
//
//        Set<List<Integer>> distinct = new HashSet<>();
//        for(List<Integer> comb : combs){
//
//            comb.sort(Integer::compareTo);
//            if(!distinct.contains(comb)){
//                distinct.add(comb);
//                res.add(comb);
//            }
//        }
//
//        return res;
//    }
}
