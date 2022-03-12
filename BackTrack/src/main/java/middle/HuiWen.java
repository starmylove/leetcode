package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HuiWen {
    List<String > ans = new ArrayList<>();
    boolean[] visited;
    int len , pathLen;
    char mid = 0 ;
    int old = 0 ;
    char[] chars ,path;
    public List<String> generatePalindromes(String s) {
        if(s.length() ==1){
            List<String > ans = new ArrayList<>();;
            ans.add(s);
            return ans;
        }
        init(s);
        if(old > 1){
            return new ArrayList<>();
        }
        for(int i = 0 ; i < pathLen ; i ++){
            visited[i] = true ;
            path[0] = chars[i];
            if(i > 0 && chars[i-1] == chars[i]){
                visited[i] = false ;
                continue;
            }
            bfs(chars,1,path);
            visited[i] = false ;
        }
        return ans;
    }
    public void bfs(char[] chars , int index , char[] path){
        if(index == pathLen){
            StringBuilder sb = new StringBuilder(),sb1= new StringBuilder();
            if(mid!=0){
                sb.append(mid);
            }
            for(int i = 0 ; i < pathLen;i++){
                sb.append(path[i]);
                sb1.append(path[pathLen-1-i]);
            }
            ans.add(sb1.toString()+sb.toString());
            return;
        }
        for(int i = 0 ; i < pathLen ; i ++){
            if(!visited[i] ){
                if(i > 0 && chars[i-1] == chars[i] && !visited[i-1]){
                    continue;
                }else {
                    visited[i] = true;
                    path[index] = chars[i];
                    bfs(chars,index+1,path);
                    visited[i] = false ;
                }
            }
        }

    }
    public void init(String s){
        len = s.length();
        pathLen = len>>1;
        path = new char[pathLen];
        visited = new boolean[pathLen];
        char[] chs = s.toCharArray() ;
        int[] cnt = new int[26];
        for(char c : chs){
            cnt[c-'a']++;
        }
        for(int i = 0 ; i < 26 ; i ++){
            if((cnt[i]&1) == 1){
                old ++ ;
                mid = (char) ('a' + i);
            }
        }
        if(old > 1 ){
            return;
        }
        chars = new char[pathLen] ;
        int index = 0 ;
        for(int i = 0 ; i < 26 ; i ++){
            if(cnt[i]!=1){
                for(int j = 0 ; j < cnt[i] >> 1; j ++){
                    chars[index++] = (char)(i + 'a');
                }
            }
        }
    }
    @Test
    public void test(){
        System.out.println(generatePalindromes("aabbcc"));
    }
}
