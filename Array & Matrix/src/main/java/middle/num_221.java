package middle;

public class num_221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length , n = matrix[0].length ;
        int[][] dp = new int[m][n];
        int max = 0 ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='1') {
                    max=1;
                }
                if(j==0){
                    dp[i][j] = matrix[i][j] - '0' ;
                }else if(matrix[i][j] == '1'){
                    dp[i][j] = 1 + dp[i][j-1];
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 2; k <= dp[i][j] && i - k + 1 >= 0 && min >= k ; k++) {
                    min = Math.min(min,dp[i-k+1][j]);
                    if(dp[i-k+1][j]<k) {
                        break;
                    }
                    max = Math.max(max, k);
                }
            }
        }
        return max*max;
    }
}
