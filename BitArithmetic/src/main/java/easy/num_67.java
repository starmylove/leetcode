package easy;

import org.junit.Test;

public class num_67 {
    public String addBinary(String a, String b) {
        char[] arra = a.toCharArray() , arrb = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean flag = false ;
        int la = a.length() , lb = b.length();
        if(la<lb){
            char[] tmp = arra ;
            arra= arrb ;
            arrb = tmp ;
            int tmp2 = la ;
            la = lb;
            lb=tmp2;
        }
        for (int i = 0; i < lb; i++) {
            int sum = 0 ;
            if(arra[la-i-1] == '1') {
                sum++;
            }
            if(arrb[lb-i-1] == '1') {
                sum++;
            }
            if(sum==0){
                if(flag){
                    sb.insert(0,'1');
                    flag = false ;
                }else {
                    sb.insert(0,'0');
                }
            }else if(sum == 1){
                if(flag){
                    sb.insert(0,'0');
                }else {
                    sb.insert(0,'1');
                }
            }else if(sum == 2){
                if(flag){
                    sb.insert(0,'1');
                }else {
                    sb.insert(0,'0');
                }
                flag = true;
            }
        }
        int res = la - lb ;
        for (int i = res-1; i >=0; i--) {
            if(arra[i]=='0'){
                if(flag){
                    sb.insert(0,'1');
                    flag = false;
                }else {
                    sb.insert(0,'0');
                }
            }else {
                if(flag){
                    sb.insert(0,'0');
                }else {
                    sb.insert(0,'1');
                }
            }
        }
        if(flag) {
            sb.insert(0,'1');
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String a = "10001111101" , b = "1010111";
        String s = addBinary(a, b);
        System.out.println(s);
    }
}
