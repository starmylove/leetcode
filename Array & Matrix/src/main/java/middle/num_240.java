package middle;

public class num_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length , n = matrix[0].length , i = 0 , j = 0 ;
        while (i<m&&j<n){
            if(matrix[i][j]>target|| target > matrix[m-1][n-1]) {
                return false;
            }
            if(target>matrix[i][n-1]){
                i++;
                continue;
            }
            if(target>matrix[m-1][j]){
                j++;
                continue;
            }
            for (int k = j; k < n; k++) {
                if(matrix[i][k]==target) {
                    return true;
                }
                if(matrix[i][k]>target){
                    i++;
                    break;
                }
            }
            for (int k = i; k < m; k++) {
                if(matrix[k][j]==target) {
                    return true;
                }
                if(matrix[k][j]>target){
                    j++;
                    break;
                }
            }
        }
        return false;
    }
    private int[][] matrix;
    private int target;

    private boolean searchRec(int left, int up, int right, int down) {
        // this submatrix has no height or no width.
        if (left > right || up > down) {
            return false;
            // `target` is already larger than the largest element or smaller
            // than the smallest element in this submatrix.
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }
        int mid = left + (right-left)/2;
        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }
        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
    }

    public boolean searchMatrix1(int[][] mat, int targ) {
        // cache input values in object to avoid passing them unnecessarily
        // to `searchRec`
        matrix = mat;
        target = targ;

        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j]== target) {
                return true;
            }
            if (matrix[i][j] < target ) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
