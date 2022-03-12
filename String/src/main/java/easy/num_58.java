package easy;

public class num_58 {
    public int lengthOfLastWord(String s) {
        int index = s.length()-1;
        while (index>=0&&s.charAt(index)==' ') {
            index--;
        }
        int ans = 0 ;
        while (index>=0&&s.charAt(index)!=' '){
            index--;
            ans++;
        }
        return ans;
    }
}
