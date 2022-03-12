package middle;

import java.util.ArrayList;
import java.util.List;

public class num_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int left = newInterval[0] , right = newInterval[1];
        boolean placed = false;
        for(int[] interval : intervals){
            if(interval[0]>right){
                if(!placed){
                    list.add(new int[]{left,right});
                    placed = true;
                }
                list.add(interval);
            }else if(interval[1]<left){
                list.add(interval);
            }else {
                left = Math.min(left,interval[0]);
                right = Math.max(right,interval[1]);
            }
        }
        if(!placed){
            list.add(new int[]{left,right});
        }
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        return ans;

    }
}
