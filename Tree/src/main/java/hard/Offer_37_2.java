package hard;

import org.junit.Test;

import java.util.*;

public class Offer_37_2 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "$,";
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(root.val)+",");
        while (!deque.isEmpty()){
            root = deque.pop();
            if(root.left!=null){
                deque.addLast(root.left);
                sb.append(String.valueOf(root.left.val)+",");
            }
            else {
                sb.append("$,");
            }
            if(root.right!=null){
                deque.addLast(root.right);
                sb.append(String.valueOf(root.right.val)+",");
            }

            else {
                sb.append("$,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("$,".equals(data)) {
            return null;
        }
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        Deque<TreeNode > deque = new LinkedList<>();
        int index = 1 ;
        TreeNode ans = new TreeNode(Integer.parseInt(dataList.get(0)));
        deque.addLast(ans);
        while (!deque.isEmpty()){
            int size = deque.size();
            TreeNode left=null,right=null,root;
            for (int i = 0; i < size; i++) {
                root = deque.pop();
                if(!"$".equals(dataList.get(index))){
                    left = new TreeNode(Integer.parseInt(dataList.get(index)));
                    root.left = left;
                    deque.addLast(left);
                }
                index++;
                if(!"$".equals(dataList.get(index))){
                    right = new TreeNode(Integer.parseInt(dataList.get(index)));
                    root.right=right;
                    deque.addLast(right);
                }
                index++;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        t1.right = t5;
        t5.right =t6;

        //1
        long startTime=System.currentTimeMillis();
        String serialize = serialize(t1);
        long endTime=System.currentTimeMillis();
        System.out.println("程序1运行时间： "+(endTime-startTime)+"ms");
        //2
        startTime=System.currentTimeMillis();
        String[] dataArray = serialize.split(",");
        endTime=System.currentTimeMillis();
        System.out.println("程序2运行时间： "+(endTime-startTime)+"ms");
        //3
        startTime=System.currentTimeMillis();
        List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
        endTime=System.currentTimeMillis();
        System.out.println("程序3运行时间： "+(endTime-startTime)+"ms");
        //4
        startTime=System.currentTimeMillis();
        deserialize(serialize);
        endTime=System.currentTimeMillis();
        System.out.println("程序4运行时间： "+(endTime-startTime)+"ms");
    }
}
