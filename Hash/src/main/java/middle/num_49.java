package middle;

import org.junit.Test;

import java.util.*;

public class num_49 {
    /*
    * 给定一个字符串数组，将字母异位词组合在一起。
    * 可以按任意顺序返回结果列表。字母异位词指字母相同，但排列不同的字符串。
    * */
    //5% 6% 擦
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character,Integer>,List<String>> map = new HashMap<>();
        for (String str : strs){
            Map<Character,Integer> characterMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                int count = characterMap.getOrDefault(str.charAt(i),0);
                characterMap.put(str.charAt(i),count+1);
            }
            if(map.containsKey(characterMap)){
                map.get(characterMap).add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(characterMap,list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<Map<Character,Integer>,List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
    //28% 48%
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String ,List<String>> map = new HashMap<>();
        for (String str : strs){
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i)-'a']= counts[str.charAt(i)-'a']+1;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(counts[i]);
                }
            }
            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(str);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sb.toString(),list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    //80% 55%
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
    @Test
    public void test(){
        String[] strings = new String[]{ "eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams2(strings);
        System.out.println(lists.toString());
    }
}
