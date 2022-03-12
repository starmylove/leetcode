package medium;

import easy.TreeNode;

public class num_236 {
    TreeNode ans = null ;
    public TreeNode lwestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans ;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return false ;
        }
        boolean left = dfs(root.left,p,q);
        boolean right = dfs(root.right,p,q);
        if((left && right) || ((root == p || root == q) && (left || right))){
            ans = root ;
        }
        return left || right || root == p || root == q ;
    }

}
