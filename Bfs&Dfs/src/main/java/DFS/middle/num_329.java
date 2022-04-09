package DFS.middle;

import org.junit.Test;

public class num_329 {
    int m, n;
    int ans = 0;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] cache;
    boolean[][] visited;

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cache[i][j] == 0) {
                    ans = Math.max(ans, cache[i][j] = dfs(matrix, i, j));
                } else {
                    ans = Math.max(ans, cache[i][j]);
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] matrix, int i, int j) {
        int max = 0;
        for (int k = 0; k < 4; k++) {
            int x = i + dirs[k][0], y = j + dirs[k][1];
            if (x < 0 || x == m || y < 0 || y == n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            if (cache[x][y] == 0) {
                cache[x][y] = dfs(matrix, x, y);
            }
            max = Math.max(max, cache[x][y]);
        }
        cache[i][j] = max + 1;
        return cache[i][j];
    }

    @Test
    public void test() {
        System.out.println(longestIncreasingPath(new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}));
    }
}