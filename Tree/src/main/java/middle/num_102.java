package middle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num_102 {
    /*
    * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
    * */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if(treeNode.left!=null) {
                    queue.offer(treeNode.left);
                }
                if(treeNode.right!=null) {
                    queue.offer(treeNode.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
