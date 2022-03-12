package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRU_146 {
    int size = 0 ;
    int capacity = 0 ;
    Map<Integer,DLinkedNode > map = new HashMap<Integer,DLinkedNode>();
    DLinkedNode head = new DLinkedNode(-1,0);
    DLinkedNode tail = new DLinkedNode(-2,0);
    public LRU_146(int capacity) {
        this.capacity = capacity ;
        head.next = tail ;
        tail.pre = head ;
    }
    public int get(int key) {
        DLinkedNode node ;
        if((node=map.get(key))==null) {
            return -1;
        }
        //把key节点移动到最前面
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.next = head.next ;
        node.pre = head ;
        head.next = node ;
        node.next.pre = node ;
        return node.value;
    }
    public void put(int key, int value) {
        if(map.get(key)!=null){
            DLinkedNode node=map.get(key);
            node.value = value ;
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.next = head.next ;
            node.pre = head ;
            head.next = node ;
            node.next.pre = node ;
        }else if(size == capacity){
            map.remove(tail.pre.key);
            tail.pre = tail.pre.pre;
            tail.pre.next = tail ;
            DLinkedNode node = new DLinkedNode(key,value);
            map.put(key,node);
            node.next = head.next ;
            node.pre = head ;
            head.next = node ;
            node.next.pre = node ;
        }else {
            size++;
            DLinkedNode node = new DLinkedNode(key,value);
            map.put(key,node);
            node.next = head.next ;
            node.pre = head ;
            head.next = node ;
            node.next.pre = node ;
        }
    }
    class DLinkedNode{
        DLinkedNode pre;
        DLinkedNode next;
        int key ;
        int value ;
        public DLinkedNode() { }
        public DLinkedNode(int _key , int _value){ key = _key ;value = _value ; }
    }
}
