package medium;

import easy.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class num_98 {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long lower, long upper) {
        if(root == null){
            return true;
        }
        if(root.val <= lower || root.val >= upper){
            return false;
        }
        return dfs(root.left,lower,root.val) && dfs(root.right,root.val,upper);
    }
}
