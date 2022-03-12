package middle;

import com.sun.org.apache.bcel.internal.generic.SWAP;

public class num_48 {
    /*
    * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。
    * 请你将图像顺时针旋转 90 度。
    * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。
    * 请不要 使用另一个矩阵来旋转图像。
    * */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            int top = i , left = i , right = n - 1 - i , bottom = n - 1 - i ;
            for (int j = left; j < right; j++) {
                int index = j - left ;
                int     tempLT = matrix[top][left+index] ,
                        tempRT = matrix[top+index][right],
                        tempRB = matrix[bottom][right-index];
                matrix[top][left+index] = matrix[bottom-index][left];
                matrix[bottom-index][left] = tempRB;
                matrix[bottom][right-index] = tempRT;
                matrix[top+index][right] = tempLT;
            }
        }
    }
}
