package middle;

import org.junit.Test;

public class num_114 {
    /*
     *给你二叉树的根结点 root ，请你将它展开为一个单链表：展开后的单链表应该同样使用 TreeNode ，
     * 其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     * */
    public void flatten(TreeNode root) {
        buildTree(root);
    }

    private TreeNode buildTree(TreeNode root) {
        if(root==null) {
            return null;
        }
        TreeNode leftTree = buildTree(root.left) , rightTree = buildTree(root.right) , p=leftTree;
        if(p==null){
            root.right = rightTree;
            return root;
        }
        while (p.right!=null){
            p=p.right;
        }
        p.right=rightTree;
        root.right = leftTree;
        root.left=null;
        return root;
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
        flatten(t1);

    }
}
