package medium;

import org.junit.Test;

public class num_79 {
    boolean[][] visited ;
    int m , n ;
    boolean ans = false ;
    public boolean exist(char[][] board, String word) {
        m = board.length ;
        n = board[0].length ;
        if(m == 1 && n == 1){
            return word.length() == 1 && word.charAt(0) == board[0][0] ;
        }
        visited = new boolean[m][n];
        for(int i = 0 ; i < m ; i ++ ){
            for (int j = 0; j < n; j++) {
                dfs(board,word,0,i,j);
                if(ans){
                    break;
                }
            }
            if(ans){
                break;
            }
        }
        return ans;
    }

    private void dfs(char[][] board, String word, int index , int i , int j ) {
        if(ans){
            return;
        }
        if(board[i][j] != word.charAt(index)){
            return ;
        }
        visited[i][j] = true ;
        if(index == word.length() - 1  ){
            ans = true ;
            return  ;
        }
        if(isValid(i+1,j)){
            dfs(board,word,index + 1,i+1,j);
        }
        if(isValid(i,j+1)){
            dfs(board,word,index + 1,i,j+1);
        }
        if(isValid(i-1,j)){
            dfs(board,word,index + 1,i-1,j);
        }
        if(isValid(i,j-1)){
            dfs(board,word,index + 1,i,j-1);
        }
        visited[i][j] = false;
    }
    public boolean isValid(int i , int j ){
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]){
            return false ;
        }
        return true ;
    }

    @Test
    public void test(){
        System.out.println(exist(new char[][]{{'a', 'a'}}, "aaa"));
    }
}
