package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class num_179 {
    public String largestNumber(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.equals(o2)) {
                    return 0;
                }
                if(o1==0) {
                    return 1;
                }
                if(o2==0) {
                    return -1;
                }
                long l1 = 1 , l2 =1 ;
                long oo1=o1,oo2=o2;
                while (o1!=0){
                    l1*=10;
                    o1/=10;
                }
                while (o2!=0){
                    l2*=10;
                    o2/=10;
                }
                long o1o2 = oo1*l2 + oo2;
                long o2o1 = oo2*l1 + oo1;
                return o1o2>o2o1?-1:1;
            }
//            public int compare(Integer o1, Integer o2) {
//                if(o1.equals(o2) )return 0;
//                l1.clear();
//                l2.clear();
//                int temp;
//                boolean rev = false;
//                if(o1<o2){
//                    temp =o2;
//                    o2=o1;
//                    o1=temp;
//                    rev=true;
//                }
//                while (o1!=0){
//                    l1.add(o1%10);
//                    o1 /= 10;
//                }
//                while (o2!=0){
//                    l2.add(o2%10);
//                    o2 /= 10;
//                }
//                int s1 = l1.size() , s2 = l2.size();
//                for (int i = 0; i < s2; i++) {
//                    if(l1.get(s1-1-i)>l2.get(s2-1-i)){
//                        return rev?1:-1;
//                    }
//                    if(l1.get(s1-1-i)<l2.get(s2-1-i)){
//                        return rev?-1:1;
//                    }
//                    if(i == s2 - 1){
//                        int j = i ;
//                        int num =  l2.get(0);
//                        while (s1-1-j>=0){
//                            if(l1.get(s1-1-j)>num){
//                                return rev?1:-1;
//                            }
//                            if(l1.get(s1-1-j)<num){
//                                return rev?-1:1;
//                            }
//                            j++;
//                        }
//                    }
//                }
//                return 0;
//            }
        });
        for (int num : nums) {
            queue.offer(num);
        }
        StringBuilder ans = new StringBuilder("0");
        while (!queue.isEmpty()){
            int poll = queue.poll();
            if(poll==0&&ans.length()==0) {
                return "0";
            }
            ans.append(String.valueOf(poll));
        }
        return ans.toString();
    }
    @Test
    public void test(){
        int[] nums = new int[]{0,9,8,7,6,5,4,3,2,1};
        String s = largestNumber(nums);
        System.out.println(s);
    }
}
