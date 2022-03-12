package easy;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class Offer_54 {
    public int kthLargest(TreeNode root, int k) {
        LinkedList<Integer> status = new LinkedList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        int curNum = 0 ;
        stack.push(root);
        status.push(0);
        while (curNum < k){
            if(status.peek() == 0){
                status.pop();
                status.push(1);
                if(stack.peek().right!=null){
                    stack.push(stack.peek().right);
                    status.push(0);
                }
            }else {
                curNum++;
                if(curNum == k) {
                    return stack.peek().val;
                }
                TreeNode pop = stack.pop();
                status.pop();
                if(pop.left!=null) {
                    stack.push(pop.left);
                    status.push(0);
                }
            }
        }
        return 0;
    }
    @Test
    public void test(){
        TreeNode t = new TreeNode(1);
        System.out.println(kthLargest(t,1));
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}