package middle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer_II_113 {
    /*
    * 现在总共有 numCourses 门课需要选，记为 0 到 numCourses-1。
给定一个数组 prerequisites ，它的每一个元素 prerequisites[i] 表示两门课程之间的先修顺序。 例如 prerequisites[i] = [ai, bi] 表示想要学习课程 ai ，需要先完成课程 bi 。
请根据给出的总课程数  numCourses 和表示先修顺序的 prerequisites 得出一个可行的修课序列。
可能会有多个正确的顺序，只要任意返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
    * */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses] ;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i ++){
            list.add(new ArrayList<>());
        }
        int[] ans = new int[numCourses];
        int index = 0 ;
        for(int[] prerequisite : prerequisites){
            inDegree[prerequisite[0]]++;
            list.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i ++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        if(queue.isEmpty()) {
            return new int[0];
        }
        int visited = 0 ;
        while (!queue.isEmpty()){
            visited ++ ;
            int poll = queue.poll();
            ans[index++] = poll ;
            for(int i : list.get(poll)){
                inDegree[i] -- ;
                if(inDegree[i] == 0){
                    queue.offer(i);
                }
                if(inDegree[i] < 0) {
                    return new int[0];
                }
            }
        }
        if(visited==numCourses) {
            return ans;
        }
        return new int[0];
    }
}







