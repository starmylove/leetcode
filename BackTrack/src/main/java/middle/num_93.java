package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num_93 {
    List<String > res  = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s,0,0,new int[4]);
        return res ;
    }

    private void dfs(String s, int index, int n,  int[] ips) {
        if((index == s.length() && n != 4) || (n == 4 && index != s.length())){
            return;
        }
        if(index == s.length()){
            String ip = "" + ips[0] + "." + ips[1] + "." + ips[2] + "." + ips[3];
            res.add(ip);
            return;
        }
        if(s.length() - index < 4 - n){
            return;
        }
        if(s.charAt(index) == '0'){
            ips[n] = 0 ;
            dfs(s,index+1,n+1,ips);
        }else{
            ips[n] = s.charAt(index) - '0';
            dfs(s,index+1,n+1,ips);
            if(index < s.length()-1){
                ips[n] = Integer.parseInt(s.substring(index,index+2));
                dfs(s,index+2,n+1,ips);
            }
            if(index < s.length() - 2 ){
                int ip = Integer.parseInt(s.substring(index,index+3));
                if(256 > ip){
                    ips[n] = ip;
                    dfs(s,index+3,n+1,ips);
                }
            }
        }
    }
    @Test
    public void test(){
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
