package easy;

public class num_101 {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if((left == null && right != null) || (left != null && right == null)){
            return false ;
        }
        if(left == null && right == null){
            return true;
        }
        if(left.val != right.val){
            return false;
        }
        return dfs(left.left,right.right) && dfs(left.right,right.left);
    }
}
