package BFS.hard;

import java.util.*;

public class num_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        for(String word : wordList){
            addEdge1(word);
        }
        addEdge1(beginWord);
        if(!wordId.containsKey(endWord)){
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 1 ;
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()){
            int poll = que.poll();
            int distant = dis[poll];
            if(poll == endId){
                return dis[poll] / 2 + 1;
            }
            for(int i : edge.get(poll)){
                if(dis[i] == Integer.MAX_VALUE){
                    que.offer(i);
                    dis[i] = distant + 1 ;
                }
            }
        }
        return 0;
    }
    public void addEdge1(String word) {
        addWord1(word);
        int n = word.length();
        char[] array = word.toCharArray();
        int id1 = wordId.get(word);
        for (int i = 0; i < n; i++) {
            char temp = array[i];
            array[i] = '*' ;
            String newWord = new String(array);
            addWord1(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = temp;
        }
    }
    public void addWord1(String word) {
        if(wordId.get(word)==null){
            wordId.put(word,nodeNum++);
            edge.add(new ArrayList<>());
        }
    }
}
