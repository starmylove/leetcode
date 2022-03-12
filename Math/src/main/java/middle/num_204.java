package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_204 {
    //204. 计数质数
    //统计所有小于非负整数 n 的质数的数量。

    //方法一：暴力（超时）
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }
        int ans = 1 ;
        for (int i = 3; i < n; i+=2) {
            boolean flag = true ;
            for (int j = 3; j * j < i; j++) {
                if(i % j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans++;
            }
        }
        return ans;
    }
    //方法二：埃氏筛
    public int countPrimes1(int n) {
        int[] isPrime = new int[n];
        int ans = 0 ;
        Arrays.fill(isPrime,1);
        for (int i = 2; i < n; i ++) {
            if(isPrime[i] == 1){
                ans ++ ;
                if((long) i * i < n){
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0 ;
                    }
                }
            }
        }
        return ans ;
    }
    //方法三：线性筛
    public int countPrimes2(int n) {
        List<Integer> primes = new ArrayList<>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime,1);
        for (int i = 2; i < n; i++) {
            if(isPrime[i] == 1){
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                isPrime[i * primes.get(j)] = 0 ;
                if(i % primes.get(j) == 0){
                    break;
                }
            }
        }
        return primes.size();
    }
}




















