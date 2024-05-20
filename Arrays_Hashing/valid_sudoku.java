package Arrays_Hashing;

import java.util.Arrays;

public class valid_sudoku {
    public static void main(String[] args) {
//        char[][] board = new char[][]{
//                {'5','3','.','.','7','.','.','.','.'},
//        {'6','.','.','1','9','5','.','.','.'},
//        {'.','9','8','.','.','.','.','6','.'},
//        {'8','.','.','.','6','.','.','.','3'},
//        {'4','.','.','8','.','3','.','.','1'},
//        {'7','.','.','.','2','.','.','.','6'},
//        {'.','6','.','.','.','.','2','8','.'},
//        {'.','.','.','4','1','9','.','.','5'},
//        {'.','.','.','.','8','.','2','7','9'}};

        char[][] board = new char[][]{
                {'.','.','4','.','.','.','6','3','.'},
        {'.','.','.','.','.','.','.','.','.'},
        {'5','.','.','.','.','.','.','9','.'},
        {'.','.','.','5','6','.','.','.','.'},
        {'4','.','3','.','.','.','.','.','1'},
        {'.','.','.','7','.','.','.','.','.'},
        {'.','.','.','5','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.','.'}};
        
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int check[] = new int[10];
        int matrix[][] = new int[9][9];

        Arrays.fill(check,0);

        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.') continue;
                int num = Character.getNumericValue(board[i][j]);
                if(check[num] == 1) return false;
                check[num] = 1;
            }
            Arrays.fill(check,0);
        }

        Arrays.fill(check,0);

        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[j][i] == '.') continue;
                int num = Character.getNumericValue(board[j][i]);
                if(check[num] == 1) return false;
                check[num] = 1;
            }
            System.out.println();
            Arrays.fill(check,0);
        }

        Arrays.fill(check,0);

        int edge[][] = {{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
        for(int k=0;k<9;k++){
            int m = edge[k][0];
            int n = edge[k][1];
            for (int i=m;i<m+3;i++){
                for(int j=n;j<n+3;j++){
                    if(board[i][j] == '.') continue;
                    int num = Character.getNumericValue(board[i][j]);
                    if(check[num] == 1) return false;
                    check[num] = 1;
                }
            }
            Arrays.fill(check,0);
        }

        return true;
    }
}
