package medium;

import org.w3c.dom.Node;

public class Trie {
    class Node{
        Node[] sons = new Node[26];
        boolean end = false ;
    }
    Node[] nodes = new Node[26];
    public Trie() {}

    public void insert(String word) {
        char[] s = word.toCharArray();
        Node[] node = nodes;
        for(int index = 0 ; index < s.length ; index ++){
            if(node[s[index] - 'a'] == null){
                node[s[index] - 'a'] = new Node();
            }
            if(index == word.length() - 1){
                node[s[index] - 'a'].end = true ;
            }
            node = node[s[index] - 'a'].sons ;
        }
    }

    public boolean search(String word) {
        char[] s = word.toCharArray();
        Node[] node = nodes;
        for(int index = 0 ; index < s.length ; index ++){
            if(node == null || node[s[index] - 'a'] == null){
                return false;
            }
            if(index == s.length - 1){
                return node[s[index] - 'a'].end;
            }
            node = node[s[index] - 'a'].sons ;
        }
        return true ;
    }

    public boolean startsWith(String prefix) {
        char[] s = prefix.toCharArray();
        Node[] node = nodes;
        for(int index = 0 ; index < s.length ; index ++){
            if(node == null || node[s[index] - 'a'] == null){
                return false;
            }
            node = node[s[index] - 'a'].sons ;
        }
        return true ;
    }
}
