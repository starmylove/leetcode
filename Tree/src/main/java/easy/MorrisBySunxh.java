package easy;

public class MorrisBySunxh {

    public void recoverTree(TreeNode root) {
        TreeNode x = null , y = null , pred = null , predecessor = null ;
        while (root != null){
            if(root.left != null){
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if(predecessor.right == null){
                    predecessor.right = root;
                    root = root.left;
                }
                else {
                    if(pred != null && root.val < pred.val){
                        y = root;
                        if(x == null) {
                            x = pred;
                        }
                    }
                    pred = root;
                    predecessor.right = null; //题目要求不改变树的结构，需要将虚拟连接断掉
                    root = root.right;
                }
            }
            else {
                if(pred != null && root.val < pred.val){
                    y = root;
                    if(x == null) {
                        x = pred;
                    }
                }
                pred = root;
                root = root.right;
            }
        }
        swap(x,y);
    }

    private void swap(TreeNode x, TreeNode y) {
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

}
