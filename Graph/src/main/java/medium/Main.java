package medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt();
//        for (int i = 0; i < T; i ++){
//            int n = scanner.nextInt();
//            UnionFind uf = new UnionFind(2 * (int)(Math.pow(10, 6)));
//            int[][] nums = new int[n][2];
//            for(int j = 0; j < n; j ++){
//                nums[j][0] = scanner.nextInt();
//                nums[j][1] = scanner.nextInt();
//            }
//            for(int j = 0; j < n; j ++){
//                uf.union(nums[j][0], nums[j][1]);
//            }
//            int max = 0;
//            for(int j = 0; j < n; j ++){
//                max = Math.max(max, uf.rank[uf.find(nums[j][0])]);
//            }
//            System.out.println(max);
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i ++){
            int n = scanner.nextInt();
            Deque<String> stack = new LinkedList<>();
            for (int j = 0; j < n; j ++){
                String line = scanner.nextLine();
                if(line.contains("PUSH")){
                    stack.offer(line.substring(5));
                }else if(line.contains("TOP")){
                    if(stack.size() == 0){
                        System.out.println(-1);
                    }else {
                        System.out.println(stack.peekFirst());
                    }
                }else if(line.contains("SIZE")){
                    System.out.println(stack.size());
                }else if(line.contains("POP")){
                    if(stack.size() == 0){
                        System.out.println(-1);
                    }else {
                        stack.poll();
                    }
                }else if(line.contains("CLEAR")){
                    stack.clear();
                }
            }
        }
    }
    public int[] solution(int n){
        int dou = n / 2, olds = n - dou, width = 1, sum;
        boolean old;
        olds --;
        sum = 1;
        old = false;
        while (n - sum > 0){
            boolean last = n - sum <= width * 2;
            width = Math.min(width * 2, n - sum);
            if(last){
                if(old)//最后一行需要奇数
                    return buildOld(n);
                else
                    if(dou < width)
                        return buildDouble(n);
                    else
                        return buildOld(n);
            }else {
                if(old){
                    olds -= width;
                }else {
                    dou -= width;
                }
            }
            sum += width;
            old = !old;
        }
        return null;
    }

    private int[] buildDouble(int n) {
        int[] ans = new int[n];

        return ans;

    }

    private int[] buildOld(int n) {
        int[] ans = new int[n];

        return ans;
    }
    public int min(int[][] nums){
        int m = nums.length, n = nums[0].length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + 1 + (nums[0][i] ^ nums[0][i - 1]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] += 1 + nums[i][j] ^ nums[i - 1][j];
            }
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j], dp[j - 1] + 1 + nums[i][j] ^ nums[i][j - 1]);
            }
            for (int j = n - 1; j >= 0; j--) {
                dp[j] = Math.min(dp[j], dp[j + 1] + 1 + nums[i][j] ^ nums[i][j + 1]);
            }
        }
        return dp[n - 1];
    }
}

class UnionFind{
    int[] f,rank;
    int n;
    public UnionFind(int n){
        this.n = n;
        f = new int[n];
        rank = new int[n];
        Arrays.fill(rank,1);
        for(int i = 0; i < n; i ++){
            f[i] = i;
        }
    }
    public int find(int x){
        return x == f[x] ? x : (f[x] = find(f[x]));
    }
    public boolean connect(int i, int j){
        int fi = find(i), fj = find(j);
        return fi == fj;
    }
    public boolean union(int x, int y){
        int fx = find(x), fy = find(y);
        if(fx == fy){
            return false;
        }
        if(rank[fx] < rank[fy]){
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        rank[fx] += rank[fy];
        f[fy] = fx;
        return true;
    }


}