package hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int curWordCounts = 0 , curLength = 0 , curStart = 0 ;
        StringBuilder line = new StringBuilder();
        for (int i = 0 ; i < words.length ; i++) {
            if (curWordCounts == 0) {
                curLength += words[i].length() + 1;
                curWordCounts += 1;
            } else {
                if (curLength + words[i].length() > maxWidth) {
                    if(curWordCounts==1){
                        line.append(words[curStart]);
                        appendEmpty(maxWidth,line);
                        curStart = i ;
                        curLength = words[i].length()+1 ;
                        curWordCounts = 1 ;
                        ans.add(line.toString());
                        line.delete( 0, line.length() );
                        continue;
                    }
                    //将start到i-1的单词加入line，将line加入ans，并清空line，重置参数
                    int empty = maxWidth - curLength + curWordCounts;
                    int right = empty / (curWordCounts - 1) , leftCount = empty - right * (curWordCounts-1);
                    for(int j = curStart , c = 1; j < i ; j++,c++){
                        line.append(words[j]);
                        if(j<i-1){
                            for (int k = 0; k < right; k++) {
                                line.append(' ');
                            }
                            if(c<=leftCount) {
                                line.append(' ');
                            }
                        }
                    }
                    curStart = i ;
                    curLength = words[i].length()+1 ;
                    curWordCounts = 1 ;
                    ans.add(line.toString());
                    line.delete( 0, line.length() );
                } else {
                    curLength += words[i].length() + 1;
                    curWordCounts += 1;
                }
            }
        }
        //构造并将最后一行单词加入ans
        for (int i = curStart; i < words.length; i++) {
            line.append(words[i]);
            if(line.length()<maxWidth) {
                line.append(' ');
            }
        }
        appendEmpty(maxWidth,line);
        ans.add(line.toString());
        return ans;
    }
    public void appendEmpty(int maxWidth , StringBuilder line){
        int l = maxWidth - line.length();
        for (int j = 0; j < l; j++) {
            line.append(' ');
        }
    }
    @Test
    public void test(){
        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
        fullJustify(words,16);
    }
}
