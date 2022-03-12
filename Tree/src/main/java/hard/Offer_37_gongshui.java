package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer_37_gongshui {
    int INF = -2000;
    TreeNode emptyNode = new TreeNode(INF);
    public String serialize(TreeNode root) {
        if(root==null) {
            return " ";
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        deque.addLast(root);
        while (!deque.isEmpty()){
            TreeNode poll = deque.pollFirst();
            sb.append(poll.val+"_");
            if(!poll.equals(emptyNode)){
                deque.addLast(poll.left==null?emptyNode:poll.left);
                deque.addLast(poll.right==null?emptyNode:poll.right);
            }
        }
        return sb.toString();
    }
    public TreeNode deserialize(String data){
        if(" ".equals(data)) {
            return null;
        }
        String[] strs = data.split("_");
        int n = strs.length;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Deque<TreeNode> deque = new ArrayDeque();
        deque.addLast(root);
        for (int i = 1; i < n; i+=2) {
            TreeNode poll = deque.pollFirst();
            int a = Integer.parseInt(strs[i]) , b = Integer.parseInt(strs[i+1]);
            if(a!=INF){

                poll.left = new TreeNode(a);
                deque.addLast(poll.left);
            }
            if(b!=INF){
                poll.right = new TreeNode(b);
                deque.addLast(poll.right);
            }
        }
        return root;
    }
}
