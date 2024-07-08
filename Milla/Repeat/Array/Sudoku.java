package Milla.Repeat.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sudoku {
    public static void main(String[] args) {
        char a[][] = new char[][]{{'1','2','.','.','3','.','.','.','.'},
        {'4','.','.','5','.','.','.','.','.'},
        {'.','9','8','.','.','.','.','.','3'},
        {'5','.','.','.','6','.','.','.','4'},
        {'.','.','.','8','.','3','.','.','5'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','.','.','.','.','.','2','.','.'},
        {'.','.','.','4','1','9','.','.','8'},
        {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(a));
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer,HashSet<Character>> rows = new HashMap<>();
        Map<Integer,HashSet<Character>> cols = new HashMap<>();
        Map<Integer,HashSet<Character>> square = new HashMap<>();

        for(int r = 0; r < 9 ; r++){
            for(int c = 0; c < 9 ; c++){
                if(board[r][c] == '.') continue;
                char cell = board[r][c];

                if(rows.getOrDefault(r,new HashSet<>()).contains(cell) ||
                        cols.getOrDefault(c,new HashSet<>()).contains(cell) ||
                        square.getOrDefault((r/3)*3 + c/3,new HashSet<>()).contains(cell)
                ) return false;
                rows.computeIfAbsent(r,k -> new HashSet<>()).add(cell);
                cols.computeIfAbsent(c,k -> new HashSet<>()).add(cell);
                square.computeIfAbsent((r/3)*3 + c/3,k -> new HashSet<>()).add(cell);
            }
        }
        return true;
    }
}
