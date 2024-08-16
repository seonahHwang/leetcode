package Milla.Trie;

public class PrefixTree {

    PrefixTreeNode root;

    class PrefixTreeNode{
        char value;
        boolean isWord;
        PrefixTreeNode[] children;

        public PrefixTreeNode(char value){
            this.value = value;
            this.isWord = false;
            this.children = new PrefixTreeNode[26];
        }
    }

    public PrefixTree() {
        root = new PrefixTreeNode('\0');
    }

    public static void main(String[] args) {
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("dog");
        prefixTree.search("dog");    // return true
        prefixTree.search("do");     // return false
        prefixTree.startsWith("do"); // return true
        prefixTree.insert("do");
        prefixTree.search("do");
    }

    public void insert(String word) {
        PrefixTreeNode curr = root;
        for(char x : word.toCharArray()){
            if(curr.children[x-'a'] == null) curr.children[x-'a'] = new PrefixTreeNode(x);
            curr = curr.children[x-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        PrefixTreeNode res = getLast(word);
        if(res != null && res.isWord) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        if(getLast(prefix) == null) return false;
        return true;
    }

    public PrefixTreeNode getLast(String word){
        PrefixTreeNode curr = root;
        for (char x : word.toCharArray()){
            if(curr.children[x-'a'] == null) return null;
        }
        return curr;
    }
}
