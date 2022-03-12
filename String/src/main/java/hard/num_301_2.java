package hard;

import java.util.ArrayList;
import java.util.List;

public class num_301_2 {
    private void remove(String s,List<String> res,char opening, char closing,int idx,int lastRemoved){
        int cnt=0;
        while(idx<s.length() && cnt>=0){
            if(s.charAt(idx)==opening)//change by mode
            {
                cnt++;
            } else if(s.charAt(idx)==closing) {
                cnt--;
            }
            idx++;
        }
        if(cnt<0){//find illegal closing and delete it
            for(int j=lastRemoved;j<idx;++j){
                if(s.charAt(j)==closing && (j==0 || s.charAt(j-1)!=closing)){
                    remove(s.substring(0,j)+s.substring(j+1),res,opening,closing,idx-1,j);
                }//delete repeated closing
            }
        }
        else if(cnt>0) {
            remove(new StringBuilder(s).reverse().toString(),res,closing,opening,0,0);//reverse so that check from both size to transform opening deletion to closing deletion
        } else{//balance, add to res
            if(opening == '(') {
                res.add(s);
            } else//check state
            {
                res.add(new StringBuilder(s).reverse().toString());
            }
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        remove(s,res,'(',')',0,0);
        return res;
    }
}
