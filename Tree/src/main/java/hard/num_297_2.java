package hard;

public class num_297_2 {
    private static final String NULL_NODE_VALUE = "#";
    private static final String SPLIITTER = ",";
    private int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        doSerialize(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void doSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL_NODE_VALUE).append(SPLIITTER);
            return;
        }
        sb.append(root.val).append(SPLIITTER);
        doSerialize(root.left, sb);
        doSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SPLIITTER);
        return doDeserialize(nodes);
    }

    private TreeNode doDeserialize(String[] nodes) {
        if (index >= nodes.length || NULL_NODE_VALUE.equals(nodes[index])) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index]));
        index++;
        node.left = doDeserialize(nodes);
        node.right = doDeserialize(nodes);
        return node;
    }
}
