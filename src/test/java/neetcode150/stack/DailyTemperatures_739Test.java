package neetcode150.stack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperatures_739Test {

    @Test
    void dailyTemperatures() {
        int [] temp = {73,74,75,71,69,72,76,73};
        int res[] = {1,1,4,2,1,1,0,0};

        DailyTemperatures_739 d = new DailyTemperatures_739();
        int [] result = d.dailyTemperatures(temp);
        assertEquals(true, Arrays.equals(res, result));


        int [] temp2 = {30,40,50,60};
        int res2[] = {1,1,1,0};

        result = d.dailyTemperatures(temp2);
        assertEquals(true, Arrays.equals(res2, result));

        int[] tmp3 = {30, 60,90111};
        int res3[] = {1,1,0};
        result = d.dailyTemperatures(tmp3);
        assertEquals(true, Arrays.equals(res3, result));

    }
}