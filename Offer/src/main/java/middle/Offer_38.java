package middle;

import org.junit.Test;

import java.util.*;

public class Offer_38 {
    //题目：输入一个字符串，打印出该字符串中字符的所有排列。
    //      你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

    //先对将字符串转为char[]，然后进行排序。
    // 递归的同时判断，若该字符与前面一个字符重复，且前面这个字符的visited对应没有被访问过，
    //这就说明该字符已经在当前位置填过，这样就可以避免重复，不必用集合偷懒
    private Set<String> set = new HashSet<>();
    private StringBuilder sb = new StringBuilder();
    private boolean[] visited ;
    private int len;
    public String[] permutation(String s) {
        len = s.length();
        visited = new boolean[len];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(chars,0);
        String[] ans = new String[set.size()];
        int i = 0 ;
        for(String str : set){
            ans[i++] = str;
        }
        return ans;
    }

    private void dfs(char[] str , int k) {
        if(k==len){
            set.add(sb.toString());
            return;
        }
        else {
            for(int i = 0 ; i < len ; i++){
                if(visited[i] || (i > 0 && str[i-1] == str[i] && !visited[i-1])) {
                    continue;
                }
                sb.append(str[i]);
                visited[i] = true;
                dfs(str , k+1);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
        }
    }
    @Test
    public void test(){
        String[] ans = permutation("abca");
        for(String str : ans) {
            System.out.println(str);
        }
    }
}
