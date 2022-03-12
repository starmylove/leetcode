package medium;

import org.junit.Test;

public class num_48 {
    public void rotate(int[][] matrix) {
        int top = 0 , bottom = matrix.length - 1 , right = bottom , left = 0 ;
        while(left < right){
            for (int i = 0; left + i < right ; i++) {
                int lt = matrix[top][left+i] , rt = matrix[top+i][right] ;
                int lb = matrix[bottom-i][left] , rb = matrix[bottom][right-i] ;
                int temp = lt ;
                matrix[top][left+i] = lb ;
                matrix[bottom-i][left] = rb ;
                matrix[bottom][right-i] = rt ;
                matrix[top+i][right] = temp ;
            }
            left ++ ;
            right -- ;
            top ++ ;
            bottom -- ;
        }
    }
    @Test
    public void test(){
        rotate(new int[][]{{5,1,9,11},{5,1,9,11},{5,1,9,11},{5,1,9,11}});
    }
}