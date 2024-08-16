package Milla.Trie;

import Milla.Repeat.Tree1.TreeNode;

public class WordDictionary {

    WordNode root;

    class WordNode{
        char value;
        boolean isWord;
        WordNode[] children;

        public WordNode(char value){
            this.value = value;
            this.isWord = false;
            this.children = new WordNode[26];
        }
    }
    public WordDictionary() {
        this.root = new WordNode('\0');
    }

    public void addWord(String word) {
        WordNode curr = root;
        for (char x : word.toCharArray()){
            if(curr.children[x-'a'] == null) curr.children[x-'a'] = new WordNode(x);
            curr = curr.children[x-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(root,word,0);
    }

    private boolean dfs(WordNode root, String word, int j){
        WordNode cur = root;
        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.'){
                for(WordNode child : cur.children){
                    if(child != null && dfs(cur,word,i+1)) return true;
                }
                return false;
            }else {
                if(cur.children[c-'a'] == null) return false;
                cur = cur.children[c-'a'];
            }
        }
        return cur.isWord; //마지막인지 확인!
    }
}