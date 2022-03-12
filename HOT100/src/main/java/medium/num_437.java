package medium;

import easy.TreeNode;
import org.junit.Test;

import java.util.HashMap;

public class num_437 {
    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum1(root, targetSum);
        ret += pathSum1(root.left, targetSum);
        ret += pathSum1(root.right, targetSum);
        return ret;
    }
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        return rootSum(root,map,0,targetSum);
    }

    private int rootSum(TreeNode root, HashMap<Long, Integer> map, int cur, int targetSum) {
        if(root == null){
            return 0 ;
        }
        int ret = 0 , val = root.val ;
        cur += val ;
        ret += map.getOrDefault((long)(cur - targetSum),0);
        map.put((long)(cur),1+map.getOrDefault((long)cur,0));
        ret += rootSum(root.left,map,cur,targetSum);
        ret += rootSum(root.right,map,cur,targetSum);
        map.put((long)(cur),map.getOrDefault((long)cur,0)-1);
        return ret ;
    }

    public int rootSum1(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum1(root.left, targetSum - val);
        ret += rootSum1(root.right, targetSum - val);
        return ret;
    }
    @Test
    public void test(){
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(-3);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(11);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2 ;
        t1.right = t3 ;
        t2.right = t4 ;
        t3.right = t5 ;
        t4.right = t6 ;
        pathSum1(t1,8);
    }
}
