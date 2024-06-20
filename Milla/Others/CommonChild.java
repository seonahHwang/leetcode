package Milla.Others;

import java.util.Arrays;

public class CommonChild {
    public static void main(String[] args) {
//        String s1 = "HARRY";
//        String s2 = "SALLY";
        String s1 = "ABCD";
        String s2 = "ABDC";
        System.out.println(commonChild(s1,s2));
    }
    public static int commonChild(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] matrix = new int[n+1][m+1];

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1]+1;
                }else {
                    matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
                }
            }
        }

        return matrix[n][m];
    }
}
