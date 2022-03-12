package BFS.hard;

import java.util.*;

public class wordGraph {
    Map<String , Integer> wordId = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0 ;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for(String word : wordList){
            addEdge(word);
        }
        addEdge(beginWord);
        if(!wordId.containsKey(endWord)) {
            return 0;
        }
        int beginId = wordId.get(beginWord) , endId = wordId.get(endWord);
        int[] dis = new int[nodeNum];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[beginId] = 1;
        Queue<Integer> que = new LinkedList<>();
        que.offer(beginId);
        while (!que.isEmpty()){
            int poll = que.poll() , distant = dis[poll];
            if(poll == endId){
                return dis[poll] / 2 + 1 ;
            }
            for(int i : edge.get(poll)){
                if(dis[i] == Integer.MAX_VALUE){
                    dis[i] = distant + 1 ;
                    que.offer(i);
                }
            }
        }
        return 0;
    }

    private void addEdge(String word) {
        addWord(word);
        int n = word.length();
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        for (int i = 0; i < n; i++) {
            char temp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord) ;
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i]=temp;
        }
    }

    private void addWord(String word) {
        if(!wordId.containsKey(word)){
            wordId.put(word,nodeNum++);
            edge.add(new ArrayList<>());
        }
    }
}
