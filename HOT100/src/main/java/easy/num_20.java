package easy;

import org.junit.Test;

public class num_20 {
    public boolean isValid(String s) {
        int l1 = 0 , l2 = 0, l3 = 0 ;
        for(char c : s.toCharArray()){
            if(c == '('){
                l1 ++ ;
            }else if(c == ')'){
                if(l1 == 0 || l2 > 0 || l3 > 0){
                    return false;
                }
                l1 -- ;
            }else if(c == '{'){
                l2 ++ ;
            }else if(c == '}'){
                if(l2 == 0 || l1 > 0 || l3 > 0){
                    return false;
                }
                l2 -- ;
            }else if(c == '['){
                l3 ++ ;
            }else {
                if(l3 == 0 || l1 > 0 || l2 > 0){
                    return false;
                }
                l3 -- ;
            }
        }
        return l1 == 0 && l2 == 0 && l3 == 0 ;
    }
    @Test
    public void test(){
        isValid("{[]}");
    }
}
