package neetcode150.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchA2DMatrix_74Test {

    @Test
    void searchMatrix() {
        int m[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

        SearchA2DMatrix_74  s = new SearchA2DMatrix_74();
        boolean res =  s.searchMatrix(m, target);

        assertEquals(true, res);


         res =  s.searchMatrix(m, 14);

        assertEquals(false, res);
    }
}