package easy;

import org.junit.Test;

public class num_405 {
    //405. 数字转换为十六进制数
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder() ;
        for (int i = 7; i >=0 ; i--) {
            int c = (num >> 4*i) & 0xf;
            if(sb.length()>0||c>0) {
                sb.append((0<=c&&10>c)?(char)(c+'0'):(char)('a'+(c-10)));
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        String s = toHex(26);
        System.out.println(s);
    }
}
