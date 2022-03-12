package hard;

import org.junit.Test;

public class num_85 {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) {
            return 0;
        }
        int ans = 0 , m = matrix.length , n = matrix[0].length , area;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    matrix[i][j] += (matrix[i][j - 1] - '0');
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]=='0') {
                    continue;
                }
                int row = i , minWidth = matrix[i][j] - '0';
                while (row>=0&&matrix[row][j]!='0'){
                    int height = i - row + 1 ;
                    minWidth = Math.min(minWidth,(int)(matrix[row][j]-'0'));
                    if((area=height*minWidth)>ans) {
                        ans = area ;
                    }
                    row--;
                }
            }
        }
        return ans ;
    }
}
