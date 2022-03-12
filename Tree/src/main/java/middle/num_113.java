package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num_113 {
    //113. 路径总和 II
    /*
    * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
    * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
    * 叶子节点 是指没有子节点的节点
    * */
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return ans;
        }
        dfs(root,targetSum,new ArrayList<Integer>());
        return ans ;
    }
    private  void dfs(TreeNode root, int targetSum, ArrayList<Integer> path) {
        path.add(root.val);
        if(root.left == null && root.right == null ){
            if(targetSum == root.val ){
                ans.add(new ArrayList<>(path));
            }
        }
        if(root.left != null){
            dfs(root.left,targetSum - root.val,path);
        }
        if(root.right != null){
            dfs(root.right,targetSum - root.val,path);
        }
        path.remove(path.size() - 1 ) ;
    }
    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        t1.right = t5;
        t5.right =t6;
        pathSum(t1,12);
    }
}













