package hard;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

public class num_352_TreeMap {
    TreeMap<Integer,Integer> intervals ;
    public num_352_TreeMap() {
        intervals = new TreeMap<>();
    }

    public void addNum(int val) {
        Map.Entry<Integer,Integer> interval1 = intervals.ceilingEntry(val+1);
        Map.Entry<Integer,Integer> interval0 = intervals.floorEntry(val);
        if(interval0!=null && interval0.getKey()<=val && interval0.getValue()>=val) {
            return;
        }
        boolean leftside = interval0 != null && val == interval0.getValue() + 1 ;
        boolean rightside = interval1 != null && val == interval1.getKey() - 1 ;
        if(leftside && rightside){
            int right = interval1.getValue();
            intervals.remove(val+1);
            intervals.put(interval0.getKey(),right);
        }else if(rightside){
            int right = interval1.getValue();
            intervals.remove(val+1);
            intervals.put(val,right);
        }else if(leftside){
            intervals.put(interval0.getKey(),val);
        }else {
            intervals.put(val,val);
        }
    }

    public int[][] getIntervals() {
        int size = intervals.size();
        int[][] ans = new int[size][2];
        int index = 0 ;
        for(Map.Entry<Integer,Integer> entry: intervals.entrySet()){
            ans[index][0] = entry.getKey();
            ans[index][1] = entry.getValue();
            index++;
        }
        return ans;
    }
    @Test
    public void test(){
        num_352_TreeMap test = new num_352_TreeMap();
        test.addNum(1);
        test.addNum(3);
        test.addNum(7);
        test.addNum(2);
        test.addNum(6);

    }
}
