package neetcode150.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaciFICAtlanticWaterFlow_417Test {

    @Test
    void pacificAtlantic() {
        
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};

        PaciFICAtlanticWaterFlow_417 p = new PaciFICAtlanticWaterFlow_417();
        List<List<Integer>> res =  p.pacificAtlantic(heights);

        res.stream().forEach(item->System.out.println(item.toString()));
    }
}