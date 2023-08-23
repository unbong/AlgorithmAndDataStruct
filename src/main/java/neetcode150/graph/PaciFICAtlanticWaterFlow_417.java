package neetcode150.graph;

import java.util.ArrayList;
import java.util.List;

public class PaciFICAtlanticWaterFlow_417 {

    class Pair {
        final int x;
        final int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {

            if(this == obj ) return true;
            if(!(obj instanceof Pair)) return false;
            Pair p = (Pair) obj;
            return x == p.x && y ==  p.y;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31*result + x;
            result = 31*result + y;
            return result;
        }

        public List<Integer> getDataAsList(){
            List<Integer> list = new ArrayList<>();
            list.add(x);
            list.add(y);
            return list;
        }
    }

    /**
     * 用深度优先探索去找到每一个节点能够到达的节点后检查是否满足问题的条件。
     *
     * 还有一种思路为，在四个边开始寻找能够到达的节点，然后检查某个节点能否满足问题的条件
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int i = heights.length;
        int j = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                boolean[][] mark = new boolean[i][j];
                Pair pair = new Pair(k, l);
                dfs(heights, mark, pair, heights[k][l]);
                if (check(mark)){
                    res.add(pair.getDataAsList());
                }
            }
        }

        return res;
    }

    private boolean check(boolean[][] mark) {

        int i = mark.length;
        int j = mark[0].length;
        boolean pacific = false;
        boolean atlantic = false;

        // left pacific
        for (int k = 0; k < i ; k++) {
            if( mark[k][0] ){
                pacific = true;
                break;
            }
        }

        // top pacific
        for(int k = 0; k < j; k++){
            if( ! pacific && mark[0][k]){
                pacific =  true;
                break;
            }
        }

        // right atlantic

        for (int k = 0; k < i; k++) {
            if(mark[k][j-1]){
                atlantic = true;
                break;
            }
        }

        for (int k = 0; k < j; k++) {
            if(! atlantic && mark[i-1][k]){
                atlantic =  true;
                break;
            }
        }

        return  pacific && atlantic;
    }

    private void dfs(int[][] heights, boolean[][] mark, Pair pair, int orgHeight) {


        int i = heights.length;
        int j = heights[0].length;


        if(pair.x >=0 && pair.x < i
           && pair.y >=0 && pair.y < j  &&
                !mark[pair.x][pair.y])
        {
            int height =  heights[pair.x][pair.y];
            if(orgHeight < heights[pair.x][pair.y]) return;
            mark[pair.x][pair.y] = true;
            dfs(heights,mark, new Pair(pair.x-1, pair.y), height);
            dfs(heights,mark, new Pair(pair.x+1, pair.y), height);
            dfs(heights,mark, new Pair(pair.x, pair.y-1), height);
            dfs(heights,mark, new Pair(pair.x, pair.y+1), height);
        }
    }
}
