package neetcode150.graph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslands_200Test {

    @Test
    void numIslands() {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        NumberOfIslands_200 n = new NumberOfIslands_200();
        int c = n.numIslands(grid);
        assertEquals(1, c);



        char[][]  grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '0', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        c = n.numIslands(grid2);
        assertEquals(3, c);
    }
}