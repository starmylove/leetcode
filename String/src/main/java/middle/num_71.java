package middle;

import org.junit.Test;

import java.util.Stack;

public class num_71 {
    //71. 简化路径
    /*
    * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
请注意，返回的 规范路径 必须遵循下述格式：
    始终以斜杠 '/' 开头。
    两个目录名之间必须只有一个斜杠 '/' 。
    最后一个目录名（如果存在）不能 以 '/' 结尾。
    此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
返回简化后得到的 规范路径 。
    * */
    public String simplifyPath(String path) {
        StringBuilder ans = new StringBuilder();
        ans.append('/');
        int n = path.length();
        char[] arr = path.toCharArray();
        for (int i = 1; i < n; i++) {
            if(arr[i]=='.'){
                if(i==n-1) {
                    break;
                }
                if(arr[i+1]=='/'){
                    i++;
                }else if(i+2<n&&arr[i+2]=='/'&&arr[i+1]=='.'){
                    i+=2;
                    if(ans.length()>1){
                        ans.deleteCharAt(ans.length()-1);
                        while (ans.charAt(ans.length()-1)!='/') {
                            ans.deleteCharAt(ans.length()-1);
                        }
                    }
                }else {
                    while (i<n&&arr[i]!='/'){
                        ans.append(arr[i]);
                        i++;
                    }
                    if(i==n) {
                        break;
                    }
                    i--;
                }
            }else if(arr[i]=='/' ){
                if(ans.charAt(ans.length()-1)!='/') {
                    ans.append('/');
                }
            }else {
                ans.append(arr[i]);
            }
        }
        if(ans.charAt(ans.length()-1)=='/'&&ans.length()>1) {
            ans.deleteCharAt(ans.length()-1);
        }
        return ans.toString();
    }
    public String simplifyPath2(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder ret = new StringBuilder();
        for (String p : path.split("/")) {
            if (!stack.empty() && "..".equals(p)) {
                stack.pop();
            } else if (!"..".contains(p)) {
                stack.push(p);
            }
        }
        for (String i : stack) {
            ret.append("/").append(i);
        }
        return ret.length() == 0 ? "/" : ret.toString();
    }
    public String simplifyPath3(String path) {
        char[] stack = new char[path.length()];
        int index = 0;
        int count;
        stack[0] = path.charAt(0);
        index++;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/' && stack[index - 1] == '/') {
            }
            else if (path.charAt(i) == '.') {
                count = 1;
                while (++i < path.length() && path.charAt(i) == '.') {
                    count++;
                }
                i--;
                if (count == 1&& (i + 1 > path.length() - 1 || path.charAt(i + 1) == '/')&& stack[index - 1] == '/') {
                    continue;
                }
                if (count == 2 && (i + 1 > path.length() - 1 || path.charAt(i + 1) == '/')&& stack[index - 1] == '/') {
                    index--;
                    if (index < 1) {
                        index = 1;
                    }
                    while (stack[index - 1] != '/') {
                        index--;
                    }
                } else {
                    while (count > 0) {
                        stack[index] = '.';
                        index++;
                        count--;
                    }
                }
            } else {
                stack[index] = path.charAt(i);
                index++;
            }
        }
        if (index > 1 && (stack[index - 1] == '/')) {
            index--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String s = simplifyPath("/a/./b/../../c/");
        System.out.println(s);
    }
}








