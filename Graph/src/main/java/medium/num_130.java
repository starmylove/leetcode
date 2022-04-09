package medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class num_130  {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length, dummy = m * n;
        UnionFind uf = new UnionFind(dummy + 1);
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0; i < m; i ++){
            if(board[i][0] == 'O'){
                uf.union(dummy, i * n);
            }
            if(board[i][n - 1] == 'O'){
                uf.union(dummy, i * n + n - 1);
            }
        }
        for(int i = 1; i < n - 1; i ++){
            if(board[0][i] == 'O'){
                uf.union(dummy, i);
            }
            if(board[m - 1][i] == 'O'){
                uf.union(dummy, i + (m - 1) * n);
            }
        }
        for(int i = 1; i < m - 1; i ++){
            for(int j = 1; j < n - 1; j ++){
                if(board[i][j] == 'O'){
                    for(int k = 0; k < 4; k ++){
                        int x = i + dirs[k][0];
                        int y = j + dirs[k][1];
                        if(board[x][y] == 'O'){
                            uf.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }
        for(int i = 1; i < m - 1; i ++){
            for(int j = 1; j < n - 1; j ++){
                if(!uf.connect(dummy, i * n + j)){
                    board[i][j] = 'X';
                }
            }
        }
    }
    @Test
    public void test(){
        kthPalindrome(new int[]{1,2,3,4,5,90},3);
    }
    public long[] kthPalindrome(int[] queries, int intLength) {
        boolean old = intLength % 2 == 1;
        int baseLen = intLength / 2;
        if(old){
            baseLen ++;
        }
        long base = 1;
        for (int i = 0; i < baseLen - 1; i++) {
            base *= 10;
        }
        base --;
        long[] ans = new long[queries.length];
        int index = 0;
        for(int q : queries) {
            long query = base + q;
            if((query + "").length() > baseLen){
                ans[index ++] = -1;
                continue;
            }
            long ansi;
            if(old) {
                ansi = Long.parseLong(query + new StringBuilder(query + "").reverse().substring(1));
            }else {
                ansi = Long.parseLong(query + new StringBuilder(query + "").reverse().toString());
            }
            ans[index ++] = ansi;
        }
        return ans;
    }
}
