package neetcode150.DynamicPrograme;

import java.util.Arrays;

public class DecodeWays_91 {


    /**
     * 基本上是两种模式
     *   选择一个字符
     *      字符不能是0
     *   选择两个字符
     *      第一个字符不能是0， 两个字符不能大约'26'
     *   规划的公式
     *      当选择一个字符时，从剩下的字符中选择可能性
     *      当选择两个字符时，从剩下的字符中选择可能性
     *      保存中间结果的数据结构，需要用当前要调查的字符的长度作为索引，这里使用了结束字符的位置作为了索引。
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        int [] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        char[] chars = s.toCharArray();
        int count = 0;
        count += findWay(chars, 0, 0, dp) ;
        count += findWay(chars,0,1, dp);

        return count;
    }

    private int findWay(char[] s, int start ,int end ,int[] dp) {
        if(end >= s.length) return 0;

        if(s[start] =='0' )
        {
            return 0;
        }
        if((end>start && s[start] >'2') || (  end>start && s[start] =='2' && s[end] >'6')) return 0;

        if(end == s.length-1) return 1;
        int count = 0;
        if(dp[end] !=-1)
            return dp[end];

        count += findWay(s, end+1, end+1, dp);
        count += findWay(s, end+1, end+2, dp);
        if(dp[end] == -1)
            dp[end] = count;
        return count;
    }


}
