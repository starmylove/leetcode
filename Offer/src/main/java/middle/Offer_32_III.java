package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Offer_32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        boolean leftToRight = true;
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            if (leftToRight) {
                for (int i = 0; i < len; i++) {
                    TreeNode poll = queue.pollFirst();
                    list.add(poll.val);
                    if (poll.left != null) {
                        queue.offerLast(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offerLast(poll.right);
                    }
                }
                leftToRight = false;
            } else {
                for (int i = 0; i < len; i++) {
                    TreeNode poll = queue.pollLast();
                    list.add(poll.val);
                    if (poll.right != null) {
                        queue.offerFirst(poll.right);
                    }
                    if (poll.left != null) {
                        queue.offerFirst(poll.left);
                    }
                }
                leftToRight = true;
            }
            ans.add(list);
        }
        return ans;
    }
    @Test
    public void test(){
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        t3.left = t9 ;
        t3.right = t20;
        t20.left = t15;
        t20.right = t7;
        levelOrder(t3);
    }
}