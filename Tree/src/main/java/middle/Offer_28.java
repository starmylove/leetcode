package middle;

public class Offer_28 {
    /*
    * 请实现一个函数，用来判断一棵二叉树是不是对称的。
    * 如果一棵二叉树和它的镜像一样，那么它是对称的。
    * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    * */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return recur(root.left,root.right);
    }

    public boolean recur(TreeNode left, TreeNode right) {
        if(left==null&&right==null) {
            return true;
        }
        if((left==null&&right!=null)||(left!=null&&right==null)||left.val!=right.val) {
            return false;
        }
        return recur(left.left,right.right)&&recur(left.right,right.left);
    }

    private boolean recur(TreeNode root) {
        if(root.left==null&&root.right==null) {
            return true;
        }
        if(root.left!=null&&root.left!=null&&recur(root.left)&&recur((root.right))) {
            return true;
        }
        return false;
    }
}
