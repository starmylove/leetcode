package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num_187 {
    Map<Character, Integer> num = new HashMap<Character, Integer>(){{
        put('A',0);
        put('C',1);
        put('G',2);
        put('T',3);
    }};
    int mask = (1 << 20) - 1;
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        if(s.length() <= 10){
            return ans;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int x = 0;
        for(int i = 0 ; i < 9; i ++){
            x <<= 2;
            x |= num.get(s.charAt(i));
        }
        for (int i = 9; i < s.length(); i ++){
            x = ((x << 2) | num.get(s.charAt(i))) & mask;
            String ss = Integer.toBinaryString(x);
            String sss = Integer.toBinaryString(mask);
            map.put(x, map.getOrDefault(x, 0) + 1);
            if(map.get(x) == 2){
                ans.add(s.substring(i - 9,i + 1));
            }
        }
        return ans;
    }
    @Test
    public void test(){
        findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
