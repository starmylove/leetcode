package hard;

import org.junit.Test;

import java.util.Arrays;

public class num_312 {
    int[] val ;
    int[][] rec ;
    public int maxCoins1(int[] nums) {
        int n = nums.length ;
        val = new int[n + 2] ;
        val[0] = 1 ;
        val[n + 1] = 1 ;
        for (int i = 0; i < n; i++) {
            val[i + 1] = nums[i];
        }
        rec = new int[n + 2][n + 2] ;
        for(int[] row: rec){
            Arrays.fill(row,-1);
        }
        return solve(0,n+1);
    }

    private int solve(int left, int right) {
        if(left >= right - 1){
            return 0 ;
        }
        if(rec[left][right] != -1){
            return rec[left][right];
        }
        for(int mid = left + 1 ; mid < right ; mid ++ ){
            int sum = val[mid] * val[left] * val[right] ;
            sum += solve(left,mid) + solve(mid,right);
            rec[left][right] = Math.max(sum,rec[left][right]);
        }
        return rec[left][right];
    }
    public int maxCoins(int[] nums) {
        int[] val ;
        int[][] rec ;
        int n = nums.length ;
        val = new int[n + 2] ;
        val[0] = 1 ;
        val[n + 1] = 1 ;
        for (int i = 0; i < n; i++) {
            val[i + 1] = nums[i];
        }
        rec = new int[n + 2][n + 2] ;
        int[] mul = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n + 2; j++) {
                //前两个循环，枚举所有区间
                for (int k = i + 1 ; k < j; k++) {
                    //第三个循环，枚举当前区间中所有可能的起始点，既然是起始点，与他相乘的两个秋一定是区间边界
                    int sum = val[k] * val[i] * val[j] ;
                    //然后加上其他两个区间的最大值，此时未被计算或已经计算成功
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(sum,rec[i][j]);
                }
            }
        }
        return rec[0][n+1];
    }
    @Test
    public void test(){
        maxCoins(new int[]{3,1,5,8});
    }
}
