package middle;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class num_98 {
    /*
    * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
    * 假设一个二叉搜索树具有如下特征：
            *   节点的左子树只包含小于当前节点的数。
            *   节点的右子树只包含大于当前节点的数。
            *   所有左子树和右子树自身必须也是二叉搜索树。

    * */
    @Test
    public void test(){
        System.out.println(Integer.MIN_VALUE);
    }

    public boolean isValidBST(TreeNode root) {
        //直接中序遍历
        long num  = Long.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(num >= root.val) {
                return false;
            } else {
                num = root.val;
            }
            root = root.right;
        }
        return true;
    }
    //下面的方法错了，在比较root.val与左右子树的val的关系的时候，
    // 只考虑了root的左右子树的根节点的val，而忽略了左子树的最大值、右子树的最小值与root.val的关系
//    private boolean isValidBST(TreeNode root, boolean left ) {
//        if(root==null || (root.left == null && left) || (!left && root.right == null) )
//            return true;
//        if(left ? root.left.val < root.val && isValidBST(root.left , true) && isValidBST(root.left , false)
//                : root.right.val > root.val && isValidBST(root.right , true) && isValidBST(root.right , false) )
//            return true;
//        else
//            return false;
//    }
}
