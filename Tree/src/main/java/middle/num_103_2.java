package middle;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num_103_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean left_to_right = true ;
        while(!queue.isEmpty()){
            Deque<Integer> list = new LinkedList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if(left_to_right){
                    list.offerLast(treeNode.val);
                }
                else{
                    list.offerFirst(treeNode.val);
                }
                if(treeNode.left!=null) {
                    queue.offer(treeNode.left);
                }
                if(treeNode.right!=null) {
                    queue.offer(treeNode.right);
                }
            }
            if(left_to_right) {
                left_to_right = false;
            } else {
                left_to_right = true;
            }
            res.add(new LinkedList<>(list));
        }
        return res;
    }
}
