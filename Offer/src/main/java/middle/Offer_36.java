package middle;

import org.junit.Test;

public class Offer_36 {
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        root = dfs1(root);
        Node cur = root ;
        while (cur.right!=null) {
            cur = cur.right;
        }
        cur.right = root;
        root.left = cur ;
        return root;
    }
    public Node dfs1(Node root) {
        if(root == null){
            return null;
        }
        Node left = dfs1(root.left);
        if(left != null){
            Node cur = left ;
            while (cur.right!=null) {
                cur = cur.right;
            }
            cur.right = root ;
            root.left = cur ;
        }else {
            left = root ;
        }
        Node right = dfs1(root.right);
        root.right = right;
        if(right != null) {
            right.left = root ;
        }

        return left;
    }

    //第二种方法
    Node pre,head;

    public Node treeToDoublyList1(Node root) {
        if(root == null) {
            return null;
        }
        dfs(root);
        pre.right = head ;
        head.left = pre ;
        return head;
    }
    public void dfs(Node cur){
        if(cur == null) {
            return;
        }
        dfs(cur.left);
        if(pre == null){
            head = cur;
        }else {
            pre.right = cur;
        }
        cur.left = pre ;
        pre = cur;
        dfs(cur.right);
    }
    @Test
    public void test(){
        Node t1 = new Node(1);
        Node t2 = new Node(2);
        Node t3 = new Node(3);
        Node t4 = new Node(4);
        Node t5 = new Node(5);
        t4.left = t2;
        t4.right=t5;
        t2.left=t1;
        t2.right=t3;
        treeToDoublyList1(t4);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
