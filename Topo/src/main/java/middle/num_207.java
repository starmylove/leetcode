package middle;

import org.junit.Test;

import java.util.*;

public class num_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inedge = new int[numCourses];
        int count = prerequisites.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (prerequisites[i][0] == prerequisites[i][1]) {
                return false;
            }
            Set<Integer> s = map.get(prerequisites[i][1]);
            if (s != null && s.contains(prerequisites[i][0])) {
                return false;
            }
            inedge[prerequisites[i][1]]++;
            Set<Integer> set = map.getOrDefault(prerequisites[i][0], new HashSet<>());
            set.add(prerequisites[i][1]);
            map.put(prerequisites[i][0], set);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < numCourses; i++) {
            if (inedge[i] == 0) {
                queue.offer(i);
            }
        }
        if (queue.isEmpty()) {
            return false;
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            Set<Integer> set = map.get(poll);
            if (set != null) {
                for (Integer i : set) {
                    count--;
                    if (--inedge[i] == 0) {
                        queue.offer(i);
                    }
                    if (inedge[i] < 0) {
                        return false;
                    }
                }
            }
        }
        if (count > 0) {
            return false;
        }
        return true;
    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        int[] inedge = new int[numCourses];
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            inedge[info[0]]++;
        }
        int count = prerequisites.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inedge[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.isEmpty()) {
            return false;
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            List<Integer> list = edges.get(poll);
            if (list.size() > 0) {
                for (Integer i : list) {
                    count--;
                    if (--inedge[i] == 0) {
                        queue.offer(i);
                    }
                    if (inedge[i] < 0) {
                        return false;
                    }
                }
            }
        }
        return count <= 0;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {

        int[] intDegree = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int[] prerequisite : prerequisites) {
            intDegree[prerequisite[0]] += 1;
            list.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (intDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        if (queue.size() == 0) {
            return false;
        }
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            visited++;
            for (Integer i : list.get(poll)) {
                if (--intDegree[i] == 0) {
                    queue.offer(i);
                }
                if (intDegree[i] < 0) {
                    return false;
                }
            }
        }
        return visited == numCourses;
    }

    @Test
    public void test() {
//        boolean b = canFinish(2, new int[][]{{1, 0},{0,1}});
//        boolean b = canFinish(3, new int[][]{{1, 2},{0,2},{2,0}});
//        boolean b = canFinish2(20, new int[][]{{5,5}});
        boolean b = canFinish2(20, new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}});
        System.out.println(b);

    }

    //2021.12.04
    public boolean canFinish3(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i ++){
            list.add(new ArrayList<Integer>());
        }
        for(int[] prerequisite : prerequisites){
            inDegree[prerequisite[0]] ++ ;
            list.get(prerequisite[1]).add(prerequisite[0] );
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i ++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        if(queue.isEmpty()) {
            return false;
        }
        int visited = 0 ;
        while (!queue.isEmpty()){
            int poll = queue.poll();
            visited ++ ;
            for(int i : list.get(poll)){
                inDegree[i]--;
                if(inDegree[i] == 0) {
                    queue.offer(i);
                }
                if(inDegree[i]<0) {
                    return false;
                }
            }
        }
        return visited == numCourses;
    }

}












