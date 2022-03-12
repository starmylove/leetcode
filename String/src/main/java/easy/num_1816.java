package easy;

public class num_1816 {
    public String truncateSentence(String s, int k) {
        int index = 0 ,count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == ' '){
                count ++ ;
            }
            if(count == k){
                return s.substring(0,i);
            }
        }
        return s ;
    }
}
