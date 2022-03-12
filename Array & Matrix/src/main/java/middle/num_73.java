package middle;

public class num_73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        boolean [] row = new boolean[m] , col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                if(row[i] || col[j]) {
                    matrix[i][j]=0;
                }
            }
        }
    }
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length , n = matrix[0].length;
        boolean row0flag = false , col0flag = false;
        for (int i = 0; i < m; i++) {
            if(matrix[i][0]==0){
                col0flag=true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if(matrix[0][i]==0){
                row0flag = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j]==0) {
                    matrix[i][0] = matrix[0][j] = 0 ;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][0] ==0 ||  matrix[0][j] == 0) {
                    matrix[i][j] = 0 ;
                }
            }
        }
        if(row0flag){
            for (int i = 0; i < n; i++) {
                matrix[0][i]=0;
            }
        }
        if(col0flag){
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }
    }
}
