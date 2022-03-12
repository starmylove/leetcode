package easy;

public class num_104 {
    int max = 0 ;
    public int maxDepth(TreeNode root) {
        dfs(root,1);
        return max ;
    }

    private void dfs(TreeNode root , int depth) {
        if(root == null){
            return;
        }
        max = Math.max(max,depth);
        dfs(root.left,depth + 1);
        dfs(root.right, depth + 1);
    }
}
