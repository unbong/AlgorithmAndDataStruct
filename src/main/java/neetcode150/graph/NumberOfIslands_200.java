package neetcode150.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NumberOfIslands_200 {

    /**
     * 如果发现是一个大陆，则从该点开始进行广度优先的探索，并标记与初始的店相连的点。
     *  如果发现了一个这样的点时，就将其计数加1
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int i = grid.length;
        int j = grid[0].length;
        boolean[][] isAccessed = new boolean[i][j];
        int count = 0;
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                if(!isAccessed[k][l] && grid[k][l] == '1'){
                    bfs(grid, isAccessed, k,l);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, boolean[][] isAccessed, int k, int l) {

        Queue<List<Integer>> queue = new ArrayDeque<>();
        List<Integer> pair = new ArrayList<>();
        isAccessed[k][l] = true;
        pair.add(k);
        pair.add(l);
        queue.add(pair);
        while(!queue.isEmpty())
        {
            pair = queue.poll();

            for(List<Integer>p: adjacent(grid,pair))
            {
                if(!isAccessed[p.get(0)][p.get(1)] && grid[p.get(0)][p.get(1)] == '1')
                {
                    queue.add(p);
                    isAccessed[p.get(0)][p.get(1)] = true;
                }
            }
        }

    }

    private List<List<Integer>> adjacent(char[][] grid, List<Integer> pair) {
        List<List<Integer>> res = new ArrayList<>();
        int i = grid.length;
        int j = grid[0].length;
        int k = pair.get(0);
        int l = pair.get(1);


        int up = k -1;
        int down = k+1;
        int left = l-1;
        int right = l+1;

        if(up >=0)
        {
            List<Integer> p = new ArrayList<>();
            p.add(up);
            p.add(l);
            res.add(p);
        }

        if(down <i){
            List<Integer> p = new ArrayList<>();
            p.add(down);
            p.add(l);
            res.add(p);
        }

        if(left >=0){
            List<Integer> p = new ArrayList<>();
            p.add(k);
            p.add(left);
            res.add(p);
        }

        if(right < j){
            List<Integer> p = new ArrayList<>();
            p.add(k);
            p.add(right);
            res.add(p);
        }

        return res;
    }
}
