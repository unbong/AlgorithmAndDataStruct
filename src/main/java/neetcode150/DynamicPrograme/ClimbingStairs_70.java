package neetcode150.DynamicPrograme;

public class ClimbingStairs_70 {

    /**
     * 使用递归的方式逐步向下求解各种可能得解的个数，同时保存当前解得的个数。
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        int res = 0;
        int[] memo = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            memo[i] = -1;
        }

        for (int i = 1; i <= 2; i++) {
           res += count(n-i, memo,res);
        }
        return res;
    }

    private int count(int n, int[] memo,int res) {
        if(n <0) return 0;
        if (n ==0 ) return 1;

        if(memo[n] != -1) return memo[n];
        for (int j = 1; j < 3; j++) {
            res += count(n-j , memo, res);
        }

        memo[n] = res;
        return res;
    }
}
