package hard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num_30 {
    //30. 串联所有单词的子串
    //滑动窗口解决
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();//存放答案
        int len = words[0].length();//每个单词的长度
        Map<String,Integer> map1 = new HashMap<>();
        for (String word : words){//将words所有单词存入map1并统计出现频率
            int count = map1.getOrDefault(word,0);
            map1.put(word,count+1);
        }
        for (int start = 0; start < len; start++) {//根据单词的长度，将问题分为几种情况，简化分析
            int i = start;//i用于表示当前窗口起点
            Map<String,Integer> map2 = new HashMap<>();//用于存放主串中从i开始到i+(n+1)*len这段字串有哪些单词和map1相同并且统计频率
            int size = 0;//用于记录map2中单词频数总和
            while (i <= s.length()-len*words.length){//控制当前窗口起点位置范围，不能太靠后导致窗口末尾越界
                int n , status = 0 ;//status用于标志错误状态，有1和2两种错误状态，1代表匹配过程中某单词超过最大数量
                                                                            //2代表匹配过程中出现了无法匹配的单词
                for(n = size ; n < words.length ; n ++){//n代表在要判断的新单词在窗口中是第几个单词，下标从0开始
                                                        //控制窗口长度，窗口起点是i
                    String nToNPlusLen = s.substring( i + len*n , i + len*(n+1) );//得到窗口第n个单词（n从0开始，即第一个单词对应n=0）
                    int count =  map2.getOrDefault(nToNPlusLen,0);
                    if(map1.containsKey( nToNPlusLen ) && count<map1.get(nToNPlusLen) ){//如果这个单词可匹配且已匹配次数尚未达到最大值
                        map2.put(nToNPlusLen , count + 1);
                        size++;//窗口单词数量++
                    }else if(map1.containsKey( nToNPlusLen )){//status = 1; 当前窗口中包含第n个单词，但是出现频率已超出最大限制
                        map2.put(nToNPlusLen , count + 1);//仍然给他统计上，放到后面处理
                        size++;
                        status = 1;
                        break;
                    }else {//窗口的第n个单词不在匹配范围之内，跳出循环，放在后面处理
                        status = 2;
                        break;
                    }
                }
                if(status==1){//当前s串中包含第n个单词，但是次数超了
                              //因为第n个单词，以及之前所有单词均在匹配范围之内，只是第n个单词超出最大限制一次，
                                //所以，从窗口起点往后走，一个单词一个单词地判断，找到前面出现的第一个nToNPlusLen，
                                //并将窗口起点移动至该单词后面。窗口的移动以及map的变化均在遍历过程处理
                    while(map1.get(s.substring(i,i+len))>=map2.get(s.substring(i,i+len))){
                        map2.put(s.substring(i,i+len),map2.get(s.substring(i,i+len))-1);
                        size--;
                        i+=len;
                    }
                    map2.put(s.substring(i,i+len),map2.get(s.substring(i,i+len))-1);
                    size--;
                    i+=len;
                }
                else if(status==2){//当前s串不包含第n个单词
                    map2.clear();//清空窗口已匹配单词
                    size = 0 ;
                    i += (n+1)*len;//移动窗口起点至该单词右侧
                }
                //以下两种情况，只可能发生在完整窗口匹配成功后，此时，上面的for循环自然退出，n等于words的单词数量
                else if(i+(n+1)*len<=s.length() //判断窗口右侧是否还有完整的单词
                        && map1.containsKey(s.substring(i+n*len,i+(n+1)*len))){//若有完整的单词，且该单词可匹配
                    ans.add(i);
                    String dul = s.substring(i+n*len,i+(n+1)*len);//获取窗口后面一个单词
                    while (!s.substring(i,i+len).equals(dul)){//找到第一次出现该单词的位置
                        map2.put(s.substring(i,i+len),map2.get(s.substring(i,i+len))-1);
                        size--;
                        i+=len;
                    }
                    map2.put(s.substring(i,i+len),map2.get(s.substring(i,i+len))-1);
                    size--;
                    i+=len;
                }
                else {//若右侧无完整单词或下一个单词不可匹配
                    ans.add(i);
                    map2.clear();
                    size=0;
                    i += (n+1)*len;
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        //测试一下，map的key为char[] 时，是否可以用不同引用值来判断containsKey
        Map<char[],Integer > map = new HashMap<>();
        map.put(new char[]{'a','w'},0);
        char[] chars = new char[]{'a','w'};
        System.out.println(map.containsKey(chars));//false
    }
    @Test
    public void test1(){
        //测试一下，map的equals方法
        Map<String,Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        map1.put("asas",1);
        map2.put("asas",1);
        System.out.println(map1.equals(map2));
    }
    @Test
    public void test3(){
//        List<Integer> barfoothefoobarman = findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
//        List<Integer> barfoothefoobarman = findSubstring("foobarfoobar", new String[]{"foo","bar"});
        List<Integer> barfoothefoobarman = findSubstring("cbaccbcbbc", new String[]{"cb","bc"});
        System.out.println(barfoothefoobarman);
    }
}













