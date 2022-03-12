package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num_13 {
    Map<Character,Integer> map = new HashMap<>();
    public int romanToInt(String s) {
        Set<Integer> set = new HashSet<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int ans = 0 ;
        char[] ss = new char[9];
        System.out.println(ss.length);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int value = map.get(s.charAt(i));
            if(i < n - 1 && value < map.get(s.charAt(i+1))){
                ans-=value;
            }else {
                ans+=value;
            }
        }
        return ans;
    }
}
