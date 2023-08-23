package neetcode150.stack;

import edu.princeton.cs.algs4.Out;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFleet_853Test {

    @Test
    void carFleet() {

        int target = 12;
        int []position = {10,8,0,5,3};
        int speed[] = {2,4,1,1,3};
        int Output= 3;
        CarFleet_853 c = new CarFleet_853();
        int result = c.carFleet(target, position, speed);
        assertEquals(Output, result);


        target = 10;
        int []position2 = {3};
        int speed2[] = {3};
        Output= 1;
        result = c.carFleet(target, position2, speed2);
        assertEquals(Output, result);

        target = 100;
        int []position3 = {0,2,4};
        int speed3[] = {4,2,1};
        Output= 1;
        result = c.carFleet(target, position3, speed3);
        assertEquals(Output, result);


        target = 10;
        int []position4 = {0,4,2};
        int speed4[] = {2,1,3};
        Output= 1;
        result = c.carFleet(target, position4, speed4);
        assertEquals(Output, result);

    }

}