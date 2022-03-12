package middle;

import java.util.ArrayList;
import java.util.List;

public class num_89 {
    int len , n;
    List<Integer> ans = new ArrayList<Integer>(){{add(0);}};
    public List<Integer> grayCode(int n) {
        int head = 1 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = ans.size()-1 ; j >= 0 ; j --){
                ans.add(head + ans.get(j));
            }
            head <<= 1 ;
        }
        return ans ;
    }
}
