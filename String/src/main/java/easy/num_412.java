package easy;

import java.util.ArrayList;
import java.util.List;

public class num_412 {
    public List<String> fizzBuzz(int n) {
        String s1 = "FizzBuzz" , s2 = "Fizz" , s3="Buzz" ;
        List<String> ans = new ArrayList<>();
        for(int i = 1 ; i <= n ; i ++){
            int x = i % 3 , y = i % 5 ;
            if(x == 0 && y == 0){
                ans.add(s1);
                continue;
            }
            if(x==0){
                ans.add(s2);
                continue;
            }
            if(y==0){
                ans.add(s3);
                continue;
            }
            ans.add(String.valueOf(i));
        }
        return ans;
    }
}
