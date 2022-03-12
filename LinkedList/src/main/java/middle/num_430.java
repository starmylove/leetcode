package middle;

import java.util.Stack;

public class num_430 {
    public Node flatten(Node head) {
        if(head == null ) {
            return null;
        }
        Node point = new Node() , tail = point;
        Node cur = head ;
        Stack<Node> stack = new Stack<>();
        while (true){
            if(cur.child!=null){
                if(cur.next!=null) {
                    stack.push(cur.next);
                }
                tail.next = cur ;
                cur.prev = tail ;
                tail = cur ;
                cur = cur.child;
                tail.child = null ;
            }else if(cur.next!=null){
                tail.next = cur ;
                cur.prev = tail ;
                tail = cur ;
                cur = cur.next  ;
            }else {
                tail.next = cur ;
                cur.prev = tail ;
                tail = cur ;
                if(!stack.isEmpty()) {
                    cur = stack.pop();
                } else {
                    break;
                }
            }
        }
        point.next.prev = null ;
        return point.next;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
