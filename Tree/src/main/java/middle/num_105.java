package middle;

public class num_105 {
    //105. 从前序与中序遍历序列构造二叉树

    /*
    * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。
    * 请构造二叉树并返回其根节点。
    * */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if(preLeft>preRight) {
            return null;
        }
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        int leftLength = 0 , rightLength = 0 ;
        int inRoot=0;
        for (int i = inLeft; i <= inRight ; i++) {
            if(inorder[i]==rootValue){
                inRoot=i;
                break;
            }
        }
        leftLength = inRoot - inLeft;
        rightLength = preRight - preLeft - leftLength ;
        root.left = buildTree(preorder,inorder,preLeft+1,preLeft+leftLength,inLeft,inLeft+leftLength-1);
        root.right = buildTree(preorder,inorder,preLeft+leftLength+1,preRight,inRoot+1,inRoot+rightLength);
        return root;
    }
}
