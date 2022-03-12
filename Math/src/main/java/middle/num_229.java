package middle;

import org.junit.Test;

import java.util.*;

public class num_229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int a = 0 , b = 0 , voteA = 0  , voteB = 0 ;
        for (int x : nums) {
            if(voteA > 0 && x == a ){
                voteA++;
            }else if(voteB > 0 && x == b){
                voteB++;
            }else if(voteA == 0){
                a = x ;
                voteA ++ ;
            }else if(voteB == 0){
                b = x ;
                voteB ++ ;
            }else {
                voteA--;
                voteB--;
            }
        }
        int countA = 0 , countB = 0 ;
        for(int x : nums){
            if(voteA > 0 && x == a){
                countA++;
            }
            if(voteB > 0 && x == b){
                countB++;
            }
        }
        if(voteA > 0 && countA > n/3){
            ans.add(a);
        }
        if(voteB > 0 && countB > n/3){
            ans.add(b);
        }
        return ans ;
    }
    @Test
    public void test(){
        majorityElement(new int[]{3,2,3});
    }
    public List<Integer> majorityElement1(int[] nums) {
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;

        for (int num : nums) {
            if (vote1 > 0 && num == element1) { //如果该元素为第一个元素，则计数加1
                vote1++;
            } else if (vote2 > 0 && num == element2) { //如果该元素为第二个元素，则计数加1
                vote2++;
            } else if (vote1 == 0) { // 选择第一个元素
                element1 = num;
                vote1++;
            } else if (vote2 == 0) { // 选择第二个元素
                element2 = num;
                vote2++;
            } else { //如果三个元素均不相同，则相互抵消1次
                vote1--;
                vote2--;
            }
        }

        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                cnt1++;
            }
            if (vote2 > 0 && num == element2) {
                cnt2++;
            }
        }
        // 检测元素出现的次数是否满足要求
        List<Integer> ans = new ArrayList<>();
        if (vote1 > 0 && cnt1 > nums.length / 3) {
            ans.add(element1);
        }
        if (vote2 > 0 && cnt2 > nums.length / 3) {
            ans.add(element2);
        }
        return ans;
    }

}

