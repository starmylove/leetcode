package easy;

import java.util.TreeMap;

public class num_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode leftTemp = root.left;
        root.left = invertTree(root.right   );
        root.right = invertTree(leftTemp);
        return root;
    }
}
