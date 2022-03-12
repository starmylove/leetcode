package medium;

import org.junit.Test;

import java.util.*;

public class num_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            StringBuilder sb = new StringBuilder();
            int[] cnt = new int[26];
            for(char c : s.toCharArray()){
                cnt[c-'a'] ++ ;
            }
            for (int i = 0; i < 26; i++) {
                if(cnt[i] > 0){
                    sb.append('a'+i);
                    sb.append(cnt[i]);
                }
            }
            String ss = sb.toString();
            List<String > list= map.getOrDefault(ss,new ArrayList<String >());
            list.add(s);
            map.put(ss,list);
        }
        return new ArrayList<>(map.values());
    }
    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String ss = new String(chars);
            List<String > list= map.getOrDefault(ss,new ArrayList<String >());
            list.add(s);
            map.put(ss,list);
        }
        return new ArrayList<>(map.values());
    }
    @Test
    public void test(){
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
