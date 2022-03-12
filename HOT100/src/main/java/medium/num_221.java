package medium;

import org.junit.Test;

public class num_221 {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length , c = matrix[0].length , max = Integer.MIN_VALUE;
        int[][] dp = new int[r+1][c+1];
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] += (1 + ((dp[i-1][j] > 0 && dp[i][j-1] > 0) ? Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) : 0)) ;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max * max ;
    }
    @Test
    public void test(){
        System.out.println(maximalSquare(new char[][]{{'1', '0'}, {'0', '1'}}));
    }
}
