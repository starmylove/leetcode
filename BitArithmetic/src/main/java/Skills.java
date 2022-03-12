import org.junit.Test;

public class Skills {
    //整数做集合
    @Test
    public void testBitSet(){
        //当集合元素均为正整数，且整数范围区间长度小于等于32时，可以用一个整数代替集合
        //该整数的某位置为1，说明对应位置的数字已经在集合中
        int set = 0 ;//空集合

        //判断集合中是否包含元素5
        boolean exist5 = (set & (1 << (5 - 1))) == 0 ? false : true ;//减几就代表可表示区间与[0,32]的漂移距离,这里减1，表示该集合可装载[1,33]的整数
        System.out.println(exist5);//false
        System.out.println(Integer.toBinaryString(set));//0

        //向集合中添加元素 5
        set ^= (1 << (5-1));//集合{5}

        //再次做判断
        exist5 = (set & (1 << (5 - 1))) == 0 ? false : true ;
        System.out.println(exist5);//true
        System.out.println(Integer.toBinaryString(set));//10000,

        //删除元素5
        set ^= (1 << (5-1));//与添加操作一样，异或一次

        //判断集合中是否包含元素5
        exist5 = (set & (1 << (5 - 1))) == 0 ? false : true ;//减几就代表可表示区间与[0,32]的漂移距离,这里减1，表示该集合可装载[1,33]的整数
        System.out.println(exist5);//false
        System.out.println(Integer.toBinaryString(set));//0

        //再添加几个元素玩玩
        set ^= (1 << (5-1));//集合{5}
        set ^= (1 << (1-1));//集合{1,5}
        set ^= (1 << (9-1));//集合{1,5,9}
        set ^= (1 << (6-1));//集合{1,5,6,9}
        set ^= (1 << (30-1));//集合{1,5,6,9,30}
        System.out.println(Integer.toBinaryString(set));//100000000000000000000100110001
    }

    // a & ( a - 1 )
    @Test
    public void test1(){
        //该操作可以将a二进制串中最右边的1置0 , 可以配合BitSet 达到快速遍历集合的效果
        int a = 856 ;
        int b = a - 1 ;
        int res = a & b ;

        System.out.println("a的二进制数"+Integer.toBinaryString(a));
        System.out.println("b的二进制数"+Integer.toBinaryString(b));
        System.out.println("a & ( a - 1 )的二进制数"+Integer.toBinaryString(res));



    }

    // a 与 -a  相反数之间的奇妙转化  //  ~(a-1)=-a   ~(-a) = a - 1
    @Test
    public void testOppositeNumber(){
        int a = 440 ;
        int b = a - 1 ;
        int c = ~ b ;
        int res = a & c ;
        System.out.println("a的二进制串"+Integer.toBinaryString(a));//                                   11011 1000 a
        System.out.println("a - 1 的二进制串: "+Integer.toBinaryString(b));//                            11011 0111 a-1
        System.out.println("~ ( a - 1 ) 的二进制串"+Integer.toBinaryString(c));// 1111111111111111111111100100 1000 ~(a-1)=-a
        System.out.println("a & (-a) 的二进制串"+Integer.toBinaryString(res));//                               1000 a & (-a)
        //解释：
        //  a 与 a-1 的二进制串的区别在于：
        //      a最后一位1以及该位置后面的所有0 (100**000)，在 a-1 中变为一个0和若干个1 ( 0111***111)
        //      ~(a-1) = -a , 此时, a-1中最后一个0以及该位置后面的所有1与a恰好相反，~操作以后与a相同，而前面的所有位反而与a相反
        //      如此一来，a & (-a) 时，能保留下来的必然是a中最后一个1以及该位后面的所有0
        //总结： a & (-a) 的结果是a二进制串中最右边的1
        //思考，res = a & (-a) 如何知道res中的这个1到底在右数第几位？
        //  答案：用 API Integer.bitCount(res - 1) 统计res-1中有多少1，那么res中1的位数就可以计算得到。
    }
}