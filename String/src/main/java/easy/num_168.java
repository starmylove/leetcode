package easy;

import org.junit.Test;

public class num_168 {
    /*
    * 本质上是十进制转化为26进制的问题，但excel中列数是从1开始计算的，
    * 要想利用进制转换取余的思想，需要先减1
    * */
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0){
            int res = (columnNumber-1)%26;
            columnNumber -= res;
            sb.insert(0,(char)(65+res));
            columnNumber /= 26;
        }
        return sb.toString();
    }
    public String convertToTitle1(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0){
            columnNumber --;
            sb.insert(0,(char)(65+columnNumber%26));
            columnNumber /= 26;
        }
        return sb.toString();
    }
    @Test
    public void test1(){
        String s = convertToTitle(701);
        System.out.println(s);
    }
    @Test
    public void test2(){
        String haystack = "asasasasas";
        String needle = "abababbbab";
        int n = haystack.length(), m = needle.length();
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0; i < pi.length; i++) {
            System.out.println(pi[i]);
        }
    }

}
