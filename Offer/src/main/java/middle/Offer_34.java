package middle;

import java.util.ArrayList;
import java.util.List;

public class Offer_34 {
    List<List<Integer>> ans ;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        traceBack(root,target,path);
        return ans ;
    }
    public void traceBack(TreeNode root, int target , ArrayList<Integer> path ){
        if(root == null) {
            return;
        }
        path.add(root.val);
        if(root.left == null && root.right ==null ){
            if(target == root.val) {
                ans.add((ArrayList<Integer>) path.clone());
            }
        }
        if(root.left != null) {
            traceBack(root.left,target- root.val,path);
        }
        if(root.right != null) {
            traceBack(root.right,target- root.val,path);
        }
        path.remove(path.size()-1);
    }
}
