package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class num_652 {
    List<TreeNode> ans = new ArrayList<>();
    Map<String, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        for(Map.Entry<String, List<TreeNode>> entry : map.entrySet()){
            if(entry.getValue().size() > 1){
                ans.add(entry.getValue().get(0));
            }
        }
        return ans;
    }
    public String dfs(TreeNode root){
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dfs(root.left))
                .append(",")
                .append(dfs(root.right))
                .append(",")
                .append(root.val);
        String res = sb.toString();
        List<TreeNode> nodes = map.getOrDefault(res, new ArrayList<>());
        nodes.add(root);
        map.put(res, nodes);
        return res;
    }
}
