package medium;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class num_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses] ;
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            inDegrees[pair[0]] ++ ;
            edges.get(pair[1]).add(pair[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegrees[i] == 0){
                queue.add(i) ;
            }
        }
        int visited = 0 ;
        while (!queue.isEmpty()){
            int poll = queue.poll();
            visited ++ ;
            for(int edge : edges.get(poll)){
                if(-- inDegrees[edge] == 0){
                    queue.add(edge);
                }
            }
        }
        return visited == numCourses ;
    }

    public boolean valid = true ;
    public int[] visited ;
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            edges.get(pair[1]).add(pair[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(visited[i] == 0){
                dfs(i,numCourses,edges);
                if(!valid){
                    return false;
                }
            }
        }
        return valid ;
    }

    private void dfs(int i, int numCourses, List<List<Integer>> edges) {
        visited[i] = 1 ;
        for(int edge : edges.get(i)){
            if(visited[edge] == 1){
                valid = false ;
                return;
            }else if( visited[edge] == 0){
                dfs(edge,numCourses,edges);
                if (!valid) {
                    return;
                }
            }
        }
        visited[i] = 2 ;
    }
    @Test
    public void test(){
        canFinish1(2,new int[][]{{0,1},{1,0}});
    }
}















