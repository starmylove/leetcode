package medium;

public class num_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length , n = matrix[0].length ;
        int r = 0 , c = n - 1 ;
        while (r < m && c >= 0){
            if(matrix[r][c] == target){
                return true;
            }else if(matrix[r][c] > target){
                c -- ;
            }else {
                r ++ ;
            }
        }
        return false;
    }
}
