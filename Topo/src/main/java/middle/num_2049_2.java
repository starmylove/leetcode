package middle;

import org.junit.Test;

import java.util.*;

public class num_2049_2 {
    int cnt = 0, n;
    List<Integer>[] children;
    long maxScore = 0;
    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parents[i]].add(i);
        }
        dfs(0);
        return cnt;
    }
    public int dfs(int node){
        long score = 1;
        int size = n - 1;
        for(int child : children[node]){
            int t = dfs(child);
            score *= t;
            size -= t;
        }
        if(node != 0){
            score *= size;
        }
        if(score == maxScore){
            cnt ++;
        }else if(score > maxScore){
            maxScore = score;
            cnt = 1;
        }
        return n - size;
    }

    //给二熊帮忙做微软笔试题
    public int minimum(int[] a){
        int n = a.length;
        Set<Integer> set = new HashSet<>();
        for (int i : a){
            set.add(i);
        }
        int len = set.size(), index = 0;
        int[] cnt = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : set){
            map.put(i, index);
            index ++;
        }
        int l = 0, r, sum = 0;
        int L = -1 ,R = -1, min = Integer.MAX_VALUE;
        for(r = 0 ; r < n ; r ++){
            //更新当前窗口location计数器
            cnt[map.get(a[r])]++;
            //加入了稀缺元素
            if(cnt[map.get(a[r])] <= 1){
                sum ++ ;
                while(sum == len){
                    if(r - l + 1 < min){
                        //更新答案
                        min = r - l + 1 ;
                        L = l ;
                        R = r;
                    }
                    //如果左移导致当前窗口不再能够覆盖所有location，则更新
                    if(--cnt[map.get(a[l])] < 1){
                        sum -- ;
                    }
                    //窗口左移
                    l ++ ;
                }
            }
        }
        return R - L + 1;
    }
    @Test
    public void test(){
        int minimum = minimum(new int[]{7,3,7,3,1,3,4,1});

//        int solution = solution(new String[]{"...X.", ".X..X", "X...X","..X.."});
//        System.out.println(solution);
    }

//    boolean[][] obs, visited;
//    int ans = 0;
//    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
//    int[][] dirRecord;
//    int m, n;
//    public int solution(String[] strs){
//        if(strs[0].charAt(0) == 'X'){
//            return 0;
//        }
//        m = strs.length;
//        n = strs[0].length();
//        boolean[][] obs = new boolean[m][n];
//        dirRecord = new int[m][n];
//        visited = new boolean[m][n];
//        this.obs = obs;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(strs[i].charAt(j) == 'X'){
//                    obs[i][j] = true;
//                }
//            }
//        }
//        d(0,0,0);
//        return ans;
//    }
//
//
//
//    private void d(int i, int j, int dirIndex) {
//        int[] dir = dirs[dirIndex];
//        if(!visited[i][j]){
//            ans ++;
//            dirRecord[i][j] = dirIndex;
//        }
//        visited[i][j] = true;
//        for (int k = 0; k < 4; k++) {
//            dir = dirs[dirIndex];
//            int nextI = i + dir[0], nextJ = j + dir[1];
//            if(isValid(i + dir[0], j + dir[1])){
//                if(visited[nextI][nextJ] && dirRecord[nextI][nextJ] == dirIndex){
//                    return;
//                }
//                d(nextI, nextJ, dirIndex);
//                return;
//            }
//            dirIndex = ( dirIndex + 1) % 4;
//        }
//
////        if(isValid(i + dir[0],j + dir[1])){
////            d(i + dir[0], j + dir[1], dirIndex);
////        }else{
////            dirIndex = (dirIndex + 1) % 4;
////            dir = dirs[dirIndex];
////            if(isValid(i + dir[0],j + dir[1])){
////                d(i + dir[0],j + dir[1], dirIndex);
////            }
////        }
//    }
//
//
//    public boolean isValid(int i, int j){
//        if(i < 0 || i == m || j < 0 || j == n){
//            return false;
//        }
//        return !obs[i][j];
//    }
}