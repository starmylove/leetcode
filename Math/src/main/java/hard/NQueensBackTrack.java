package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueensBackTrack {
    private Set<Integer> cols = new HashSet<>() , dia1 = new HashSet<>() , dia2 = new HashSet<>();
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
            if(  !cols.contains(i) && !dia1.contains(dia1Num) && !dia2.contains(dia2Num)  ){
                path.add(i);
                cols.add(i);
                dia1.add(dia1Num);
                dia2.add(dia2Num);
                backtrack(row + 1 , n ,path );
                path.remove(path.size()-1);
                cols.remove(i);
                dia1.remove(dia1Num);
                dia2.remove(dia2Num);
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
