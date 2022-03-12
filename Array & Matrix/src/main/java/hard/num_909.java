package hard;

import org.junit.Test;

import java.util.*;

public class num_909 {
    //蛇梯棋


    public int snakesAndLadders(int[][] board) {
        //先将board转化为一维数组，解决编号难的问题
        int len = board.length;
        len *= len;
        int[] nums = new int[len+1] ;
        boolean[] visited = new boolean[len+1];
        int index = 1 ;
        boolean l_to_r = true;
        for (int i = board.length-1; i >= 0; i--) {
            if(l_to_r){
                for (int j = 0; j < board.length; j++) {
                    nums[index++] = board[i][j];
                }
                l_to_r=false;
            }else{
                for (int j = board.length-1; j >=0; j--) {
                    nums[index++] = board[i][j];
                }
                l_to_r = true;
            }
        }
        Deque<int[]> queue =new ArrayDeque<>();
        queue.addLast(new int[]{1,0});
        visited[1]=true;
        int[] pair ;
        while(!queue.isEmpty()){
            pair = queue.pollFirst();
            int pos = pair[0];
            int length = pair[1];
            if(pos==len) {
                return length;
            }
            for (int i = 1; i <7 && i+pos<=len; i++) {
                int np = pos + i ;
                if(nums[np]!=-1) {
                    np = nums[np];
                }
                if(visited[np]) {
                    continue;
                }
                queue.addLast(new int[]{np,length+1});
            }
        }
        return -1;
    }
    public int snakesAndLadders1(int[][] board) {
        //先将board转化为一维数组，解决编号难的问题
        int len = board.length;
        len *= len;
        int[] nums = new int[len+1] ;
        boolean[] visited = new boolean[len+1];
        int index = 1 ;
        boolean l_to_r = true;
        for (int i = board.length-1; i >= 0; i--) {
            if(l_to_r){
                for (int j = 0; j < board.length; j++) {
                    nums[index++] = board[i][j];
                }
                l_to_r=false;
            }else{
                for (int j = board.length-1; j >=0; j--) {
                    nums[index++] = board[i][j];
                }
                l_to_r = true;
            }
        }
        Deque<Integer> queue =new ArrayDeque<>();
        queue.addLast(1);
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,0);
        while(!queue.isEmpty()){
            int poll = queue.pollFirst();
            int step = map.get(poll);
            if(poll==len) {
                return step;
            }
            for (int i = 1; i <= 6 && i+poll<=len; i++) {
                int np = poll+i;
                if(nums[np]!=-1) {
                    np = nums[np];
                }
                if(map.containsKey(np)) {
                    continue;
                }
                ;
                map.put(np,step+1);
                queue.addLast(np);
            }
        }

        return -1;

    }

    @Test
    public void test(){
        int[][] boards = new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
//        int[][] boards = new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,36},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,24,-1,-1}};
//        int[][] boards = new int[][]{{-1,-1},{-1,3}};
//        int[][] boards = new int[][]{{-1,-1,-1},{-1,9,8},{-1,8,9}};
//        int[][] boards = new int[][]{{-1,1,2,-1},{2,13,15,-1},{-1,10,-1,-1},{-1,6,2,8}};
        int i = snakesAndLadders1(boards);
        System.out.println(i);

    }


}

















