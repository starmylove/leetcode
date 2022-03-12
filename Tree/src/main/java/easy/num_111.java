package easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num_111 {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0 ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1 ;
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if(poll == null ) {
                    continue;
                }
                if(poll.left==null && poll.right==null) {
                    return level;
                }
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
            level++;
        }
        return 0;
    }
}
