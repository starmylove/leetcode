package hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {
    int[] rows = new int[9] , cols = new int[9] , boxes = new int[9] ;
    List<int[]> spaces = new ArrayList<>();
    boolean flag = false;
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.'){
                    int num = c - '1' ;
                    flip(i,j,num);
                }else {
                    spaces.add(new int[]{i,j});
                }
            }
        }
        backtrack(board,0);
    }

    public void backtrack(char[][] board, int pos) {
        if(pos == spaces.size()){
            flag = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0] , j = space[1] ;
        //获得pos位置上未填的数字
        int mask = ~ ( rows[i] | cols[j] | boxes[(i / 3 ) * 3 + j / 3] ) & 0x1ff ;
        //mask &= (mask - 1) 将本次for循环用到的数字删除
        for (; mask != 0 && !flag ; mask &= (mask - 1)) {
            //mask的二进制数为1的位置对应的数字(右侧从1算起，左最高至9)，代表该数字已经出现在行或列或box
            //下面从mask中获取右侧第一个为1的位置
            int digitMask = mask & (- mask ) ;
            int digit = Integer.bitCount(digitMask - 1);
            flip(i,j,digit);
            board[i][j] = (char)(digit+'1');
            backtrack(board,pos + 1);
            flip(i,j,digit);
        }
    }

    public void flip(int i , int j , int num){
        int boxIndex = (i / 3 ) * 3 + j / 3 ;
        rows[i] ^= (1 << num);
        cols[j] ^= (1 << num);
        boxes[boxIndex] ^= (1 << num);
    }

    @Test
    public void test1(){
        int a = 8 ;
        int c = ~(a-1);
        int b = a & (-a) ;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(-a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.bitCount(0));

    }

}
