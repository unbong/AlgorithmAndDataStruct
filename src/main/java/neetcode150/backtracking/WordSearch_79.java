package neetcode150.backtracking;


public class WordSearch_79 {


    public boolean exist(char[][] board, String word) {


        int i = board.length;
        int j = board[0].length;
        int orgx=0;
        int orgy=0;
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                if(board[k][l] == word.charAt(0))
                {
                    if(check(board, word, k, l, 0)) return true;
                }
                orgy = l;
            }
            orgx =k;
        }
        return false;
    }

    /**
     * 排列组合问题的变形的提醒，这里需要注意的是不允许往回跳，因此已经经过的店需要临时修改一下值
     * @param board
     * @param word
     * @param x
     * @param y
     * @param index
     * @return
     */
    private boolean check(char[][] board, String word, int x, int y, int index) {

        int i = board.length;
        int j = board[0].length;

        if(index >= word.length()) return true;


        if(x < 0 || x>=i || y<0 || y >= j) return false;


        if( board[x][y] != word.charAt(index)) return false;

        board[x][y]+=100;
        boolean res = ( check(board, word, x-1, y,index+1)) ||
                        (  check(board, word, x, y-1,index+1) )||
                        ( check(board, word, x+1, y,index+1) )||
                        ( check(board, word, x, y+1,index+1));
        board[x][y]-=100;
        return res;
    }
}
