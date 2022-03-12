package medium;

import org.junit.Test;

public class num_5 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int max = 0 ;
        int ansL = 0, ansR = 0;
        for(int i = 0 ; i < chars.length ; i ++ ){
            int l = i  , r = i  ;
            while(l - 1 >= 0 && r + 1 < chars.length && chars[l-1] == chars[r+1]){
                l--;
                r++;
            }
            if(r - l + 1 > max ){
                max = r - l + 1 ;
                ansL = l ;
                ansR = r ;
            }
        }
        for(int i = 0 ; i < chars.length - 1; i ++ ){
            if(chars[i] != chars[i+1]){
                continue;
            }else{
                int l = i  , r = i + 1 ;
                while(l - 1 >= 0 && r + 1 < chars.length && chars[l-1] == chars[r+1]){
                    l--;
                    r++;
                }
                if(r - l + 1 > max ){
                    max = r - l + 1 ;
                    ansL = l ;
                    ansR = r ;
                }
            }
        }
        return s.substring(ansL,ansR+1);
    }

    //Manacher算法
    //思想
    //当以i为中心扩展时，可以利用之前的信息
    //假设当前最长臂展为max,对应中心为j，且i在j的臂展右侧范围内，则可以确定，以j为中心，与i对称的那个字符和i字符相等
    //设对称的那个字符下标为x=2*j-i，则可以利用x的对称信息来确定i的对称信息，可以跳过一部分，减少判断次数
    public String longestPalindrome1(String s) {
        int len = s.length() , index = 0;
        char[] chars = new char[2 * len + 1];
        for (int i = 0; i < len; i++) {
            chars[index ++] = '#';
            chars[index ++] = s.charAt(i);
        }
        chars[index] = '#' ;
        int[] cnt = new int[2 * len + 1] ;
        int max = 0 , j = -1 ;
        int ansL = 0, ansR = 0 ;
        for(int i = 0 ; i < chars.length ; i ++ ){
            int pos , min , l = i ,r = i;
            if(j == -1){
                l = i ;
                r = i ;
            }else if(i < j + max){
                pos = 2 * j - i ;
                min = Math.min(j + max - i , cnt[pos]);
                l = i - min ;
                r = i + min ;
            }
            while(l - 1 >= 0 && r + 1 < chars.length && chars[l - 1] == chars[r + 1]){
                l --;
                r ++;
            }
            cnt[i] = r - i ;
            if(r - i > max ){
                j = i ;
                max = r - i ;
                ansL = l ;
                ansR = r ;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = ansL ; i <= ansR ; i ++){
            if(chars[i] != '#'){
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(longestPalindrome1("bacabab"));
    }
}
