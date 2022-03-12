package trie;

public class Trie {
    Trie[] children ;
    boolean isEnd ;
    public Trie() {
        children = new Trie[26];
        isEnd = false ;
    }
    public void insert(String word) {
        Trie node = this ;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a' ;
            if(node.children[index] == null){
                node.children[index] = new Trie();
            }
            node = node.children[index] ;
        }
        node.isEnd = true ;
    }
    public boolean search(String word) {
        Trie node = this ;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a' ;
            if(node.children[index]==null) {
                return false;
            }
            node = node.children[index];
        }
        if(!node.isEnd) {
            return false;
        }
        return true;
    }
    public boolean startsWith(String prefix) {
        Trie node = this ;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a' ;
            if(node.children[index]==null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}
