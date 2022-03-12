package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//90% 90%
public class NQueensBitArithmetic {
    int cols = 0 ;
    int dia1 = 0 ;
    int dia2 = 0 ;
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        ArrayList<Integer> path = new ArrayList<>();
        backtrack(0,n,path);
        return ans;
    }

    public void backtrack(int row, int n, ArrayList<Integer> path) {
        if(row == n){
            ans.add(generateBoard(path,n));
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

    public List<String> generateBoard(ArrayList<Integer> path , int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder("");
            int pos = path.get(i);
            for (int j = 0; j < n; j++) {
                if (j == pos) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
}
