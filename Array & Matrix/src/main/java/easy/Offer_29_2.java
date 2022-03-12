package easy;

import org.junit.Test;

public class Offer_29_2 {
    //剑指 Offer 29. 顺时针打印矩阵
    //输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int l = 0 , r = matrix[0].length-1 , t = 0 , b = matrix.length-1;
        int[] ans = new int[(r+1)*(b+1)];
        int x = 0 ;
        while (true){
            for (int i = l; i <= r; i++) {
                ans[x++] = matrix[t][i];
            }
            if(++t>b) {
                break;
            }
            for (int i = t; i <= b; i++) {
                ans[x++] = matrix[i][r];
            }
            if(--r<l) {
                break;
            }
            ;
            for (int i = r; i >= l; i--) {
                ans[x++] = matrix[b][i];
            }
            if(--b<t) {
                break;
            }
            for (int i = b; i >=  t; i--) {
                ans[x++] = matrix[i][l];
            }
            if (++l>r) {
                break;
            }
        }
        return ans;
    }
    public int[] spiralOrder2(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while(true) {
            for(int i = l; i <= r; i++) {
                res[x++] = matrix[t][i]; // left to right.
            }
            if(++t > b) {
                break;
            }
            for(int i = t; i <= b; i++) {
                res[x++] = matrix[i][r]; // top to bottom.
            }
            if(l > --r) {
                break;
            }
            for(int i = r; i >= l; i--) {
                res[x++] = matrix[b][i]; // right to left.
            }
            if(t > --b) {
                break;
            }
            for(int i = b; i >= t; i--) {
                res[x++] = matrix[i][l]; // bottom to top.
            }
            if(++l > r) {
                break;
            }
        }
        return res;
    }
    @Test
    public void test(){
        int[][] t = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] ints = spiralOrder(t);
        System.out.println(ints);
    }
}
