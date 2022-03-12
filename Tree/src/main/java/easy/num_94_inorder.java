package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num_94_inorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while(!stack.empty() || treeNode!=null){

            while(treeNode != null){//treeNode != null说明当前栈顶元素的左子树已经访问完毕
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            treeNode = stack.pop();
            ans.add(treeNode.val);
            treeNode = treeNode.right;
        }
        return ans;
    }

    //简洁写法
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while(root != null || !stk.empty()){

            while(root != null){
                stk.push(root);
                root = root.left;
            }

            root = stk.pop();
            res.add(root.val);
            root = root.right;

        }

        return res;
    }

}
