package hard;

import org.junit.Test;

public class num_76 {
    /*
    * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
    * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
    *    注意：
    *        对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
    *       如果 s 中存在这样的子串，我们保证它是唯一的答案。
    * */
    //0-25: a-z  26-51:A-Z

    //33% 33%
    int[] sCounts = new int[52];
    int[] tCounts = new int[52];
    public String minWindow(String s, String t) {

        for (int i = 0; i < t.length(); i++) {
            tCounts[indexByChar(t.charAt(i))]++;
        }

        int start = 0 ;
        while (start<s.length() && tCounts[indexByChar(s.charAt(start))] == 0 ) {
            start ++;
        }
        if(start==s.length() ) {
            return "";
        }
        int l = start , r = start ;
        sCounts[indexByChar(s.charAt(start))]=1;
        int end = s.length() - 1 ;
        while (end >= 0  && tCounts[indexByChar(s.charAt(end))] == 0 ) {
            end --;
        }
        if( end == -1) {
            return "";
        }

        int min = Integer.MAX_VALUE;
        String ans = "";
        while (true ){

            boolean sContainsT = SContainsT();
            if(sContainsT && r-l+1<=t.length()){
                ans = s.substring(l,r+1);
                break;
            }
            if(r >= end && !sContainsT) {
                break;
            }

            if(sContainsT){//当前字串包含t，收缩窗口
                sCounts[indexByChar(s.charAt(l))] -- ;
                l ++ ;
            }else {//当前字串不包含t，扩张窗口
                r ++ ;
                sCounts[indexByChar(s.charAt(r))] ++ ;
            }
            if(SContainsT() && (r-l+1)<min){
                min = r-l+1;
                ans = s.substring(l,r+1);
            }
        }
        return ans;
    }

    public boolean SContainsT(){
        for (int i = 0; i < 52; i++) {
            if(sCounts[i] < tCounts[i]) {
                return false;
            }
        }
        return true;
    }


    public int indexByChar(char c){
        return (c >= 'a' && c <= 'z') ? c - 'a' : 26 + (int)(c - 'A');
    }


    //最快的方法 99% 99%
    public String minWindow1(String s, String t) {
        char[]chars=s.toCharArray(),chart=t.toCharArray();
        int m=chars.length,n=chart.length;
        int[]hash=new int[128];
        for(char ch:chart){
            hash[ch]--;
        }
        String res="";
        for(int i=0,j=0,count=0;i<m;i++){
            hash[chars[i]]++;
            if(hash[chars[i]]<=0){
                count++;
            }
            while(count==n&&hash[chars[j]]>0){
                hash[chars[j++]]--;
            }
            if(count==n){
                if(res==""||res.length()>i-j+1){
                    res=s.substring(j,i+1);
                }
            }
        }
        return res;
    }
    //复现最快的方法 99% 99%
    public String minWindow2(String s, String t) {

        int[]hash = new int[128];

        char[] chars = s.toCharArray() , chart = t.toCharArray();

        int m = chars.length , n = chart.length;

        for(char ch : chart) {
            hash[ch]--;
        }

        String res = "" ;

        for(int i = 0 , j = 0 , count = 0 ; i < m ; i++){

            hash[chars[i]]++;

            if(hash[chars[i]] <= 0) {
                count++;
            }

            while (count==n && hash[chars[j]] > 0){
                hash[chars[j++]]--;
            }

            if(count == n) {
                if(res == "" || res.length() > i-j+1) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }


    @Test
    public void test(){
        String t = "ADOBECODEBANC";
        int[] tCounts = new int[52];
        for (int i = 0; i < t.length(); i++) {
            tCounts[indexByChar(t.charAt(i))]++;
        }
        for (int i = 0; i < 52; i++) {
            System.out.println(tCounts[i]);
        }
    }
    @Test
    public void test1(){
        String t = "ADOBECODEBANC";
        String s = minWindow2("a", "a");
        System.out.println(s);
    }
}
