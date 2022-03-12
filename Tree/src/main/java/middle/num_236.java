package middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class num_236 {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        Stack<TreeNode> stack = new Stack<>();
//        int size = 1 ;
//        List<Integer> status = new ArrayList<>();// 1.子节点未访问 2.子节点已访问
//        stack.add(root);
//        status.add(1);
//        int minSize = Integer.MAX_VALUE ,flag=1;
//        while (size!=0){
//            TreeNode peek = stack.peek();
//            if(status.get(size-1)==1){
//                status.set(size-1,2);
//                if(peek.left!=null){
//                    size++;
//                    status.add(1);
//                    stack.push(peek.left);
//                }
//                if(peek.right!=null){
//                    size++;
//                    status.add(1);
//                    stack.push(peek.right);
//                }
//            }else {
//                stack.pop();
//                status.remove(size-1);
//                size--;
//                if(flag==2){
//                    if(peek==q || peek == p){
//                        if(size==minSize-1)return stack.peek();
//                        else {
//                            return stack.elementAt(minSize-2);
//                        }
//                    }
//                    minSize = Math.min(minSize,size);
//                }
//                if(flag==1&&(peek==q || peek == p)){
//                    flag = 2 ;
//                }
//            }
//        }
//        return null;
//    }
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return ans;
    }
    public boolean dfs(TreeNode root , TreeNode p , TreeNode q){
        if(root == null) {
            return false;
        }
        boolean lson = dfs(root.left,p,q);
        boolean rson = dfs(root.right,p,q);
        if((lson&&rson) || ((root == p || root== q) && (lson||rson))) {
            ans = root ;
        }
        return lson || rson || (root == p || root == q);
    }
}

