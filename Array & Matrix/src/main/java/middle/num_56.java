package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class num_56 {
    /*
    * 以数组 intervals 表示若干个区间的集合，
    * 其中单个区间为 intervals[i] = [starti, endi] 。
    * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，
    * 该数组需恰好覆盖输入中的所有区间。
    * */
    //先给intervals所有元素按照区间起点排个序
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0] , R = intervals[i][1];
            if(list.size()==0 || list.get(list.size()-1)[1]<L){
                list.add(new int[]{L,R});
            }else {
                list.get(list.size()-1)[1] = Math.max(R,list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}








