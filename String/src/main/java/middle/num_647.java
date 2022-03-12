package middle;

import org.junit.Test;

public class num_647 {
    //n方
    public int countSubstrings(String s) {
        int length = s.length();
        char[] arr = s.toCharArray();
        int ans = length ;
        for (int i = 1; i < length - 1  ; i++) {
            for (int j = 1; i + j < length && i - j >= 0 ; j++) {
                if(arr[i+j]==arr[i-j]) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i <= length - 2 ; i++) {
            if(arr[i]==arr[i+1]){
                ans++;
                for (int j = 1; i + j + 1 < length && i - j >= 0 ; j++) {
                    if(arr[i+j+1]==arr[i-j]) {
                        ans++;
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
    //Manacher 算法，又叫“马拉车”算法，可以在时间复杂度为O(n)的情况下求解一个字符串的最长回文子串长度的问题。
    public int countSubstrings1(String s) {
        int n = s.length();
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');

        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // 初始化 f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // 中心拓展
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // 动态维护 iMax 和 rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] / 2;
        }

        return ans;
    }
    @Test
    public void test(){
        int aaa = countSubstrings("ada");
        System.out.println(aaa);
    }
}
