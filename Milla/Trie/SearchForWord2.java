package Milla.Trie;

import Milla.Repeat.Tree1.TreeNode;

import java.util.*;

public class SearchForWord2 {
    class TrieNode{
        Map<Character,TrieNode> children = new HashMap<>();
        boolean isWord;
        int refs;

        public void addWord(String word){
            TrieNode cur = this;
            cur.refs++;
            for (char c : word.toCharArray()){
                cur.children.putIfAbsent(c, new TrieNode());
                cur = cur.children.get(c);
                cur.refs++;
            }
            cur.isWord = true;
        }

        public void removeWord(String word){
            TrieNode cur = this;
            cur.refs--;
            for (char c : word.toCharArray()){
                if(cur.children.containsKey(c)){
                    cur = cur.children.get(c);
                    cur.refs--;
                }
            }
        }
    }

    int ROWS;
    int COLS;

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> visit = new HashSet<>();
        Set<String> res = new HashSet<>();
        TrieNode root = new TrieNode();

        ROWS = board.length;
        COLS = board[0].length;

        for (String w : words){
            root.addWord(w);
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(r,c,"",root,root,board,res,visit);
            }
        }
        return new ArrayList<>(res);
    }

    public void dfs(int r, int c, String word, TrieNode node, TrieNode root, char[][] board, Set<String> res, Set<String> visit){
        if(r < 0 || r >= ROWS || c < 0 || c >= COLS
            || !node.children.containsKey(board[r][c]) || (node.children.get(board[r][c]).refs < 1)
                || visit.contains(r+","+c)
        ){
          return;
        }

        visit.add(r+","+c);
        node = node.children.get(board[r][c]);
        word += board[r][c];
        boolean isWord = node.isWord;
        if(isWord){
            node.isWord = false;
            res.add(word);
            root.removeWord(word);
        }

        dfs(r,c+1,word,node,root,board,res,visit);
        dfs(r+1,c,word,node,root,board,res,visit);
        dfs(r,c-1,word,node,root,board,res,visit);
        dfs(r-1,c,word,node,root,board,res,visit);

        visit.remove(r+","+c);
    }
}
