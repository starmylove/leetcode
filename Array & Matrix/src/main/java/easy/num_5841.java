package easy;

import org.junit.Test;

public class num_5841 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int length = obstacles.length;
        int[][][] dp = new int[length][length][2];
        for (int i = 0; i < length; i++) {
            dp[i][i][0]=1;
            dp[i][i][1]=obstacles[i];
        }
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int num = obstacles[j];
                int index = j -1;
                while (dp[i][index][1]>num) {
                    index--;
                }
                if(index<i){
                    dp[i][j][0]=1;
                    dp[i][j][1]=obstacles[j];
                }
                if(index==j){
                    dp[i][j][0]=dp[i][j-1][0]+1;
                    dp[i][j][1]=obstacles[j];
                }
                else {
                    dp[i][j][0]=dp[i][index][0]+1;
                    dp[i][j][1]=obstacles[j];
                }
//                dp[i][j][0]=dp[i][index][0]+1;
//                dp[i][j][1]=obstacles[j];
//                if(obstacles[j]>=dp[i][j-1][1]) {
//
//                }
//                else {
//                    dp[i][j][0]=0;
//                    dp[i][j][1]=dp[i][j-1][1];
//                }
            }
        }
        int[] ans = new int[length];
        for (int col = 0; col < length; col++) {
            for (int row = 0 ; row <= col ; row++) {
                if(dp[row][col][0]>ans[col]) {
                    ans[col] = dp[row][col][0];
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums = new int[]{2,2,1};
        int[] ints = longestObstacleCourseAtEachPosition(nums);
    }
}
