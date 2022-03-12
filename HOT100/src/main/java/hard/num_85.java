package hard;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class num_85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length , n = matrix[0].length ;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 0){
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0 ;
                }else if(matrix[i][j] == '1'){
                    dp[i][j] += 1 + dp[i][j-1] ;
                }
            }
        }
        int max = 0 ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(dp[i][j] == 0){
                    continue;
                }
                if(i == 0){
                    max = Math.max(max,dp[i][j]);
                }else {
                    int row = i , minWidth = Integer.MAX_VALUE ,height = 1;
                    while(row >= 0 && dp[row][j] != 0){
                        minWidth = Math.min(minWidth,dp[row][j]);
                        max = Math.max(max,height * minWidth);
                        height ++ ;
                        row -- ;
                    }
                }
            }
        }
        return max ;
    }
    public int maximalRectangle1(char[][] matrix) {
        int m = matrix.length , n = matrix[0].length ;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 0){
                    dp[i][j] = matrix[i][j] == '1' ? 1 : 0 ;
                }else if(matrix[i][j] == '1'){
                    dp[i][j] += 1 + dp[i][j-1] ;
                }
            }
        }
        int ans = 0 ;
        for (int j = 0; j < n; j++) {
            Deque<Integer> stack = new ArrayDeque<>();
            int len = m ;
            int[] left = new int[len] , right = new int[len] ;
            left[0] = -1 ;
            right[len - 1] = len ;
            //寻找每个元素左侧第一个比自己小的
            stack.push(0);
            for (int i = 1; i < len; i++) {
                while(!stack.isEmpty() && dp[i][j] <= dp[stack.peek()][j]){
                    right[stack.pop()] = i ;
                }
                if(stack.isEmpty()){
                    left[i] = -1 ;
                }else {
                    left[i] = stack.peek();
                }
                stack.push(i);
            }
            while (!stack.isEmpty()){
                right[stack.pop()] = len ;
            }
            for (int i = 0; i < len; i++) {
                ans = Math.max(ans,(right[i] - left[i] - 1) * dp[i][j]);
            }

        }
        return ans ;
    }
    @Test
    public void test(){
        maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
}
