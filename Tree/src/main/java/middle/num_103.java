package middle;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num_103 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean left_to_right = true ;
        while(!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if(treeNode.left!=null) {
                    queue.offer(treeNode.left);
                }
                if(treeNode.right!=null) {
                    queue.offer(treeNode.right);
                }
            }
            if(left_to_right){
                left_to_right = false;
            }
            else{
                int listsize = list.size();
                for(int i = 0 ; i < listsize/2 ; i ++){
                    swap(list,i,size - 1 - i);
                }
                left_to_right = true;
            }
            res.add(list);
        }
        return res;
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }
}
