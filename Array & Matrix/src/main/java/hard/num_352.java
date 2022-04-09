package hard;

import java.util.Map;
import java.util.TreeMap;

public class num_352 {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public num_352() {

    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> intervalL = map.floorEntry(val);
        Map.Entry<Integer, Integer> intervalR = map.ceilingEntry(val + 1);
        if(intervalL != null && intervalL.getKey() <= val && intervalL.getValue() >= val) {
        }else {
            boolean leftSide = intervalL != null && intervalL.getValue() + 1 == val;
            boolean rightSide = intervalR != null && intervalR.getKey() - 1 == val;
            if(leftSide && rightSide){
                map.remove(val + 1);
                map.put(intervalL.getKey(), intervalR.getValue());
            }else if (leftSide) {
                map.put(intervalL.getKey(), val);
            }else if (rightSide) {
                map.put(val, intervalR.getValue());
                map.remove(val + 1);
            }else {
                map.put(val, val);
            }
        }
    }

    public int[][] getIntervals() {
        int[][] ans = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[index][0] = entry.getKey();
            ans[index++][1] = entry.getValue();
        }
        return ans;
    }
}
