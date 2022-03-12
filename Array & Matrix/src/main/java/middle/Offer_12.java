package middle;


public class Offer_12 {
    /*
    给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
    如果 word 存在于网格中，返回 true ；否则，返回 false 。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中
    “相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
    */
    public static void main(String[] args) {
        char[][] chars = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] chars = new char[][]{{'A','B'},{'S','D'}};
        boolean ans = exist(chars, "ABCCEDFSA");
        System.out.println(ans);
    }
    public static boolean exist(char[][] board, String word) {
        int[][] flag = new int[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for(int m = 0; m < board.length; m++) {
            for ( int n = 0; n < board[0].length; n++){
                flag[m][n] = 1;
                if(!word.contains(new String(new char[]{board[m][n]}))) {
                    flag[m][n] = 0;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exists(board, word, i, j, flag)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean exists(char[][] board, String word, int i, int j,int[][] flag){
        if(word.length()==0) {
            return false;
        }
        if(word.length()==1) {
            return true;
        }
        flag[i][j] = 0 ;
        if(i+1<board.length &&  flag[i+1][j]==1 && board[i+1][j]==word.charAt(1)&&exists(board,word.substring(1,word.length()),i+1,j,flag)) {
            return true;
        }
        if(i-1>=0 &&  flag[i-1][j]==1 && board[i-1][j]==word.charAt(1)&&exists(board,word.substring(1,word.length()),i-1,j,flag)) {
            return true;
        }
        if(j+1<board[0].length &&  flag[i][j+1]==1 && board[i][j+1]==word.charAt(1)&&exists(board,word.substring(1,word.length()),i,j+1,flag)) {
            return true;
        }
        if(j-1>=0 &&  flag[i][j-1]==1 && board[i][j-1]==word.charAt(1) &&exists(board,word.substring(1,word.length()),i,j-1,flag)) {
            return true;
        }
        flag[i][j] = 1 ;
        return false;
    }

    //官方题解

    public boolean exist1(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if(k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
    public boolean exists2(char[][] board, String word){
        char[] words = word.toCharArray();
        for(int i = 0 ; i < board.length ; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if(exists1(board,words,0,0,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exists1(char[][] board, char[] word, int i, int j, int k){
        if(i<0 || i>= board.length || j<0 || j>=board[0].length || board[i][j]!=word[k]) {
            return false;
        }
        if(k == word.length-1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

}
