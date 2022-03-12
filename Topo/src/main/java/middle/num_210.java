package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num_210 {
    int[] inedge;
    Queue<Integer> queue;
    ArrayList<ArrayList<Integer>> edges;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int index = 0 ;
        if(!canFinish1(numCourses,prerequisites)) {
            return new int[0];
        }
        int[] ans = new int[numCourses];
        for(int[] info : prerequisites){
            inedge[info[0]]++;
        }
        for(int i = 0 ; i < numCourses ; i ++ ) {
            if(inedge[i]==0){
                queue.add(i);
                ans[index++] = i ;
            }
        }
        while (!queue.isEmpty()){
            int poll = queue.poll();
            List<Integer> list= edges.get(poll);
            if(list.size()>0) {
                for(Integer i : list) {
                    if (--inedge[i] == 0) {
                        queue.offer(i);
                        ans[index++] = i;
                    }
                }
            }
        }
        return ans;
    }
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        inedge = new int[numCourses] ;
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        for(int[] info : prerequisites){
            edges.get(info[1]).add(info[0]);
            inedge[info[0]]++;
        }
        int count = prerequisites.length ;
        queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i ++ ) {
            if(inedge[i]==0) {
                queue.add(i);
            }
        }
        if(queue.isEmpty()) {
            return false;
        }
        while (!queue.isEmpty()){
            int poll = queue.poll();
            List<Integer> list= edges.get(poll);
            if(list.size()>0) {
                for(Integer i : list){
                    count--;
                    if(--inedge[i]==0){
                        queue.offer(i);
                    }
                    if(inedge[i]<0) {
                        return false;
                    }
                }
            }
        }
        if(count>0) {
            return false;
        }
        return true;
    }
    @Test
    public void test(){
        int[] order = findOrder(2, new int[][]{{0,1}});
//        int[] order = findOrder(3, new int[][]{{1, 2}, {0, 2}, {2, 0}});
//        int[] order = findOrder(20, new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}});
        System.out.println(order);

    }
}
