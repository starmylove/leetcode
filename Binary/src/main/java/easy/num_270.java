package easy;

public class num_270 {
    public int closestValue(TreeNode root, double target) {
        double min = Integer.MAX_VALUE;
        int ans = 0;
        while (root != null) {
            if(min > Math.abs(target - root.val)){
                min = Math.abs(target - root.val);
                ans = root.val;
            }
            if(target > root.val){
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return ans;
    }
}
class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }