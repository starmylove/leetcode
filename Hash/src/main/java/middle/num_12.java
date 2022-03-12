package middle;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class num_12 {
    //整数转罗马数字
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer,String> map = new HashMap<>();
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
        if(map.containsKey(num%10)) {
            sb.insert(0,map.get(num%10));
        } else{
            for (int i = 0; i < num%5; i++) {
                sb.insert(0,"I");
            }
            if(num%10 >= 5) {
                sb.insert(0,"V");
            }
        }
        num -= num%10;
        if (num<10) {
            return sb.toString();
        }
        if(map.containsKey(num%100)){
            sb.insert(0,map.get(num%100));
        }
        else {
            for (int i = 0; i < num%50; i=i+10) {
                sb.insert(0,"X");
            }
            if(num%100 >= 50) {
                sb.insert(0,"L");
            }
        }
        num -= num%100;
        if (num<100) {
            return sb.toString();
        }
        if(map.containsKey(num%1000)){
            sb.insert(0,map.get(num%1000));
        }
        else {
            for (int i = 0; i < num%500; i=i+100) {
                sb.insert(0,"C");
            }
            if(num%1000 >= 500) {
                sb.insert(0,"D");
            }
        }
        num -= num%1000;
        if (num<1000) {
            return sb.toString();
        }
        for (int i = 0; i < num/1000; i++) {
            sb.insert(0,"M");
        }
        return sb.toString();
    }

    @Test
    public void test(){
        String s = intToRoman(58);
        System.out.println(s);
    }
}
