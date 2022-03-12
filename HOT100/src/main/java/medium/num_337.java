package medium;

import easy.TreeNode;
import org.junit.Test;

public class num_337 {
    public int rob(TreeNode root) {
        int[] steal = dfs(root);
        return Math.max(steal[0],steal[1]);
    }

    private int[] dfs(TreeNode root) {
        if(root == null){
            return new int[]{0,0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int selected = root.val + left[1] + right[1];
        int noSelected = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return new int[]{selected,noSelected};
    }
    @Test
    public void test(){
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(1);
        t1.left = t2 ;
        t1.right = t2 ;
        t2.right = t4 ;
        t3.right = t5 ;
        System.out.println(rob(t1));

    }
}
