package hard;

import java.util.ArrayList;

public class num_52 {
    int cols = 0 ;
    int dia1 = 0 ;
    int dia2 = 0 ;
    int ans = 0 ;
    public int totalNQueens(int n) {
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(0,n,path);
        return ans;
    }
    public void backtrack(int row, int n, ArrayList<Integer> path) {
        if(row == n){
            ans++;
            return;
        }
        for (int i = 0 ; i < n ; i++) {
            int dia1Num = i - row ;
            int dia2Num = i + row ;
            if( (cols & (1 << i)) == 0 && (dia1 & (1 << dia1Num)) == 0 && (dia2 & (1 << dia2Num)) == 0){
                path.add(i);
                cols |= (1 << i);
                dia1 |= (1 << dia1Num);
                dia2 |= (1 << dia2Num);
                backtrack(row + 1 , n ,path );
                path.remove(path.size()-1);
                cols ^= (1 << i);
                dia1 ^= (1 << dia1Num);
                dia2 ^= (1 << dia2Num);
            }
        }
    }
}
