package hard;

public class num_297_3 {
    StringBuilder path;
    int u = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        path = new StringBuilder();
        dfs_ser(root);
        return path.toString();
    }

    void dfs_ser(TreeNode root){
        if(root == null){
            path.append("#,");
        }else{
            path.append(root.val).append(",");
            dfs_ser(root.left);
            dfs_ser(root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return dfs_des(data);
    }

    TreeNode dfs_des(String data){
        if(data.charAt(u) == '#'){
            u += 2;
            return null;
        }
        int k = u;
        while(data.charAt(k) != ',') {
            k ++ ;
        }
        int val = Integer.parseInt(data.substring(u, k));
        TreeNode root = new TreeNode(val);
        u = k + 1;
        root.left = dfs_des(data);
        root.right = dfs_des(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


