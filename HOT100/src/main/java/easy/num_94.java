package easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class num_94 {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return ans ;
    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.left);
        ans.add(root.val);
        dfs(root.right);
    }
    public List<Integer> inorderTraversal1(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right ;
        }
        return ans ;
    }
}
