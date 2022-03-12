package middle;

import org.junit.Test;

public class Offer_26 {
    /*
    * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
    * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
    * */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null) {
            return false;
        }
        if(A==null) {
            return false;
        }
        if(A.val== B.val&&recur(A.left,B.left)&&recur(A.right,B.right)) {
            return true;
        }
        return isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
    public boolean recur(TreeNode A, TreeNode B) {
        if(B==null) {
            return true;
        }
        if(A==null||A.val!= B.val) {
            return false;
        }
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }


    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(0);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(-4);
        TreeNode t5 = new TreeNode(-3);
        TreeNode t6 = new TreeNode(1);
        TreeNode t7 = new TreeNode(-4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t6.left = t7;
        boolean subStructure = isSubStructure(t1, t6);
        System.out.println(subStructure);
    }
}
