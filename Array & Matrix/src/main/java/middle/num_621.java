package middle;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class num_621 {
    //174ms
    public int leastInterval(char[] tasks, int n) {
        if ( n == 0) {
            return tasks.length;
        }
        int[] nums = new int[26];
        int leftNum = tasks.length ;
        for (char task : tasks) {
            nums[task - 'A']++;
        }
        PriorityQueue<int[]> readyQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        }) ,
                blockQueue = new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o2[2]-o1[2];
                    }
                });
        for (int i = 0; i < 26; i++) {
            if(nums[i]!=0){
                readyQueue.offer(new int[]{i,nums[i],0});
            }
        }
        int ans = 0;
        while (leftNum!=0){
            ans++;
            //选一个进程进行执行
            int[] poll = null;
            if(!readyQueue.isEmpty()){
                poll = readyQueue.poll();
                System.out.println((char)(poll[0]+'A'));
                poll[1]--;
                poll[2]=n;
                leftNum--;
            }else {
                System.out.println("待命");
            }
            for(int[] blockingTask : blockQueue){
                if(--blockingTask[2]==0){
                    readyQueue.offer(blockingTask);
                }
            }
            blockQueue.removeIf(blockingTask -> blockingTask[2] == 0);
            if(poll!=null&&poll[1]>0) {
                blockQueue.offer(poll);
            }
        }
        return ans;
    }
    //1ms
    public int leastInterval2(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char ch : tasks) {
            arr[ch- 'A'] ++;
        }
        int len = tasks.length;
        int max = 0;
        int cnt = 0;
        for(int a : arr) {
            if(a > max) {
                max=a;
                cnt = 1;
            } else if(a == max) {
                cnt ++;
            }
        }
        return Math.max( (n+1) * (max-1) + cnt , len);
    }
    @Test
    public void test(){
        int i = leastInterval2(new char[]{'A', 'A',  'B', 'B',  'C', 'C','D','D',
        'E','E','F','F','G','G','H','H','I','I','J','J','K','K'}, 3);
        System.out.println(i);
    }
}











