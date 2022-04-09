package middle;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class num_11111 {
    public int solution(int n, int v, int[][] nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                }
                return 0;
            }
        });
        int start = Integer.MAX_VALUE, end = 0;
        for (int[] interval : nums) {
            start = Math.min(start, interval[1]);
            end = Math.max(end, interval[2]);
        }
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int index = 0, ans = 0;
        for (int i = start; i <= end; i++) {
            while (!queue.isEmpty() && queue.peek()[2] < i) {
                queue.poll();
            }
            while (index < nums.length && nums[index][1] == i) {
                queue.offer(nums[index]);
                index++;
            }
            int vv = v;
            while (vv > 0 && !queue.isEmpty()) {
                if (queue.peek()[0] <= vv) {
                    ans += queue.peek()[0];
                    vv -= queue.poll()[0];
                } else {
                    queue.peek()[0] -= vv;
                    ans += vv;
                    vv = 0;
                }
            }
        }
        return ans;
    }

    public int solution2(int n, int v, int[][] nums) {
        int ans = 0;
        Arrays.sort(nums, (o1, o2) -> {
            if (o1[2] != o2[2])
                return o1[2] - o2[2];
            else
                return o1[1] - o2[1];
        });
        int start = Integer.MAX_VALUE, end = 0;
        for (int[] interval : nums) {
            start = Math.min(start, interval[1]);
            end = Math.max(end, interval[2]);
        }
        for (int k = start; k <= end; k++) {
            int temp = v;
            for (int m = 0; m < n; m++) {
                if (nums[m][2] < k)
                    continue;
                if (nums[m][1] <= k) {
                    if (nums[m][0] >= temp) {
                        ans += temp;
                        nums[m][0] -= temp;
                        break;
                    } else {
                        ans += nums[m][0];
                        temp -= nums[m][0];
                        nums[m][0] = 0;
                    }
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int solution = solution2(2, 3, new int[][]{{5, 1, 2}, {3, 2, 3}});
        System.out.println(solution);
    }
}
