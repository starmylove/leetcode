package hard;

import easy.TreeNode;
import org.junit.Test;

public class num_297 {
    // Encodes a tree to a single string.
    int index = 0 ;
    StringBuilder path = new StringBuilder();
    public String serialize(TreeNode root) {
        encode(root);
        return path.toString();
    }
    public void encode(TreeNode root){
        if(root == null){
            path.append("n,");
        }else {
            path.append(root.val).append(",");
            encode(root.left);
            encode(root.right);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return decode(data);
    }

    private TreeNode decode(String data) {
        if(data.charAt(index) == 'n'){
            index += 2 ;
            return null;
        }else {
            int j = index ;
            while (data.charAt(j) != ','){
                index ++ ;
            }
            TreeNode root = new TreeNode(Integer.parseInt(data.substring(j,index)));
            root.left = decode(data);
            root.right = decode(data);
            return root;
        }
    }
    @Test
    public void test(){
        deserialize("1,2,4,n,n,n,3,5,n,n,6,n,n,n,");
    }
}
