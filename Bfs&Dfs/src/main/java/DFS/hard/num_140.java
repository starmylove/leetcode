package DFS.hard;

import org.junit.Test;

import java.util.*;

public class num_140 {
    Set<String> wordDict = new HashSet<>();;
    int maxLen = 0, minLen = Integer.MAX_VALUE;
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict) {
            this.wordDict.add(word);
            maxLen = Math.max(maxLen, word.length());
            minLen = Math.min(minLen, word.length());
        }
        dfs(s, new StringBuilder(), 0);
        return ans;
    }
    public void dfs(String s, StringBuilder path, int start){
        if(start == s.length()) {
            String ss = path.toString();
            ans.add(ss.substring(0, ss.length() - 1));
            return;
        }
        for(int i = minLen; i <= maxLen && start + i <= s.length(); i ++){
            String sub = s.substring(start, start + i);
            if (wordDict.contains(sub)) {
                path.append(sub).append(" ");
                dfs(s, path, start + i);
                path.replace(path.length() - 1 - i, path.length(), "");
            }
        }
    }

    @Test
    public void test(){
        List<String > list = new ArrayList<>();
        list.add("dog");
        list.add("cat");
        list.add("cats");
        list.add("ans");
        list.add("sand");
        wordBreak("catsanddog", list);
    }
}
