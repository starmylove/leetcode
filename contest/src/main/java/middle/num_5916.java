package middle;

import org.junit.Test;

import java.nio.channels.Pipe;
import java.util.*;

public class num_5916 {
    class Node{
        int val ;
        public Node(){

        }
        int length ;
        int op ;
    }
    public int minimumOperations(int[] nums, int start, int goal) {
        if(start == goal) {
            return 0;
        }
        boolean flag = false ;
        for(int x : nums){
            if((x&1)==1){
                flag = true;
                break;
            }
        }
        Map<Integer,Node> map = new HashMap<>();
        Node root = new Node();
        root.val = start ;
        root.length = 0 ;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.length > 30) {
                return -1;
            }
            if(poll.op == 0){
                for (int i = 0; i < nums.length; i++) {
                    int num = poll.val+ nums[i];
                    if(num == goal) {
                        return poll.length + 1;
                    }
                    if(!map.containsKey(num)){
                        Node node = new Node();
                        node.val = num ;
                        node.length = poll.length+1;
                        if(num > 1000 || num < 0){
                            node.op = 1 ;
                        }else {
                            node.op = 0 ;
                        }
                        map.put(num,node);
                        queue.offer(node);
                    }
                }
                for (int i = 0; i < nums.length; i++) {
                    int num = poll.val- nums[i];
                    if(num == goal) {
                        return poll.length + 1;
                    }
                    if(!map.containsKey(num)){
                        Node node = new Node();
                        node.val = num ;
                        node.length = poll.length+1;
                        if(num > 1000 || num < 0){
                            if(!flag && ((goal - num)&1)==0) {
                                continue;
                            }
                            node.op = 2 ;
                        }else {
                            node.op = 0 ;
                        }
                        map.put(num,node);
                        queue.offer(node);
                    }
                }
                for (int i = 0; i < nums.length; i++) {
                    int num = poll.val^ nums[i];
                    if(num == goal) {
                        return poll.length + 1;
                    }
                    if(!map.containsKey(num)){
                        Node node = new Node();
                        node.val = num ;
                        node.length = poll.length+1;
                        if(num > 1000 || num < 0){
                            if(!flag && ((goal - num)&1)==0) {
                                continue;
                            }
                            node.op = 3 ;
                        }else {
                            node.op = 0 ;
                        }
                        map.put(num,node);
                        queue.offer(node);
                    }
                }
            }else if(poll.op == 1){
                for (int i = 0; i < nums.length; i++) {
                    int num = poll.val+ nums[i];
                    if(num == goal) {
                        return poll.length + 1;
                    }
                    if(!map.containsKey(num)){
                        Node node = new Node();
                        node.val = num ;
                        node.length = poll.length+1;
                        node.op = 1 ;
                        map.put(num,node);
                        queue.offer(node);
                    }
                }
            }else if(poll.op == 2){
                for (int i = 0; i < nums.length; i++) {
                    int num = poll.val - nums[i];
                    if(num == goal) {
                        return poll.length + 1;
                    }
                    if(!map.containsKey(num)){
                        Node node = new Node();
                        node.val = num ;
                        node.length = poll.length+1;
                        node.op = 2 ;
                        map.put(num,node);
                        queue.offer(node);
                    }
                }
            }else if(poll.op == 3){
                for (int i = 0; i < nums.length; i++) {
                    int num = poll.val ^ nums[i];
                    if(num == goal) {
                        return poll.length + 1;
                    }
                    if(!map.containsKey(num)){
                        Node node = new Node();
                        node.val = num ;
                        node.length = poll.length+1;
                        node.op = 3 ;
                        map.put(num,node);
                        queue.offer(node);
                    }
                }
            }
        }
        return -1 ;
    }
    @Test
    public void test(){
        minimumOperations(new int[]{2,8,16},0,1);
    }
}

















