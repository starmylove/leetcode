package middle;

import org.junit.Test;

public class WordDictionary {
    //211. 添加与搜索单词 - 数据结构设计
    /*
    * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
实现词典类 WordDictionary ：
    WordDictionary() 初始化词典对象
    void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
    bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
    * */
    // 树节点定义
    private class TrieNode {
        TrieNode[] path;
        boolean end; // 是否存在以当前字符结尾的word
        public TrieNode() {
            path = new TrieNode[26]; // word中只含有26个小写字符，所以准备26条路
        }
    }
    private TrieNode root ;
    public WordDictionary() {
        root = new TrieNode();
    }
    public void addWord(String word) {
        int index ;
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            index = word.charAt(i) - 'a';
            if (node.path[index] == null) {
                node.path[index] = new TrieNode();
            }
            node = node.path[index];
        }
        node.end = true ;
    }
    public boolean search(String word) {
        return dfs(word,0,root);
    }
    private boolean dfs(String word, int i, TrieNode root) {
        if(i == word.length() ){
            return root.end;
        }
        char c = word.charAt(i);
        if(Character.isLetter(c)){
            int index = c - 'a';
            TrieNode child = root.path[index];
            if(child!=null){
                return dfs(word,i+1,child);
            }
        }else {
            for (int j = 0; j < 26; j++) {
                TrieNode child = root.path[j];
                if(child!=null && dfs(word,i+1,child)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void test(){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord("a");
//        wordDictionary.addWord("mad");
        wordDictionary.search("."); // return False
        wordDictionary.search("a"); // return True
        wordDictionary.search("aa"); // return True
        wordDictionary.search("a"); // return True
        wordDictionary.search(".a"); // return True
        wordDictionary.search("a."); // return True
    }
    @Test
    public void test1(){
        int ans = 0 ;
        for (int i = 100; i <= 10000; i+=2) {
            ans+=i;
        }
        System.out.println(ans);
    }

}
