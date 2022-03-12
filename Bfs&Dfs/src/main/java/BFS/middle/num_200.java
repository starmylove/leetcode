package BFS.middle;

public class num_200 {
    boolean[][] visited ;
    public int numIslands(char[][] grid) {
        int m = grid.length , n = grid[0].length;
        visited = new boolean[m][n];
        int ans = 0 ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
                    bfs( i , j ,  grid , m , n );
                }
            }
        }
        return ans ;
    }
    void bfs(int i , int j , char[][] grid , int m , int n){
        visited[i][j] = true ;
        if(i - 1 >= 0 && grid[i-1][j] == '1' && !visited[i-1][j]) {
            bfs(i-1,j,grid,m,n);
        }
        if(j - 1 >= 0 && grid[i][j-1] == '1' && !visited[i][j-1]) {
            bfs(i,j-1,grid,m,n);
        }
        if(i + 1 < m && grid[i+1][j] == '1' && !visited[i+1][j]) {
            bfs(i+1,j,grid,m,n);
        }
        if(j + 1 < n && grid[i][j+1] == '1' && !visited[i][j+1]) {
            bfs(i,j+1,grid,m,n);
        }
    }
}
