package middle;

import org.junit.Test;

import java.util.*;

public class LRUCache {
    Map<Integer,Node> cache = new HashMap<Integer, Node>();
    int capacity , size ;
    Node head , tail ;
    public LRUCache(int capacity) {
        size = 0 ;
        head = new Node();
        tail = new Node();
        tail.pre = head ;
        head.next = tail ;
        this.capacity = capacity ;
    }

    public int get(int key) {
        Node node = cache.getOrDefault(key,null) ;
        if(node!=null){
            moveToHead(node);
            return node.v;
        }else {
            return -1 ;
        }
    }

    private void moveToHead(Node node) {
        if(head.next == node){
            return;
        }
        node.next.pre = node.pre ;
        node.pre.next = node.next;
        addToHead(node);
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.get(key).v = value ;
            moveToHead(cache.get(key));
        }else{
            if(size == capacity){
                deleteTail();
            }else {
                size ++ ;
            }
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
        }
    }

//    private void addToTail(Node newNode) {
//        tail.pre.next = newNode ;
//        newNode.pre = tail.pre ;
//        newNode.next = tail;
//        tail.pre = newNode;
//    }

    private void deleteTail() {
        cache.remove(tail.pre.k);
        tail.pre = tail.pre.pre;
        tail.pre.next = tail ;
    }

    public void addToHead(Node node){
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head ;
    }
    class Node{
        int k , v ;
        Node pre , next ;
        Node(){

        }
        Node(int k , int v){
            this.k = k ;
            this.v = v ;
        }
    }

    public static void main(String[] args){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(1, 1); // 缓存是 {1=1, 2=2}
//        lRUCache.get(1);    // 返回 1
        lRUCache.put(2, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 1); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(2);    // 返回 3
//        lRUCache.get(4);    // 返回 4
        Collection collection ;
        Deque deque;
    }
}
