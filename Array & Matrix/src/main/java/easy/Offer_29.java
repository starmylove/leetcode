package easy;

public class Offer_29 {
    //剑指 Offer 29. 顺时针打印矩阵
    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    public int[] spiralOrder(int[][] matrix) {
        //以下是螺旋矩阵的代码
        int length = matrix[0].length , len = length-1;
        int row=0,col=0;
        int[] ans = new int[length*length];
        int index = 0 ;
        for (int i = 0; i < length/2; i++) {
            for (int j = 0; j < len; j++) {
                ans[index++] = matrix[row][col];
                col++;
            }
            for (int j = 0; j < len; j++) {
                ans[index++] = matrix[row][col];
                row++;
            }
            for (int j = 0; j < len; j++) {
                ans[index++] = matrix[row][col];
                col--;
            }
            for (int j = 0; j < len; j++) {
                ans[index++] = matrix[row][col];
                row--;
            }
            len-=2;
        }
        if((length&1)==1) {
            ans[length*length-1]= matrix[length/2][length/2];
        }
        return ans;
    }
}
