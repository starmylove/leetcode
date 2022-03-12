package middle;

import org.junit.Test;

public class num_74 {
    //74. 搜索二维矩阵
    /*
    * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。
    * 该矩阵具有如下特性：每行中的整数从左到右按升序排列。
    * 每行的第一个整数大于前一行的最后一个整数。
    * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length , n = matrix[0].length;
        int i = 0 , j = n - 1 ;
        while (i < m && j >= 0 && matrix[i][j] != target){
            if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }
        }
        return i!=m && j>=0;
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length , n = matrix[0].length;
        int l = 0 , r = m - 1;
        if(target < matrix[0][0]) {
            return false;
        }
        while(l < r){
            int mid = (l + r) >> 1 ;
            if(matrix[mid][0] > target){
                r = mid - 1 ;
            }else if(matrix[mid][0] < target){
                l = mid + 1 ;
            }else {
                return true;
            }
        }
        if(matrix[l][0] > target) {
            l--;
        }
        for (int i = 0; i < n; i++) {
            if(matrix[l][i]==target) {
                return true;
            }
        }
        return false;
    }
    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length , n = matrix[0].length;
        int length = m * n , l = 0 , r = length - 1 ;
        while (l <= r){
            int mid = (l + r ) >> 1 ;
            if(matrix[mid/n][mid%n] > target){
                r = mid - 1 ;
            }else if(matrix[mid/n][mid%n] < target){
                l = mid + 1 ;
            }else {
                return true;
            }
        }
        return false;
    }
    public boolean searchMatrix4(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test(){
        searchMatrix4(new int[][]{{1,1}},2);
    }
}

















