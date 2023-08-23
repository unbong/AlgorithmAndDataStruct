package neetcode150.slidingwindow;

public class BestTimeToBusAndSell_121 {


    /**
     * 想到了两个办法 ，
     *  1 一个是从左至右扫描最小，从右至左扫描最大
     *      然后判断 索引 如果左比右小 则说明找到了最大收益 没有则说明为0
     *      O(2n)
     *
     *  2 一个买入指针，一个卖出指针， 初始时制定在0 和1  循环至
     *      * 如果买入小于卖出则 两个指针都向左移动一格
     *      * 如果买入大于卖出，则只移动卖出，并记录收益。
     *
     *      时间时间复杂度为0（n)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int buy = 0;
        int sell = 1;
        int record =0;
        while(buy < prices.length-1 && sell<prices.length )
        {
            int profit =prices[sell] - prices[buy];
            if(profit <= 0)
            {
                buy=sell;
                sell++;
            }
            else{
                if(record < profit) record = profit;
                sell++;
            }
        }

        return record;
    }
}
