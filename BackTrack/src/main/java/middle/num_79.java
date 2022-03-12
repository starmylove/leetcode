package middle;

import org.junit.Test;

public class num_79 {
    /*
    * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
    * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
    * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
    * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    * 同一个单元格内的字母不允许被重复使用。
    * */
    private boolean[][] visited ;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board,word,i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word , int i, int j, int index ) {
        if(word.charAt(index) != board[i][j]) {
            return false;
        }
        if(index == word.length()-1) {
            return true;
        }
        visited[i][j] = true ;
        if(isValid(i+1,j) && dfs(board,word,i+1,j,index+1)) {
            return true;
        }
        if(isValid(i-1,j) && dfs(board,word,i-1,j,index+1)) {
            return true;
        }
        if(isValid(i,j+1) && dfs(board,word,i,j+1,index+1)) {
            return true;
        }
        if(isValid(i,j-1) && dfs(board,word,i,j-1,index+1)) {
            return true;
        }
        visited[i][j] = false ;
        return false;
    }

    private boolean isValid(int i, int j) {
        if(i < 0 || i >= visited.length || j < 0 || j >= visited[0].length ) {
            return false;
        }
        return !visited[i][j];
    }

    @Test
    public void test(){
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board = new char[][]{{'A'}};
        boolean exist = exist(board, "ABCCEESEC");
        System.out.println(exist);
    }
}
