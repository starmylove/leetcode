package easy;

import org.junit.Test;

public class num_28 {
    //28. 实现 strStr()
    /*
    * 实现 strStr() 函数。
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
说明：
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
    * */
    public int strStr(String s, String p) {
        int n = s.length(), m = p.length();
        if (m == 0) {
            return 0;
        }
        int[] next = new int[m];
        for (int i = 0 , j = 1; j<m; j++) {
            while (i > 0 && p.charAt(j) != p.charAt(i)) {
                i = next[i-1];
            }
            if(p.charAt(j) == p.charAt(i)) {
                i++;
            }
            next[j] = i ;
        }
        for(int i = 0 , j = 0 ; i < n ; i++){
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j-1];
            }
            if(s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if(j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

}

