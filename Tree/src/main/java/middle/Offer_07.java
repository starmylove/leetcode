package middle;

import java.util.HashMap;
import java.util.Map;


public class Offer_07 {
    /*
    * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
    * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    * */
    public static void main(String[] args) {
        int[] pre = new int[]{3,9,8,7,20,15,2,17};
        int[] in = new int[]{8,9,7,3,15,2,20,17};
//        int[] pre = new int[]{3,9,8,7,20,15,2,17};
//        int[] in = new int[]{8,9,7,3,15,2,20,17};
        TreeNode root = buildTree2(pre,in);
        preOrderTraverse1(root);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) {
            return null;
        }
        return buildTree1(preorder,inorder,0,inorder.length-1,0);
    }
    public static TreeNode buildTree1(int[] preorder, int[] inorder,int start , int end,int pre_start){
        int mid = 0;
        for (int i = start; i <=end; i++) {
            if(inorder[i]==preorder[pre_start]) {
                mid = i;
            }
        }
        TreeNode root = new TreeNode(inorder[mid]);
        int ll,lr,rl,rr;
        ll=start;
        lr=mid-1;
        rl=mid+1;
        rr=end;
        int left_length = 0 ;
        if(ll==lr){
            root.left=new TreeNode(inorder[ll]);
            left_length = 1 ;
        }
        else if(ll==mid) {
            root.left=null;
        } else{
            root.left=buildTree1(preorder,inorder,ll,lr,pre_start+1);
            left_length = lr - ll+1;
        }
        if(rl==rr) {
            root.right=new TreeNode(inorder[rl]);
        } else if(rl>rr) {
            root.right = null;
        } else {
            root.right=buildTree1(preorder,inorder,rl,rr,pre_start+1+left_length);
        }
        return root;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public static void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }
    //官方题解

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    //官方题解模仿

    //先定义一个map
    private static Map<Integer,Integer> indexMap = new HashMap<>();

    //定义构建子树的
    public static TreeNode myBuildTree1(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left>preorder_right){
            return null;
        }
        int preorder_root = preorder_left;
        TreeNode root = new TreeNode(preorder[preorder_root]);

        int inorder_root = indexMap.get(preorder[preorder_root]);

        int size_left_subtree = inorder_root-inorder_left;

        root.left = myBuildTree1(preorder,inorder,preorder_root+1,preorder_root+size_left_subtree,inorder_left,inorder_left+size_left_subtree-1);

        root.right = myBuildTree1(preorder,inorder,preorder_root+size_left_subtree,preorder_right,inorder_root+1,inorder_right);
        return root;
    }

    public static TreeNode buildTree2(int[] preorder, int[] inorder){
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree1(preorder,inorder,0,n-1,0,n-1);
    }

}
