package middle;

import java.util.HashSet;
import java.util.Set;

public class num_869 {
    //869. 重新排序得到 2 的幂
    /*
    * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
    * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
    * */
    Set<String> set = new HashSet<>();
    public boolean reorderedPowerOf2(int n) {
        init();
        return set.contains(getString(n));
    }

    private void init() {
        for (int i = 1; i <= 1e9 ; i <<= 1 ) {
            set.add(getString(i));
        }
    }
    public String getString(int n ){
        char[] freq = new char[10];
        while (n != 0){
            freq[n%10]++;
            n/=10;
        }
        return new String(freq);
    }
}

















