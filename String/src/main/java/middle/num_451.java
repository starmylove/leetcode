package middle;

import org.junit.Test;

import java.util.*;

public class num_451 {
    //451. 根据字符出现频率排序
    //给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
    public String frequencySort(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i),0)+1;
            map.put(s.charAt(i),count);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        //自定义排序方式
        Collections.sort(list,(a,b)-> map.get(b)-map.get(a));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            char c = list.get(i);
            for (int j = 0; j < map.get(c); j++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    //大根堆
    public String frequencySort1(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }
        //首先统计所有字符出现的频率
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i),0)+1;
            map.put(s.charAt(i),count);
        }
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>((a,b)->b.count-a.count);
        for(Character character : map.keySet()) {
            maxHeap.offer(new Node(map.get(character),character));
        }
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()){
            Node node = maxHeap.poll();
            for (int i = 0; i < node.count; i++) {
                sb.append(node.c);
            }
        }
        return sb.toString();
    }

    //桶排序
    //所谓的桶就是一个容器，这个容器里的元素有某个共同之处
    //map的桶就是hashcode
    //对于本题，可以定义，同一个桶内的字符，出现次数相同
    public String frequencySort2(String s) {
        if (s == null || s.length() <= 2) {
            return s;
        }
        int maxFreq = 0 ;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i),0)+1;
            map.put(s.charAt(i),count);
            maxFreq=Math.max(maxFreq,map.get(s.charAt(i)));
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder[] buckets = new StringBuilder[maxFreq+1];
        for (int i = 0; i < maxFreq + 1; i++) {
            buckets[i] = new StringBuilder();
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            buckets[entry.getValue()].append(entry.getKey());
        }
        for (int i = maxFreq; i >= 0; i--) {
            StringBuilder bucket = buckets[i];
            int size = bucket.length();
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();

    }



    @Test
    public void test(){
        String aabb = frequencySort("Aabb");
        System.out.println(aabb);
    }
}
//大根堆用到的节点
class Node{
    public int count;
    public char c;

    public Node(int count, char c) {
        this.count = count;
        this.c = c;
    }
}
