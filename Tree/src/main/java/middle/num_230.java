package middle;

import org.junit.Test;

import java.util.Stack;

public class num_230 {

    public int kthSmallest(TreeNode root, int k) {
        int index = 0 ;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root , poll;
        while (p!=null){
            stack.push(p);
            p=p.left;
        }
        while (!stack.isEmpty()){
            index++;
            poll = stack.pop();
            if(index==k) {
                return poll.val;
            }
            p=poll.right;
            if(p!=null){
                while (p!=null){
                    stack.push(p);
                    p=p.left;
                }
            }
        }
        return 0;
    }
    @Test
    public void test(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        t3.left=t1;
        t3.right=t4;
        t1.right=t2;
        kthSmallest(t3,3);
    }
}
