package middle;

public class num_279 {
    public int numSquares(int n) {
        int[] dp = new int[101];
        for (int i = 0; i < 101; i++) {
            dp[i] = i * i ;
        }
        int ans = 0 ;
        while (n>=16){
            //在dp里找到第一个比n小的,n -= 那个数 ans+=1
            int l = 1 , r = 100 ;
            while(l < r){
                int mid = l + (r - l)/2;
                if(dp[mid]==n){
                    return ans+1;
                }else if(dp[mid]>n){
                    r=mid;
                }else {
                    l=mid+1;
                }
            }
            n -= dp[l-1];
            ans+=1;
        }
        ans+=getNum(n);
        return ans;
    }
    int getNum (int n){
        if(n<4) {
            return n;
        }
        if(n<7) {
            return n-3;
        }
        if(n<16) {
            return n-8;
        }
        return 0;
    }

    public int numSquares1(int n) {
        int[] f = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i ; j++) {
                minn = Math.min(minn,f[i-j*j]);
            }
            f[i] = minn + 1 ;
        }
        return f[n];
    }
}











