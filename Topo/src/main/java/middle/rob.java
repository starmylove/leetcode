package middle;

import org.junit.Test;

public class rob {
    boolean[][] obs, visited;
    int ans = 0;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] dirRecord;
    int m, n;

    public int solution(String[] strs) {
        if (strs[0].charAt(0) == 'X') {
            return 0;
        }
        m = strs.length;
        n = strs[0].length();
        boolean[][] obs = new boolean[m][n];
        dirRecord = new int[m][n];
        visited = new boolean[m][n];
        this.obs = obs;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (strs[i].charAt(j) == 'X') {
                    obs[i][j] = true;
                }
            }
        }
        d(0, 0, 0);
        return ans;
    }
    private void d(int i, int j, int dirIndex) {
        int[] dir = dirs[dirIndex];
        if (!visited[i][j]) {
            ans++;
            dirRecord[i][j] = dirIndex;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            dir = dirs[dirIndex];
            int nextI = i + dir[0], nextJ = j + dir[1];
            if (isValid(i + dir[0], j + dir[1])) {
                if (visited[nextI][nextJ] && dirRecord[nextI][nextJ] == dirIndex) {
                    return;
                }
                d(nextI, nextJ, dirIndex);
                return;
            }
            dirIndex = (dirIndex + 1) % 4;
        }
    }
    public boolean isValid ( int i, int j){
        if (i < 0 || i == m || j < 0 || j == n) {
            return false;
        }
        return !obs[i][j];
    }

    @Test
    public void test(){
        int solution = solution(new String[]{"...X..", "....XX", "..X..."});
        System.out.println(solution);
    }
}