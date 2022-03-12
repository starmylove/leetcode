package medium;

import easy.TreeNode;

import java.util.TreeMap;

public class num_114 {
    TreeNode head = new TreeNode() , pre = head ;
    public void flatten(TreeNode root) {
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        pre.right = root ;
        pre = root ;
        TreeNode left = root.left , right = root.right;
        root.left = null ;
        dfs(left);
        dfs(right);
    }
}
