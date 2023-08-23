package neetcode150.slidingwindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBusAndSell_121Test {

    @Test
    void maxProfit() {
        BestTimeToBusAndSell_121 b = new BestTimeToBusAndSell_121();
        int[] prices = {7,1,5,3,6,4};
        int res = b.maxProfit(prices);
        assertEquals(5, res);

        int p1[] = {7,6,4,3,1};
        res = b.maxProfit(p1);
        assertEquals(0, res);

        int p2[] = {1,2,4,2,5,7,2,4,9,0,9};
        res = b.maxProfit(p2);
        assertEquals(9,res);

    }
}