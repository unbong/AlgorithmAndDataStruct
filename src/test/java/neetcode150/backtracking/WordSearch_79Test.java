package neetcode150.backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearch_79Test {

    @Test
    void exist() {

       char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
       String word = "ABCCED";
       WordSearch_79 w = new WordSearch_79();
       boolean res=w.exist(board, word);
       assertEquals(true, res);


        res=w.exist(board, "SEE");
        assertEquals(true, res);

        res=w.exist(board, "ABCB");
        assertEquals(false, res);


        char [][] board2 = {{'A','A','A','A'},{'A','A','A','A'},{'A','A','A','A'}};
        word = "AAAAAAAAAAAAA";
        res = w.exist(board2, word);

        assertEquals(false, res);

    }
}