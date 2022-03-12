package hard;

import java.util.ArrayList;
import java.util.List;
public class num_301_3{
    /*
    * 对于(((((())))))))这样的测试用例，我们要删除最后八个）中的两个）
    * 官方解答中，思路是暴力的去挨个试一遍，eg 第1、2个）；第1、3个）；第1、4个）；...第2、3个）；第2、4个）...，
    * 共操作28下此方法，会获取连续的)，删除其中的两个，只需要一下下就可以啦。
    * */
    List<String> ans=new ArrayList<>();
    StringBuilder path=new StringBuilder();
    public List<String> removeInvalidParentheses(String s) {
        ans.clear();
        int lDeleteNum=0;
        int rDeleteNum=0;
    // 统计要删除多少左括号和右括号
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lDeleteNum++;
            } else if (s.charAt(i) == ')') {
                if (lDeleteNum == 0) {
                    rDeleteNum++;
                } else {
                    lDeleteNum--;
                }
            }
        }
        dfs(s.toCharArray(), 0, 0, lDeleteNum, rDeleteNum);
        return ans;
    }
    // cnt表示左括号减去右括号的数量。
    void dfs(char[] s, int index, int lDiffR, int lDeleteNum, int rDeleteNum){
        if (index == s.length){
            // 搜到字符串结尾且左右括号数量相同
            if (lDiffR == 0){
                ans.add(path.toString());
            }
            return;
        }
        // 输入可能包含了除 ( 和 ) 以外的字符。
        if (s[index] != '(' && s[index] != ')') {
            path.append(s[index]);
            dfs(s, index+1, lDiffR, lDeleteNum, rDeleteNum);
            path.deleteCharAt(path.length() - 1);
        }
        else if (s[index] == '('){
            int k = index;
            while (k < s.length && s[k] == '(') {
                k++;
            }
            // 连续有k-u个左括号
            lDeleteNum = lDeleteNum - (k-index);
            // 依次枚举删掉k-u个到0个左括号，
            for (int i = k-index; i >= 0; i--){
                // 如果删掉的左括号数量没超过l的限制
                if (lDeleteNum >= 0) {
                    dfs(s, k, lDiffR, lDeleteNum, rDeleteNum);
                }
                path.append('(');
                lDiffR++;
                lDeleteNum++;
            }
            path.delete(path.length() - (k - index + 1),path.length());
        }
        else if (s[index] == ')') {
            int k = index;
            while (k < s.length&&s[k] == ')') {
                k++;
            }
            rDeleteNum = rDeleteNum - (k-index);
            for (int i = k-index; i >= 0; i--){
            // cnt不小于0是保证左括号不少于右括号
                if (lDiffR >= 0 && rDeleteNum >= 0) {
                    dfs(s, k, lDiffR, lDeleteNum, rDeleteNum);
                }
                path.append(')');
                lDiffR--;
                rDeleteNum++;
            }
            path.delete(path.length() - (k - index + 1), path.length());
        }
    }
}

