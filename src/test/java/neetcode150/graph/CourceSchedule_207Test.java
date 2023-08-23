package neetcode150.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourceSchedule_207Test {

    @Test
    void canFinish() {

        int[][] prerequisites = {{1,0}};

        CourceSchedule_207 c = new CourceSchedule_207();
        boolean res = c.canFinish(2, prerequisites);
        assertEquals(true, res);


        int[][] prerequisites1 = {{1,0}, {0,1}};

        res = c.canFinish(2, prerequisites1);
        assertEquals(false, res);

    }
}