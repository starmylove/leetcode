package hard;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class num_297 {
    // Encodes a tree to a single string.
    int INF = -2000;
    TreeNode emptyNode = new TreeNode(INF);
    public String serialize(TreeNode root) {
        if(root==null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            sb.append(poll.val + "_");
            if(!poll.equals(emptyNode)){
                queue.add(poll.left != null ? poll.left : emptyNode);
                queue.add(poll.right != null ? poll.right : emptyNode);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") {
            return null;
        }
        String[] ss = data.split("_");
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1 ;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(!"-2000".equals(ss[index++])){
                poll.left=new TreeNode(Integer.parseInt(ss[index-1]));
                queue.add(poll.left);
            }
            if(!"-2000".equals(ss[index++])){
                poll.right=new TreeNode(Integer.parseInt(ss[index-1]));
                queue.add(poll.right);
            }
        }
        return root;
    }
    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;
        String serialize = serialize(t1);
        deserialize(serialize);
    }
}














