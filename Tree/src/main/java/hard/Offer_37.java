package hard;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Offer_37 {
    //剑指 Offer 37. 序列化二叉树

    private int index = 0 ;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "$,";
        }
        StringBuilder sb = new StringBuilder();
        sb.insert(0,String.valueOf(root.val)+",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));

        return sb.toString();
    }

    public TreeNode Deserialize(String data){
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        return myDeserialize(dataList);
    }
    // Decodes your encoded data to tree.
    public TreeNode myDeserialize( List<String> data ) {
        if("$".equals(data.get(index))){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.get(index)));
        index++;
        root.left = myDeserialize(data);
        root.right = myDeserialize(data);
        return root;
    }
    @Test
    public void test1(){
        StringBuilder sb = new StringBuilder();
        sb.insert(0,"445");
        sb.insert(sb.length(),"69");
        System.out.println(sb);
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
