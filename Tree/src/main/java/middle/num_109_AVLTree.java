package middle;

public class num_109_AVLTree {
    /*
    * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
    * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
    * */
    ///第二种方法
    private ListNode globalNode;
    public TreeNode sortedListToBST2(ListNode head) {
        //中序遍历+分治法

        //先求节点数
        int length = 0;
        ListNode temp = head;
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        globalNode = head;
        return buildTree(0,length-1);
    }

    public TreeNode buildTree(int left , int right){//左右均闭
        if(left > right) {
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left,mid-1);
        root.val = globalNode.val;
        globalNode = globalNode.next;
        root.right = buildTree(mid+1,right);
        return root;
    }









    //第一种方法
    public TreeNode sortedListToBST(ListNode head) {
        // 分治
        // 给定head，让right=null，求出mid，做第一次分治，
        // 由于链表节点是单向链表，在找到当前链表mid后，若设置表树范围左闭右开，
        // 左子树可以用left和mid表示，约定表树范围为[left,mid)
        // 右子树用mid.next和right表示，约定表树范围为[mid.next,right)

        return buildTree(head , null);
    }
    TreeNode buildTree(ListNode left, ListNode right) {
        if(left==right) {
            return null;
        }
        ListNode mid = findMid(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left,mid);
        root.right = buildTree(mid.next,right);
        return root;
    }
    //快慢指针法找链表中位数
    public ListNode findMid(ListNode left, ListNode right) {
        ListNode slow = left , fast = left ;
        while (fast!=right && fast!=null){
            if(fast.next==null||fast.next==right) {
                return slow;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


