package medium;

import org.junit.Test;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head = new Node() , tail = new Node() ;
    Map<Integer,Node> cache = new HashMap<>();
    int size = 0 , max ;
    class Node{
        Node pre,next ;
        int key,value ;
        public Node(){}
        public Node(int key, int value){
            this.key = key ;
            this.value = value ;
        }
    }

    public LRUCache(int capacity) {
        head.next = tail ;
        tail.pre = head ;
        max = capacity ;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            addFirst(deleteNode(cache.get(key)));
            return cache.get(key).value;
        }else{
            return -1 ;
        }
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).value = value ;
            addFirst(deleteNode(cache.get(key)));
        }else{
            if(size == max){
                cache.remove(tail.pre.key);
                deleteNode(tail.pre);
            }else {
                size ++ ;
            }
            Node newNode = new Node(key,value);
            addFirst(newNode);
            cache.put(key,newNode);
        }

    }
    private Node deleteNode(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre ;
        return node ;
    }

    private void addFirst(Node node){
        node.pre = head ;
        node.next = head.next ;
        head.next = node ;
        node.next.pre = node ;
    }
    public static void main(String[] args){
        LRUCache cache = new LRUCache(2);
        cache.put(1,0);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
