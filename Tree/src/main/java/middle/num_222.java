package middle;

import org.junit.Test;

public class num_222 {
    //222. 完全二叉树的节点个数
    /*
    * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
    * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
    * 并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
    * */
    int x;
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int h = 0 ;
        TreeNode p = root ;
        while ( p != null ){
            h++ ;
            p = p.left ;
        }
        int l = 1 << ( h - 1 ) , r = (l << 1) - 1  ;
        x = l - 1;
        while (l < r){
            int mid = ((l + r) >> 1) + 1;
            if(exists(mid,root,1 << (h-2))){
                l = mid ;
            }else {
                r = mid - 1 ;
            }
        }
        return l ;
    }

    private boolean exists(int mid, TreeNode root,int len) {
        mid -= x ;
        while (len!=0){
            if(mid>len){
                root = root.right;
                mid -= len;
            }else {
                root = root.left;
            }
            len>>=1;
        }
        return root!=null;
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
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        countNodes(t1);
    }

}
















