package easy;

public class num_108 {
    /*
    * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
    * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
    * */

    public TreeNode sortedArrayToBST(int[] nums) {
        return searchTree(nums,0,nums.length-1,(nums.length-1)/2);
    }

    public TreeNode searchTree(int[] nums , int left , int right , int mid){
        if(right<left) {
            return null;
        }

        if(left==right){
            return new TreeNode(nums[mid]);
        }

        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = searchTree(nums,left,mid-1,(left+mid-1)/2);
        treeNode.right = searchTree(nums,mid+1,right,(mid+1+right)/2);
        return treeNode;
    }

}


