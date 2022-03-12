package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class num_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });
        int l = intervals[0][0], r = intervals[0][1] ;
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] > r ){
                list.add(new int[]{l,r});
                l = intervals[i][0];
                r = intervals[i][1];
            }else if(intervals[i][1] > r){
                r = intervals[i][1];
            }
        }
        list.add(new int[]{l,r});
        return  list.toArray(new int[list.size()][]);
    }
}
