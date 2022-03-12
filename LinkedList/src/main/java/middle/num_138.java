package middle;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class num_138 {
    public Node copyRandomList(Node head) {
        //用HashMap存储random节点
        Node point = new Node(0) , tail = point;
        Map<Node,Node> map= new HashMap<>();
        while (head!= null){
            Node node ;
            if(map.containsKey(head)) {
                node = map.get(head);
            } else{
                node = new Node(head.val);
                map.put(head,node);
            }
            tail.next = node;
            tail=tail.next;
            if(tail.random==null&&head.random!=null){
                if(map.containsKey(head.random)){
                    tail.random = map.get(head.random);
                }
                else{
                    node = new Node(head.random.val);
                    map.put(head.random,node);
                    tail.random = node;
                }
            }
            head = head.next;
        }
        return point.next;
    }
    @Test
    public void test(){
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        n0.next = n1 ;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        n0.random = null;
        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;
        copyRandomList(n0);
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}