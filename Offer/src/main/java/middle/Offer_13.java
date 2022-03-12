package middle;

import org.junit.Test;

public class Offer_13 {
    /*
    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
    一个机器人从坐标 [0, 0] 的格子开始移动，
    它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
    例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
    但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
    * */
    @Test
    public void test(){
        int ans = movingCount(3,1,0);
        System.out.println(ans);
    }
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        this.k=k; this.m=m; this.n=n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (getSum(i, j) > k) {
                    visited[i][j] = true;
                }
            }
        }
        return dfs(0,0);
    }
    private int m,n,k;
    public boolean[][] visited;
    public int dfs(int i, int j){
        if( i<0 || j< 0 || i>=m||j>=n ||visited[i][j]) {
            return 0;
        }
        visited[i][j] = true ;
        return 1 +dfs(i+1,j)+dfs(i,j+1)
                +dfs(i-1,j)+dfs(i,j-1);
    }

    public int getSum(int m , int n){
        int sum = 0;
        while(m!=0){
            sum = sum + m%10 ;
            m = m/10;
        }
        while(n!=0){
            sum = sum + n%10 ;
            n = n/10;
        }
        return sum;
    }
}
