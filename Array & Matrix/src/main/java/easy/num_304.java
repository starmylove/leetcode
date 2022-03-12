package easy;

public class num_304 {
    int[][] matrix;
    public num_304(int[][] _matrix) {
        int m = _matrix.length , n = _matrix[0].length;
        this.matrix = new int[m+1][n+1] ;
        for (int i = 1; i <= m ; i++) {
            int rowSum = 0 ;
            for (int j = 1; j <= n ; j++) {
                rowSum += _matrix[i-1][j-1] ;
                matrix[i][j] = rowSum + matrix[i-1][j] ;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2+1][col2+1] - matrix[row2+1][col1] - matrix[row1][col2+1] + matrix[row1][col1];
    }
}
