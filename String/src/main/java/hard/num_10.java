package hard;

import org.junit.Test;

public class num_10 {
    //正则表达式匹配
    /*
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *           '.' 匹配任意单个字符
     *           '*' 匹配零个或多个前面的那一个元素
     *    所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * */
    public boolean isMatch(String s, String p) {
        if(s.length()==0||(p.length()==0&&s.length()==0)) {
            return true;
        }
        if(s.length()>0&&p.length()==0) {
            return false;
        }
        return dfs(s,p,0,0,(char) 0);
    }

    private boolean dfs(String s, String p, int sIndex, int pIndex, char c) {
        if(sIndex==s.length()) {
            return true;
        }
        if(pIndex==p.length()) {
            return false;
        }
        if((pIndex!=p.length()-1)&&p.charAt(pIndex+1)=='*'){//p未到最后一位且该位后面为"*"
            if(p.charAt(pIndex)=='.'){//当前位是"."且下一位是"*"  "oooo.*oooo"
                if(dfs(s,p,sIndex,pIndex+2,(char) 0)) {
                    return true;
                }
                for (int i = sIndex+1; i < s.length() && s.charAt(i) == s.charAt(sIndex+1); i++) {
                    if(dfs(s,p,i,pIndex+1, s.charAt(sIndex+1))) {
                        return true;
                    }
                }
            }else{//当前位不是"."且下一位是"*"  "ooox*ooo"
                if(dfs(s,p,sIndex,pIndex+2,(char) 0)) {
                    return true;
                }
                for (int i = sIndex+1; i < s.length() && s.charAt(i) == s.charAt(sIndex+1); i++) {
                    if(dfs(s,p,i,pIndex+1, s.charAt(sIndex+1))) {
                        return true;
                    }
                }
            }
        }else if((pIndex!=p.length()-1)&&p.charAt(pIndex+1)!='*'){//p未到最后一位且该位后面不为"*"
            if(p.charAt(pIndex)=='.'){//当前位是"."且下一位不是"*"  "oooo.oooo"
                return dfs(s,p,sIndex+1,pIndex+1,(char) 0);
            }else if(p.charAt(pIndex)=='*'){//当前位是"*"  且下一位不是"*"  "oooo*oooo"
                int i;
                for (i = sIndex+1; i < s.length()&&s.charAt(sIndex)==s.charAt(i); i++) {
                    if(dfs(s,p,i,pIndex,c)) {
                        return true;
                    }
                }
                if(dfs(s,p,i,pIndex+1,' ')) {
                    return true;
                }
            }else if(p.charAt(pIndex)!='*'){//当前位不是"*"也不是"."且下一位不是"*"  "oooxoo"
                if(p.charAt(pIndex)!=s.charAt(sIndex) ) {
                    return false;
                }
                return dfs(s,p,sIndex+1,pIndex+1,(char) 0);
            }
        }else{//p已经到最后一位
            if(p.charAt(pIndex)=='.'&&sIndex==s.length()-1) {
                return true;
            } else if(p.charAt(pIndex)=='.'&&sIndex!=s.length()-1) {
                return false;
            }
            if(p.charAt(pIndex)=='*'){
                if(c!=0){
                    int i;
                    for ( i = sIndex; i < s.length(); i++) {
                        if(s.charAt(i)==c) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    if(i==s.length()) {
                        return true;
                    } else {
                        return false;
                    }
                }else {
                    char t = s.charAt(sIndex);
                    int i;
                    for ( i = sIndex; i < s.length(); i++) {
                        if(s.charAt(i)==t) {
                            continue;
                        } else {
                            break;
                        }
                    }
                }
            }
            if(s.charAt(sIndex)!=p.charAt(pIndex)) {
                return false;
            }
            if(sIndex!=s.length()-1) {
                return false;
            }
        }
        return false;
    }
    @Test
    public void test(){
        boolean match = isMatch("aab", "c*a*b");
        System.out.println(match);
    }
}
