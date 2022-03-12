package hard;

import org.junit.Test;

public class num_60 {
    public String getPermutation(int n, int k) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = i*dp[i-1];
        }
        boolean[] visited = new boolean[n+1];
        StringBuilder sb = new StringBuilder();
        int length = 1 ;
        while (k!=1){
            for (int i = 1; i <= n ; i++) {
                if(visited[i]) {
                    continue;
                }
                while (k>dp[n-length]){
                    i++;
                    while (visited[i]) {
                        i++;
                    }
                    k-=dp[n-length];
                }
                length++;
                sb.append((char)('0'+i));
                visited[i]=true;
                break;
            }
        }
        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                sb.append((char)('0'+i));
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String permutation = getPermutation(4, 10);
        System.out.println(permutation);
    }
}
