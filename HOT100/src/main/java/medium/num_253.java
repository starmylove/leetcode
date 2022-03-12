package medium;

import java.util.*;

public class num_253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1] ;
            }
        });
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        ends.offer(intervals[0][1]);
        int max = 1 ;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][1] , end = intervals[i][1];
            while (!ends.isEmpty() && start > ends.peek()){
                ends.poll();
            }
            ends.offer(end);
            max = Math.max(max,ends.size());
        }
        return max ;
    }
}
