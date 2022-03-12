package hard;

import java.util.ArrayList;
import java.util.List;

public class num_37 {
    int[] row = new int[9] , col = new int[9] ;
    int[][] boxes = new int[3][3];
    boolean valid = false ;
    List<int[]> spaces = new ArrayList<>();
    public void solveSudoku(char[][] board) {
        for(int i = 0 ; i < 9 ; i ++){
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.'){
                    int digit = board[i][j] - '1' ;
                    flip(i,j,digit);

                }else{
                    spaces.add(new int[]{i,j});
                }
            }
        }
        dfs(board,0);
    }

    private void dfs(char[][] board, int pos) {
        if(pos == spaces.size()){
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0] , j = space[1];
        //用mask表示该位置可填的数字，mask的二进制数字中，为1的代表可填
        int mask = ~(row[i] | col[j] | boxes[i/3][j/3]) & 0x1ff;
        for(;mask != 0 && !valid;mask&=(mask-1)){
            int digitMask = lowbit(mask);
            int digit = Integer.bitCount(digitMask-1);
            flip(i,j,digit);
            board[i][j] = (char) ('1' + digit);
            dfs(board,pos+1);
            flip(i,j,digit);
        }
    }


    private void flip(int i, int j, int digit) {
        row[i] ^= (1 << digit);
        col[j] ^= (1 << digit);
        boxes[i/3][j/3] ^= (1 << digit);
    }

    public int lowbit(int n){
        return n & - n ;
    }

}
