package Milla.Backtracking;

import java.util.LinkedList;

public class SearchForWord {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','D'},{'S','A','A','T'},{'A','C','A','E'}};
        String w = "CAT";
        System.out.println(board[0].length); //4
        System.out.println(board.length); //3

        System.out.println(exist(board,w));
    }

    public static boolean exist(char[][] board, String word) {
        boolean v[][] = new boolean[board.length][board[0].length];
        int dir[][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    LinkedList<Character> sub = new LinkedList<>();
                    sub.add(board[i][j]);
                    v[i][j] = true;
                    if(dfs(board,word,sub,dir,i,j,0,v)) return true;
                    v[i][j] = false;
                    sub.removeLast();
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board, String word, LinkedList<Character> sub, int dir[][], int x, int y, int idx, boolean[][] v){
        System.out.println("size"+sub.size()+", idx"+idx);
        if(word.length() == sub.size()){
            for (int i = 0; i < sub.size(); i++) {
                if(word.charAt(i) != sub.get(i)) return false;
            }
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if(nx >= board.length || ny >= board[0].length || nx < 0 || ny < 0 || v[nx][ny] || word.charAt(idx+1) != board[nx][ny]) continue;
            v[nx][ny] = true;
            sub.add(board[nx][ny]);
            if(dfs(board,word,sub,dir,nx,ny,idx+1,v)) return true;
            v[nx][ny] = false;
            sub.removeLast();
        }
        return false;
    }
}