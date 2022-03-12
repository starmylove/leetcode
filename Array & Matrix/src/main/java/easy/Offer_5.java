package easy;

public class Offer_5 {
    public static void main(String[] args) {
        String s = "We are happy.";
        s=replaceSpace2(s);
        System.out.println(s);
    }

    public static String replaceSpace(String s) {
        if(s==""){
            return s;
        }
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            if(' '==sb.charAt(i)){
                sb.replace(i,i+1,"%20");
                i+=2;
            }
        }
        return sb.toString();
    }

    //另一种方法
    public static String replaceSpace1(String s) {
        if(s==""){
            return s;
        }
        int num = 0 ;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' ') {
                num++;
            }
        }
        char[] ans = new char[s.length()+2*num];
        int j = s.length()+2*num-1;
        char c = ' ';
        for (int i = s.length()-1; i >=0 ; i--) {
            if((c=s.charAt(i))!=' ') {
                ans[j--]=c;
            } else{
                ans[j--]='0';
                ans[j--]='2';
                ans[j--]='%';
            }
        }
        return new String(ans);
    }
    public static String replaceSpace2(String s) {
        if(s==""){
            return s;
        }
        int num = 0 ;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' ') {
                num++;
            }
        }
        char[] ans = new char[s.length()+2*num];
        int j = 0;
        char c = ' ';
        for (int i = 0; i < s.length();  i++) {
            if((c=s.charAt(i))!=' ') {
                ans[j++]=c;
            } else{
                ans[j++]='%';
                ans[j++]='2';
                ans[j++]='0';
            }
        }
        return new String(ans);
    }
}
