package middle;

import java.util.ArrayList;
import java.util.List;

public class num_1222 {
    //1222. 可以攻击国王的皇后
    /*
    * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
    * 黑皇后」在棋盘上的位置分布用整数坐标数组 queens 表示，「白国王」的坐标用数组 king 表示。
    * 「黑皇后」的行棋规定是：横、直、斜都可以走，步数不受限制，但是，不能越子行棋。
    * 请你返回可以直接攻击到「白国王」的所有「黑皇后」的坐标（任意顺序）。
    * */
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] existQueen = new boolean[8][8];
        for (int[] point : queens) {
            existQueen[point[0]][point[1]] = true ;
        }
        List<List<Integer>> res = new ArrayList<>();
        int[][] dirs = new int[][]{{1,0},{1,1},{1,-1},{0,1},{0,-1},{-1,1},{-1,-1},{-1,0}};
        int I = king[0] , J = king[1] ;
        for(int[] dir : dirs){
            int i = I + dir[0] , j = J + dir[1];
            while ( i >= 0 && i < 8 && j >=0 && j < 8 ){
                if(existQueen[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                    break;
                }
                i += dir[0];
                j += dir[1];
            }
        }
        return res;
    }
}
