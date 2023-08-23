package neetcode150.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphValidTree_261Test {

    @Test
    void validTree() {
        int[][] edges={{0,1},{0,2},{0,3},{1,4},{2,3}};

        GraphValidTree_261 g = new GraphValidTree_261();
        boolean res = g.validTree(6, edges);

        assertEquals(true, res);
    }
}