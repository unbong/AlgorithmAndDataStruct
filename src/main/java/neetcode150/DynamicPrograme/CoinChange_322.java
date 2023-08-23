package neetcode150.DynamicPrograme;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange_322 {

    /**
     *
     * @param coins
     * @param amount
     * @return
     */
//    public int coinChange(int[] coins, int amount) {
//
//        if(amount ==0 ) return  0;
//        int[] min = {Integer.MAX_VALUE};
//        Arrays.sort(coins);
//        find(coins, amount, 0, , min);
//        if(min[0] == Integer.MAX_VALUE) return -1;
//        return min[0];
//    }
//
//    private int find(int[] coins, int amount,  int count, Map<Integer, Integer> dp, int[] min) {
//        if(amount < 0) return -1;
//        if(amount ==0)
//        {
//            return count;
//        }
//
//        if(dp.containsKey(amount) && dp.get(amount) <0) return -1;
//        int res = -1;
//        for (int i = coins.length-1; i >= 0; i--) {
//
//            int r  = find(coins, amount- coins[i], count+1, dp, min);
//            if(r > 0){
//                min[0] = Math.min(min[0], r);
//                res= min[0];
//            }
//        }
//
//        dp.put(amount, res);
//        return res;
//    }
}
