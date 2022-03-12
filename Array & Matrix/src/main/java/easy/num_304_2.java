package easy;

public class num_304_2 {
    int[][] matrix;
    public num_304_2(int[][] _matrix) {
        int m = _matrix.length , n = _matrix[0].length;
        this.matrix = _matrix ;
        for (int i = 0; i < m ; i++) {
            for (int j = 1; j < n ; j++) {
                matrix[i][j] += matrix[i][j-1];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] += matrix[i-1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2][col2] - (col1>0?matrix[row2][col1-1]:0) - (row1>0?matrix[row1-1][col2]:0) + (row1>0&&col1>0?matrix[row1-1][col1-1]:0);
    }
}
