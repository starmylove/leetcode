package medium;

public class num_200 {
    int row , col ;
    int[][] dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int ans = 0 ;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == '1'){
                    ans ++ ;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0' ;
        for (int k = 0; k < 4; k++) {
            dfs(grid,i+dirs[k][0],j+dirs[k][1]);
        }
    }
}
