package middle;

import org.junit.Test;

public class num_38 {
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        if(n==2) {
            return "11";
        }
        String s = countAndSay(n-1);
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]){
                count++;
            }else {
                sb.append((char) ('0'+count)).append(tmp);
                count=1;
                tmp=arr[i];
            }
        }
        sb.append((char) ('0'+count)).append(tmp);
        return sb.toString();
    }
    @Test
    public void test(){
        String s = countAndSay(10);
        System.out.println(s);
    }
}
















